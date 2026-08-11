// sagas/__tests__/authSaga.test.js
// call - 동기 - 제너레이터 함수 (function*) 일시중단 / fork (비동기)
// put - redux 액션처리

import { call, put } from 'redux-saga/effects';
import axios from 'axios';
import {signupRequest, signupSuccess, signupFailure,
        fetchUserRequest, fetchUserSuccess, fetchUserFailure,
        loginRequest, loginSuccess, loginFailure,
        logoutRequest, logoutSuccess, logoutFailure,
        updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
        updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,
        resetUserState,
} from '../../reducers/authReducer';
import { signup, login, logout, updateNickname, updateProfileImage,

 } from '../authSaga';

jest.mock('axios');

describe('auth saga', () => {
    afterEach( () => {jest.clearAllMocks() });

    // 회원가입
    it('signup success', () => {
        const userData = { email: '1@1', password: '1' };
        const action = signupRequest(userData);
        const generator = signup(action);

        // 1. 1단계 API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        // 2. api 성공했다라는 가정하에 결과 값을 전달
        const mockResponse = { data: {id:1, email: '1@1'} };
        const putStep = generator.next( mockResponse).value;

        // 3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(signupSuccess(mockResponse.data)) );
        expect(generator.next().done).toBe(true);
    });
    // // 단건 조회
    // it('fetchUser success', () => {
    //     const action = fetchUserRequest(1);
    //     const generator = fetchUser(action);

    //     // 1. 1단계 API 호출 (call)
    //     expect(generator.next().value.type).toBe('CALL');

    //     // 2. api 성공했다라는 가정하에 결과 값을 전달
    //     const mockUser = { data: {id:1, email: '1@1'} };
    //     const putStep = generator.next(mockUser).value;

    //     // 3. 2단계 성공액션 디스패치
    //     expect(putStep).toEqual( put(fetchUserSuccess(mockUser.data)) );
    // });

    // 로그인
    it('login success', () => {
        const userData = {email:'1@1', password:'1'};
        const action = loginRequest(userData);
        const generator = login(action);

        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        const mockResponse = {data: {id:1, email:'1@1', nickname:'first'}};
        const putStep = generator.next(mockResponse).value;

        expect(putStep).toEqual( put(loginSuccess(mockResponse.data)));
        expect(generator.next().done).toBe(true);
    })

    // 로그아웃
    it('logout success', () => {
        //const userData = {email:'1@1', password:'1'};
        const action = logoutRequest();
        const generator = logout();

        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //const mockResponse = {data: {id:1, email:'1@1', nickname:'first'}};
        const putStep = generator.next().value;

        expect(putStep).toEqual( put(logoutSuccess()));
        expect(generator.next().done).toBe(true);
    });

    // 닉네임 수정
    it('updateNickname success', () => {
        const payload = {userId:1, nickname:'new'};
        const action = updateNicknameRequest(payload);
        const generator = updateNickname(action);

        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        const mockResponse = {data: {id:1, nickname:'new'}};
        const putStep = generator.next(mockResponse).value;

        expect(putStep).toEqual( put(updateNicknameSuccess(mockResponse.data)));
        expect(generator.next().done).toBe(true);
    });

    // 프로필 사진 수정
    it('updateProfileImage success', () => {
        const payload = {userId:1, file: new Blob(['test'])};
        const action = updateProfileImageRequest(payload);
        const generator = updateProfileImage(action);

        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        const mockResponse = {data: {id:1, ufile:'profile.png'}};
        const putStep = generator.next(mockResponse).value;

        expect(putStep).toEqual( put(updateProfileImageSuccess(mockResponse.data)));
        expect(generator.next().done).toBe(true);
    });
});