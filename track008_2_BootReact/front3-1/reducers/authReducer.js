// reducers/authReducer.js
import { createSlice } from "@reduxjs/toolkit";

// 1. 초기화 상태 (공용)
const initialState = {
    user: null,         // 단건 조회된 사용자 정보
    accessToken: null,  // 
    loading: false,     // 로딩 상태
    error: null,        // 에러 메세지
    success: false,     // 성공 여부 (insert 할때)
};

// 2. 상태 변화
const authReducer = createSlice({
    name: "auth",
    initialState ,
    reducers : {
        // --- 회원가입 ---
        signupRequest : (state) => {
            state.loading = true;
            state.error = null;
            state.success = false;
        },
        signupSuccess : (state, action) => {
            state.loading = false;
            //state.user = action.payload; // 가입된 회원 정보 저장

            state.success = true;
        },
        signupFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload; // 오류 메세지
            //state.success = false;
        },
        
        // --- 상태 초기화 ---
        resetUserState : (state) => {
            state.loading = false;
            state.error = null;
            state.success = false;
        },

        // --- 로그인 ( JWT 기반 user 정보 관리 ) ---
        loginRequest : (state) => {
            state.loading = true;
            state.error = null;
        },

        loginSuccess : (state, action) => {
            state.loading = false;
            // Map<String, Object> 리턴타입
            state.user = action.payload.user || null;  
            state.accessToken = action.payload.accessToken || null;
            // boot 리턴값
            // return ResponseEntity.ok(Map.of(
            //     "accessToken", accessToken,
            //     "user", user
        },

        loginFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
            state.user = null;
        },

        // 토큰 재발급
        refreshTokenRequest : (state) => {
            state.loading = true;
            
        },

        refreshTokenSuccess : (state, action) => {
            state.loading = false;
            state.accessToken = action.payload?.accessToken || null;
        },

        refreshTokenFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload.error;
        },


        // 로그아웃
        logoutRequest : (state) => {
            state.loading = true;
            //state.error = null;
        },

        logoutSuccess : (state) => {
            state.loading = false;
            state.error = null;
            state.user = null;
            state.accessToken = null;
            state.success = false;
        },

        logoutFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
        },

        // 닉네임 변경
        updateNicknameRequest : (state) => {
            state.loading = true;
            //state.error = null;
        },

        updateNicknameSuccess : (state, action) => {
            state.loading = false;
            state.user = action.payload;
        },

        updateNicknameFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
        },


        // 프로필 이미지 변경
        updateProfileImageRequest : (state) => {
            state.loading = true;
            //state.error = null;
        },

        updateProfileImageSuccess : (state, action) => {
            state.loading = false;
            state.user = action.payload;
        },

        updateProfileImageFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
        },

        // 유저 추가
        LoadUserRequest : (state) => {
            state.loading = true;
        },
        LoadUserSuccess : (state, action) => {
            state.loading = false;
            state.user = action.payload || null;
        },
        LoadUserFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
            state.user = null;
        },
    },
});

// 3. action 
export const {signupRequest, signupSuccess, signupFailure,
              fetchUserRequest, fetchUserSuccess, fetchUserFailure,
              loginRequest, loginSuccess, loginFailure,
              logoutRequest, logoutSuccess, logoutFailure,
              updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
              updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
              refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
              LoadUserRequest, LoadUserSuccess, LoadUserFailure,
              resetUserState,
} = authReducer.actions;

// 4. export
export default authReducer.reducer;