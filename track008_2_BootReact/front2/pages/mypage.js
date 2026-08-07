// pages/mypage.js
// 1. require / import
import React, { useEffect, useState } from "react";
import { UploadOutlined } from "@ant-design/icons";
import { useDispatch, useSelector } from "react-redux";
import { Button, Card, Descriptions, Avatar, Form, Input, Upload, message } from "antd";    
import { useRouter } from "next/router";
import { updateNicknameRequest, updateProfileImageRequest } from "../reducers/authReducer";


export default function MyPage(){
    // Redux에서 회원 가입시 저장된 사용자 정보 가져오기 - user
    const {user, loading, error} = useSelector( (state) => state.auth);
    const router = useRouter();
    const dispatch = useDispatch();
    const [fileList, setFileList] = useState([]);
    if(!user){
        return (
            <div style={{maxWidth: 600, margin: "40px auto"}}>
                <p>로그인된 사용자가 없습니다.</p>
                <Button type="primary" onClick={ () => router.push(`signup`)}>
                    회원가입
                </Button>
            </div>
        );
    }

    const onUpdateNickname = (value) => {
        console.log(value);
        dispatch(updateNicknameRequest({userId: user.id, nickname: value.nickname }));       
    }

    return(
        <div style={{ maxWidth: 600, margin: "40px auto"}}>
            <Card title="마이페이지 (회원 정보)">
                <div style={{display:"flex", alignItems:"center", gap:"20px"}}>
                    <Avatar src={`http://localhost:8080/${user.ufile}`} size={64}>{user.nickname?.[0]}</Avatar>
                    <Descriptions title="User Info" bordered column={1}>
                        <Descriptions.Item label="회원 번호">{user.id}</Descriptions.Item>
                        <Descriptions.Item label="이메일">{user.email}</Descriptions.Item>
                        <Descriptions.Item label="닉네임">{user.nickname}</Descriptions.Item>
                    </Descriptions> 
                </div>
                {/*닉네임 수정 - Q1. updateNicknameRequest 호출*/}
                <Form  
                    onFinish={onUpdateNickname}
                    layout="inline"
                    style={{ marginBottom: 20, marginTop: 40 }}
                >
                    <Form.Item
                        name="nickname" 
                    >
                        <Input placeholder="새 닉네임" />
                    </Form.Item>
                    <Button type="primary" htmlType="submit">닉네임 변경</Button>
                </Form>
                {/*프로필 이미지 수정 - Q2. updateProfileImage 호출*/}
                <Form 
                    layout="inline"
                    style={{ marginBottom: 20 }}
                >
                    <Form.Item>
                        <Upload  
                            beforeUpload={ () => false }
                            fileList={fileList}
                            onChange={ ({fileList}) => setFileList(fileList)}
                            maxCount={1}
                        >
                            <Button icon={<UploadOutlined />}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>
                    <Button
                        type="primary"  
                        onClick={ () => {
                            if( !user || fileList.length === 0 ){
                                message.warning("변경할 이미지를 선택해주세요.");
                                return;
                            }
                            const file = fileList[0]?.originFileObj;
                            dispatch( updateProfileImageRequest({
                                userId: user.id,
                                file
                            }))
                            setFileList([]); // 전송 후 파일 선택 목록 초기화
                        }}
                    >
                        프로필 이미지 변경
                    </Button>
                </Form> 
            </Card>
            
        </div>
    )
}