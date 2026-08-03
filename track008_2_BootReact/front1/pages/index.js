// pages/index.js
import { useSelector, useDispatch } from "react-redux"; // 전역 상태, 스토어 알림
import React, { useDebugValue, useEffect, useState } from 'react';
import Router, { useRouter } from "next/router";
import { fetchPostsRequest, updatePostRequest, deletePostRequest } from '../reducers/postReducer';
import { Card, Button, Spin } from 'antd';
import PostList from '../components/PostList';
import EditPostModal from '../components/EditPostModal';

// 실행 npm run dev
export default function Home(){

    const dispatch = useDispatch();
    // 1. 유저 정보 - state.auth
    const { user } = useSelector( (state) => state.auth);
    // 2. 게시글 정보 - state.post
    const { posts, loading, error } = useSelector( (state) => state.post);
    // 페이지가 처음 뜰때 게시글 조회 액션 - dispatch
    useEffect( () => {
        dispatch(fetchPostsRequest());
    }, [dispatch]);

    // 수정 모달 : isEditModalVisible, setIsEditModalVisible
    const [isEditModalVisible, setIsEditModalVisible] = useState(false);
    // 수정할 글 : editPost, setEditPost
    const [editPost, setEditPost] = useState(null);
    // 수정 기능 : handleEditSubmit
    const handleEdit = (post) => {
        setEditPost(post); // 수정 글 셋팅
        setIsEditModalVisible(true); // 수정 화면 보이기
    }

    const handleEditSubmit = (values) => {
        dispatch(
            updatePostRequest({ postId: editPost.id, dto:{ content: values.content }}) // 수정 기능 후
        ); 
        setIsEditModalVisible(false); // 화면 안보이게
        setEditPost(null);
    };

    // 삭제 기능
    const handleDelete = (postId) => {
        dispatch(
            deletePostRequest(postId)
        );
    }

    // VIEW
    return (
    <>
        <PostList 
            posts={posts}
            handleEdit={handleEdit}
            handleDelete={handleDelete}
        />
        <EditPostModal
            visible={isEditModalVisible}
            onCancel={() => setIsEditModalVisible(false)}
            editPost={editPost}
            onSubmit={handleEditSubmit}
        />
    </>
    );
}       