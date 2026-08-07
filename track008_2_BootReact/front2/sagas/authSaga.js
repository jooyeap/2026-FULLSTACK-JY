// sagas/authSaga.js
import { all, call, put, take, takeLatest } from 'redux-saga/effects';
import axios from 'axios'; // 외부연동
import {signupRequest, signupSuccess, signupFailure,
        fetchUserRequest, fetchUserSuccess, fetchUserFailure,
        loginRequest, loginSuccess, loginFailure,
        logoutRequest, logoutSuccess, logoutFailure,
        updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
        updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
        resetUserState,
} from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/auth';

// --- 회원 가입 POST /api/users ---
export const signupApi = (formData) => axios.post( `${USER_API_BASE}/signup`, formData, {
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
export const loginApi = ( payload ) => axios.post( `${USER_API_BASE}/login`, payload);

export function* login(action) {
    // {email: '1@1', password:'1', provide:'local'}
    try {
        const result = yield call(loginApi, action.payload);
        yield put(loginSuccess(result.data));
    } catch (err) {
        yield put(loginFailure(err.response?.data?.message || err.message));
    }
}

function* watchLogin(){
    yield takeLatest(loginRequest.type, login);
}

// 로그아웃
// POST : /auth/logout 넘겨줄 데이터 X
export const logoutApi = () => axios.post(`${USER_API_BASE}/logout`);

export function* logout() {
    // {email: '1@1', password:'1', provide:'local'}
    try {
        yield call(logoutApi);
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
export const updateNicknameApi = ({userId, nickname}) => axios.patch( `${USER_API_BASE}/${userId}/nickname`, null, {
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
    return axios.patch(`${USER_API_BASE}/${userId}/profile-image`, formData,{
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

export default function* authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
    ]);
}