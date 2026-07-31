// pages/posts/new.js
// 1. import
import React, { useEffect, useState} from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { Button, Card, Descriptions, Form, Input, message } from "antd";    
import { createPostRequest } from "../../reducers/postReducer";
// 2. export + 부품

export default function NewPostPage(){
    // 1. 유저 정보 가져오기 (useSelector)
    const router = useRouter();
    const dispatch = useDispatch();
    // 글정보
    const { loading, error } = useSelector( (state) => state.post);
    // 유저정보
    const { user } = useSelector( (state) => state.auth);


    const onFinish = ( values ) => {
        const sendData = {
            userId: 101, //user.Id,
            content: values.content
        };
        dispatch(createPostRequest(sendData));
        message.success("작성 요청 완료");
        router.push("/");
    };

    // 2. 게시글 작성 (dispatch(createPostRequest(dto)) : 이벤트발생알림)
    return (
        <Card title="게시글 작성" style={{ maxWidth: 600, margin: "40px auto"}}>
            <Form layout="vertical" onFinish={onFinish}>
                <Form.Item
                    label="내용"
                    name="content"
                    hasFeedback
                    rules={[ {required: true, message: '내용을 입력하세요.'} ]}
                >
                    <Input.TextArea rows={4} placeholder="내용을 입력하세요."/>
                </Form.Item>
                <Button type="primary" htmlType="submit"  loading={loading}>
                    게시글 작성
                </Button>
                {error && <p style={{color: "red"}}>{error}</p>}
            </Form>
        </Card>
    );
}