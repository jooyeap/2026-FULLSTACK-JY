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
function AppLayout({ children, initialUser}){ // 대체부품, 초기값

    const [ drawerOpen, setDrawerOpen ] = useState(false); // 변수, 셋팅함수

    const menuItems = [
        { key: "new",     label: <Link href="/posts/new">✏️ NEW POST</Link> },
        { key: "profile", label: <Link href="/mypage">👤 MYPAGE </Link> },
        { key: "home",    label: <Link href="/signup">🏠 JOIN</Link> },
    ];

    // #1) Row - Col / Col
    // #2) 반응형 속성 (모바일 - xs, sm / 태블릿 - md / PC - lg) - 24칸 기준
    // display:"flex" 자식 요소 배치 알아서
    // justify="space-between" 양쪽에 콘텐츠 배치
    return (<Layout>
    {/* Header */}
    <Header style={{display:"flex"}}>
        <Row align={"middle"} justify={"space-between"} style={{width:"100%"}}>
            <Col flex={"none"}>
                <Link href="/">
                    <a style={{color:"#fff", fontWeight:"bold", fontSize:"18px"}}>
                        THE703 (POST VER)
                    </a>
                </Link>
            </Col>
            {/* xs,sm (모바일) 0 숨김처리, md (태블릿) 16, lg (PC) 18 || 총 24칸 */}
            <Col flex={"auto"} xs={0} sm={0} md={16} lg={18}>
                <Menu
                theme="dark"
                mode="horizontal"
                items={menuItems}
                />
            </Col>
            {/* button 종류 : primary, default(하얀색), text(투명), link(a) */}
            <Col flex={"none"} xs={2} md={0}>
                <Button type={"text"} 
                icon={<MenuOutlined style={{color: "#fff", fontSize: 20}}/>}
                onClick={() => setDrawerOpen(true)}>
                </Button>
            </Col>
        </Row>
    </Header>

    <Drawer
        title="Basic Drawer"
        placement='right'
        onClose={() => setDrawerOpen(false)}
        open={drawerOpen}
      >
        <Menu
        mode="vertical"
        items={menuItems}
        />
    </Drawer>

    <Content style={{padding: "40px"}}>{children}</Content>

    </Layout>);
}
// 3. export
export default AppLayout; 