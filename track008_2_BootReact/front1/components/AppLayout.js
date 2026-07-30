// Layout: https://ant.design/components/layout 
// Menu: https://ant.design/components/menu 
// Input: https://ant.design/components/input 
// Drawer: https://ant.design/components/drawer 
// Grid(Row/Col): https://ant.design/components/grid 
// Button: https://ant.design/components/button

// components/AppLayout.js

// 1. require
import { useSelector, useDispatch } from 'react-redux'; // 전역 상태, 액션 -> 스토어 알림
import { useRouter } from 'next/router'; // 경로 이동
import { useEffect, useState } from 'react'; // 이벤트 변경 감지, 변수
import Link from 'next/link';
import { Layout, Menu, Input, Row, Col, Drawer, Button, Grid } from "antd";  
import { MenuOutlined, SearchOutlined } from "@ant-design/icons";  

const {Header, Content} = Layout; // <Layout.Header> -> <Header>
const {useBreakpoint} = Grid;

// 2. 부품
// header / Deawer
function AppLayout(){

    const menuItems = [
        { key: "new",     label: <Link href="/posts/new">✏️ NEW POST</Link> },
        { key: "profile", label: <Link href="/mypage">👤 MYPAGE </Link> },
        { key: "home",    label: <Link href="/signup">🏠 JOIN</Link> },
    ];

    //////////////////////////////////////
    return (<Layout>
    {/* Header */}
    <Header style={{display:"flex"}}>
        <Row justify={"space-between"} style={{width:"100%"}}>
            <Col flex={"none"}>
                <Link href="/">
                    <a style={{color:"#fff", fontWeight:"bold", fontSize:"18px"}}>
                        THE703 (POST VER)
                    </a>
                </Link>
            </Col>
            <Col flex={"auto"}>
                <Menu
                theme="dark"
                mode="horizontal"
                items={menuItems}
                />
            </Col>
        </Row>
    </Header>
    <Content>
        ㅇㅅㅇ
    </Content>
    </Layout>);
}
// 3. export
export default AppLayout;