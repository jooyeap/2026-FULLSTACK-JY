// pages/index.js
import { useSelector, useDispatch } from "react-redux";
import React, { useDebugValue, useEffect, useState } from 'react';
import { useRouter } from "next/router";
import { fetchPostsRequest } from '../reducers/postReducer';
import { Card, Button, Spin } from 'antd';
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

    // VIEW
    return (
    <div>
        {/* 게시판 리스트 */}
        <h3> 게시글 : {posts.length}</h3>
        {posts.map( (post, index) => (
            <Card key={post.id || index} style={{marginBottom:"10px"}}>
                <p>{post.content}</p>
            </Card>
        ))}
        {/* 수정 모달 */}
    </div>
    );
}       