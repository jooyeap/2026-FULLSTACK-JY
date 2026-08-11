// reducer/postReducer.js

import { createSlice } from "@reduxjs/toolkit";

const initialState={
    posts : [] , // 전체 게시글 목록
    currentPost : null, // 단건 조회된 상세 게시글
    loading : false,
    error : null,
    fetchSuccess : false,
    createSuccess : false,
    updateSuccess : false,
    deleteSuccess : false
};

const postReducer = createSlice({
    name: "post",
    initialState,
    reducers:{
        // 전체 게시글
        fetchPostsRequest : (state) => {
            state.loading = true;
            state.error = null;
            state.fetchSuccess = false;
        },
        fetchPostsSuccess : (state, action) => {
            state.loading = false;
            state.posts = action.payload;
            state.fetchSuccess = true;
        },
        fetchPostsFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
            state.fetchSuccess = false;
        },

        // 단건 게시글
        fetchPostDetailRequest : (state) => {
            state.loading = true;
            state.error = null;
            state.fetchSuccess = false;
        },
        fetchPostDetailSuccess : (state, action) => {
            state.loading = false;
            state.currentPost = action.payload;
            state.fetchSuccess = true;
        },
        fetchPostDetailFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
            state.fetchSuccess = false;
        },

        // 게시글 작성
        createPostRequest : (state) => {
            state.loading = true;
            state.error = null;
            state.createSuccess = false;
        },
        createPostSuccess : (state, action) => {
            state.loading = false;

            // 새글을 목록 상단에 추가 / 아래 두코드 결과물 같음
            //state.posts = [action.payload, ...state.posts];
            state.posts.unshift(action.payload);
            // action.payload - 새로 작성된 게시글 / unshift 배열의 맨앞에 새 요소 추가 (직접 배열 수정)

            state.createSuccess = true;
        },
        createPostFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
            state.createSuccess = false;
        },
        // 게시글 수정
        updatePostRequest : (state) => {
            state.loading = true;
            state.error = null;
            state.updateSuccess = false;
        },
        updatePostSuccess : (state, action) => {
            state.loading = false;
            state.posts = state.posts.map( post => 
                post.id === action.payload.id ? action.payload : post                
            );
            state.currentPost = action.payload;
            state.updateSuccess = true;
        },
        updatePostFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
            state.updateSuccess = false;
        },
        // 게시글 삭제
        deletePostRequest : (state) => {
            state.loading = true;
            state.error = null;
            state.deleteSuccess = false;
        },
        deletePostSuccess : (state, action) => {
            state.loading = false;
            // 삭제된 게시글의 id를 받아서 목록에서 제외
            state.posts = state.posts.filter(post => post.id !== action.payload);
            state.deleteSuccess = true;
        },
        deletePostFailure : (state, action) => {
            state.loading = false;
            state.error = action.payload;
            state.deleteSuccess = false;
        },
        // 상태 초기화
        resetPostState : (state) => {
            state.loading = false;
            state.error = null;
            state.fetchSuccess = false;
            state.createSuccess = false;
            state.updateSuccess = false;
            state.deleteSuccess = false;
        }
    }
});

export const {
fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
createPostRequest, createPostSuccess, createPostFailure, 
updatePostRequest, updatePostSuccess, updatePostFailure,
deletePostRequest, deletePostSuccess, deletePostFailure,
resetPostState
} = postReducer.actions;

export default postReducer.reducer;