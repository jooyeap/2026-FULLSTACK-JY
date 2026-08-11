// sagas/__test__/postSaga.test.js
import { all, call, put, takeLatest } from 'redux-saga/effects';
import axios from 'axios'; // 외부연동
import { fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
         fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
         createPostRequest, createPostSuccess, createPostFailure, 
         updatePostRequest, updatePostSuccess, updatePostFailure,
         deletePostRequest, deletePostSuccess, deletePostFailure,
         resetPostState
} from '../../reducers/postReducer';
import { fetchPosts, fetchPostDetail, createPost,
         updatePost, deletePost
} from '../postSaga';

jest.mock('axios');
describe('post saga', () => {

    // 전체 글 조회
    it('fetchPosts success', () => {
        // 1. 화면 요청
        const generator = fetchPosts(fetchPostsRequest())
        expect(generator.next().value.type).toBe('CALL');
        // 2. 결과물 받기
        const mockData = [{id:1, content: 'post 1'}];
        const putStep = generator.next({data:mockData}).value;
        // 3. 결과물 확인
        expect(putStep).toEqual(put(fetchPostsSuccess(mockData)));
    });

    // 단건 조회
    it('fetchPostDetail success', () => {
        const generator = fetchPostDetail(fetchPostDetailRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 1, content: 'detail' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(fetchPostDetailSuccess(mockData)));
    });

    // 글 쓰기
    it('createPost success', () => {
        const payload = { content: 'new' };
        const generator = createPost(createPostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const mockData = { id: 10, content: 'new' };
        const putStep = generator.next({ data: mockData }).value;
        
        expect(putStep).toEqual(put(createPostSuccess(mockData)));
    });

    // 글 수정
    it('updatePost success', () => {
        const payload = { id: 10, content: 'updated' };
        const generator = updatePost(updatePostRequest(payload));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next({ data: payload }).value;
        
        expect(putStep).toEqual(put(updatePostSuccess(payload)));
    });

    // 글 삭제
     it('deletePost success', () => {
        const generator = deletePost(deletePostRequest(1));
        
        expect(generator.next().value.type).toBe('CALL');
        
        const putStep = generator.next().value;
        
        expect(putStep).toEqual(put(deletePostSuccess(1)));
    });
})