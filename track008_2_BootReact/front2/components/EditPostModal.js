import { Button, Modal, Form, Input, Select, Upload} from "antd";
import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRouter } from "next/router";
import { createPostRequest, resetPostState } from "../reducers/postReducer";
import { UpOutlined } from "@ant-design/icons";

export default function EditPostModal({
    visible, onCancel, editPost, onSubmit, UploadFiles, setUploadFiles
}){
    const router = useRouter();
    const dispatch = useDispatch();
    const { loading, error, success } = useSelector( (state) => state.post);
    const { user } = useSelector( (state) => state.auth);
    const [fileList, setFileList] = useState([]);
    const [form] = Form.useForm();

    useEffect( () => {
        if(editPost) {
            form.setFieldValue({
                content: editPost.content,
                hashtags: editPost.hashtags || [],
            });
        }
    }, [editPost, form]);

    return(
        <Modal title="글 수정" open={visible} footer={null} onCancel={onCancel}>
            <Form 
                initialValues={{
                    content: editPost?.content,
                    hashtags: editPost?.hashtags
                }}
                onFinish={onSubmit}
                layout="vertical"
            >
                <Form.Item name="content" label="내용">
                    <Input.TextArea rows={4}/>
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
                        onChange={ ({fileList}) => 
                        setFileList(fileList.map((f) => f.originFileObj))}
                        listType="picture-card"
                    >
                        <Button icon={<UpOutlined/>}>이미지 선택</Button>
                    </Upload>
                </Form.Item>
                <Button type="primary" htmlType="submit">
                    수정완료
                </Button>
            </Form>
        </Modal>
    );
}