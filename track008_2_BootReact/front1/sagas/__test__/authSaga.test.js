// sagas/__tests__/authSaga.test.js
// call - 동기 - 제너레이터 함수 (function*) 일시중단 / fork (비동기)
// put - redux 액션처리

import { call, put } from 'redux-saga/effects';
import axios from 'axios';
import {signupRequest, signupSuccess, signupFailure,
        fetchUserRequest, fetchUserSuccess, fetchUserFailure,
        resetUserState,
} from '../../reducers/authReducer';
import { signup, fetchUser } from '../authSaga';

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
    // 단건 조회
    it('fetchUser success', () => {
        const action = fetchUserRequest(1);
        const generator = fetchUser(action);

        // 1. 1단계 API 호출 (call)
        expect(generator.next().value.type).toBe('CALL');

        // 2. api 성공했다라는 가정하에 결과 값을 전달
        const mockUser = { data: {id:1, email: '1@1'} };
        const putStep = generator.next(mockUser).value;

        // 3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(fetchUserSuccess(mockUser.data)) );
    });
});