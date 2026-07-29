// sagas/authSaga.js
import { all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios'; // 외부연동
import { signupRequest, signupSuccess, signupFailure,
    fetchUserRequest, fetchUserSuccess, fetchUserFailure, resetUserState
} from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/api/users';

// --- 회원 가입 POST /api/users ---
export const signupApi = (userData) => axios.post( USER_API_BASE , userData );
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
function* watchsignup(){
    yield takeLatest(signupRequest.type, signup);
}

// --- 단건 조회 GET /api/users/1 ---
export const fetchUserApi = (userId) => axios.get( `${USER_API_BASE}/${userId}` );

export function* fetchUser(action) {
    try {
        const result = yield call(fetchUserApi, action.payload);
        yield put(fetchUserSuccess(result.data));
    } catch (err) {
        yield put(fetchUserFailure(err.response?.data?.message || err.message));
    }
}

function* watchFetchUser(){
    yield takeLatest(fetchUserRequest.type, fetchUser);
}

export default function* authSaga(){
    yield all([
        call(watchsignup),
        call(watchFetchUser),
    ]);
}