// sagas/authSaga.js
import { all, call, put, take, takeLatest } from 'redux-saga/effects';
import api from '../api/axios'; // 외부연동
import {signupRequest, signupSuccess, signupFailure,
        loginRequest, loginSuccess, loginFailure,
        logoutRequest, logoutSuccess, logoutFailure,
        updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
        updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
        refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
        LoadUserRequest, LoadUserSuccess, LoadUserFailure,
        resetUserState,
} from '../reducers/authReducer';
import Cookies from 'js-cookie';

const USER_API_BASE = '/auth';

// --- 회원 가입 POST /api/users ---
export const signupApi = (formData) => api.post( `${USER_API_BASE}/signup`, formData, {
    headers: {"Content-Type" : "multipart/form-data" },
} );
// 2. signup(action) - action.payload 사용자가 입력한 값 (회원정보)

// reducer
// 1. signupSuccess(userData) 실행하면 - {id=1, email="1@1"}
// 2. 리듀서 툴킷에서 { type: signupSuccess, payload: userdata } 객체 생성
// 3. 리듀서의 signupSuccess: (state,action) => {} 실행
//    action = { type:signupSuccess, payload:userData }

export function* signup(action) {
    try {
        const result = yield call( signupApi, action.payload ); // 3. result.data
        yield put(signupSuccess(result.data)); // 처리결과 put
    } catch (err) {
        yield put(signupFailure(err.response?.data?.message || err.message));
    }
}

// 1. takeLatest(signupRequest.type, signup) : takeLatest - 요청이 여러번와도 가장 마지막 발생 요청만 처리
function* watchSignup(){
    yield takeLatest(signupRequest.type, signup);
}

// 로그인
// POST : /auth/login
export const loginApi = ( payload ) => api.post( `${USER_API_BASE}/login`, payload);

export function* login(action) {
    // {email: '1@1', password:'1', provide:'local'}
    try {
        const result = yield call(loginApi, action.payload);
        /*
            boot controller
            result = ResponseEntity<Map<String, Object>>
            return ResponseEntity.ok(Map.of(
                "accessToken", accessToken,
                "user", user));
        */
        const accessToken = result.data?.accessToken;
        const user = result.data?.user;

        if(user && accessToken){
            if(typeof window != "undefined"){
                localStorage.setItem("accessToken", accessToken);
                Cookies.set("accessToken", accessToken);        
            }
        }
        yield put(loginSuccess({user, accessToken}));
    } catch (err) {
        yield put(loginFailure(err.response?.data?.message || err.message));
    }
}

function* watchLogin(){
    yield takeLatest(loginRequest.type, login);
}

// 토큰 재발급
export const refreshApi = () => { return api.post(`${USER_API_BASE}/refresh`); }

export function* refresh() {
    try{
        const result = yield call(refreshApi);
        const newAccessToken = result.data?.accessToken || null;

        // CSR 환경에서 localStorage와 쿠키에 저장
        if(typeof window != "undefined" && newAccessToken){
            localStorage.setItem("accessToken", newAccessToken);
            Cookies.set("accessToken".newAccessToken);
        }
        yield put(refreshTokenSuccess({accessToken : newAccessToken}));
    } catch (err) {
        yield put(refreshTokenFailure(err.response?.data?.message || err.message));
        yield put(logout());
    }

}

// 로그아웃
// POST : /auth/logout 넘겨줄 데이터 X
export const logoutApi = () => api.post(`${USER_API_BASE}/logout`);

export function* logout() {
    // {email: '1@1', password:'1', provide:'local'}
    try {
        yield call(logoutApi);
        if(typeof window != "undefined"){
            localStorage.removeItem("accessToken");
            Cookies.remove("accessToken");
        }
        yield put(logoutSuccess());
    } catch (err) {
        yield put(logoutFailure(err.response?.data?.message || err.message));
    }
}

function* watchLogout(){
    yield takeLatest(logoutRequest.type, logout);
}

// 닉네임 수정
// PATCH : /auth/{userId}/nickname , params를 통해서 닉네임 넘기기
export const updateNicknameApi = ({userId, nickname}) => api.patch( `${USER_API_BASE}/${userId}/nickname`, null, {
    params:{nickname},
});

export function* updateNickname(action) {
    // {email: '1@1', password:'1', provide:'local'}
    try {
        const result = yield call(updateNicknameApi, action.payload);
        yield put(updateNicknameSuccess(result.data));
    } catch (err) {
        yield put(updateNicknameFailure(err.response?.data?.message || err.message));
    }
}

function* watchUpdateNickname(){
    yield takeLatest(updateNicknameRequest.type, updateNickname);
}

// 프로필 사진 변경
// PATCH : /auth/{userId}/profile-image , formData
export function updateProfileImageApi({userId,file}){
    const formData = new FormData();
    formData.append("ufile", file);
    return api.patch(`${USER_API_BASE}/${userId}/profile-image`, formData,{
        headers : {"Content-Type" : "multipart/form-data"}
    });
}
export function* updateProfileImage(action) {
    try {
        const result = yield call(updateProfileImageApi, action.payload);
        yield put(updateProfileImageSuccess(result.data));
    } catch (err) {
        yield put(updateProfileImageFailure(err.response?.data?.message || err.message));
    }
}

function* watchUpdateProfileImage(){
    yield takeLatest(updateProfileImageRequest.type, updateProfileImage);
}

// 유저 정보 로드
export const loadUserApi = (cookieHeader) => {api.get(`${USER_API_BASE}/me`,{
    headers: {cookie : cookieHeader || ""},
    withCredentials : true,
})};
export function* loadUser(action){
    try {
        const result = yield call(loadUserApi, action.payload?.cookie);
        yield put(LoadUserSuccess(result.data));
    } catch (err) {
        yield put(LoadUserFailure(err.response?.data?.message || err.message));
    }
}
function* watchLoadUser(){
    yield takeLatest(LoadUserRequest.type, loadUser);
}

export default function* authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
        call(watchLoadUser),
    ]);
}