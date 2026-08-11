// pages/posts/new.js
// 1. import
import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { Button, Card, Descriptions, Form, Input, message, Upload, Select } from "antd";    
import { createPostRequest, resetPostState } from "../../reducers/postReducer";
import { UpOutlined } from "@ant-design/icons";
// 2. export + 부품

export default function NewPostPage(){
    // 1. 유저 정보 가져오기 (useSelector)
    const router = useRouter();
    const dispatch = useDispatch();
    // 글정보
    const { loading, error, createSuccess } = useSelector( (state) => state.post);
    // 유저정보
    const { user } = useSelector( (state) => state.auth);

    const [fileList, setFileList] = useState([]);

    // 2. 게시글 작성 (dispatch(createPostRequest(dto)) : 이벤트발생알림)
    // {userId, dto, files}
    const onFinish = ( values ) => {
        const dto = {
            content: values.content,
            hashtags: values.hashtags? values.hashtags.join(",") : ""
        };
        const files = fileList.map( (f) => f.originFileObj );

        dispatch(createPostRequest({userId: user.id, dto, files}));
    };

    // useSelect(전역) / useDispatch (알림) / useState (변수) / useEffect(이벤트 변화 감지)
    useEffect (() => {
        if(createSuccess) { 
            message.success("게시글이 성공적으로 작성되었습니다.");
            setFileList([]);
            dispatch(resetPostState());
            router.push("/");
        }
        return () => { if(createSuccess) dispatch(resetPostState());}
    },[createSuccess, router, dispatch])

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

                {/* 해시태그 입력 */}
                <Form.Item
                    label="해시태그"
                    name="hashtags"
                >
                    <Select 
                        mode="tags"
                        style={{width:"100%"}}
                        placeholder="해시태그 입력 후 Enter"
                    />
                </Form.Item>

                {/* 이미지 업로드 */}
                <Form.Item label="이미지 업로드">
                    <Upload
                        multiple
                        beforeUpload={()=>false}
                        fileList={fileList}
                        onChange={ ({fileList}) => setFileList(fileList)}
                        listType="picture-card"
                    >
                        <Button icon={<UpOutlined/>}>이미지 선택</Button>
                    </Upload>
                </Form.Item>

                <Button type="primary" htmlType="submit"  loading={loading}>
                    게시글 작성
                </Button>
                {error && <p style={{color: "red"}}>{error}</p>}
            </Form>
        </Card>
    );
}