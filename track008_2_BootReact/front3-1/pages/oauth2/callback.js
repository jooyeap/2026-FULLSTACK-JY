// 1. import, require [ ]

// useSelector  - 전역상태 / useDispatch  - 스토어알림
// useState     - 변수 / useEffect    - 이벤트변경감지
// useRouter    - 경로
import { useDispatch } from "react-redux";
import { useEffect, useRef } from "react";
import { useRouter } from "next/router";
import { loginSuccess } from "../../reducers/authReducer";
import axios from 'axios';


// 2. 부품 + export
export default function OAuth2CallbackPage() {
    const router = useRouter();     // 경로 이동
    const dispatch = useDispatch(); // 스토어 알림

    useEffect( () => {
        if(!router.isReady) return;
        const {accessToken} = router.query;
        if(accessToken) {
            try{
                localStorage.setItem("accessToken" , accessToken);  // 토큰 저장
                fetchUser(accessToken);  // 사용자 정보를 요청
            }catch(err){
                console.error( "OAuth2 callback error:", err);
                router.push("/login");
            }    
        }
    }, [router.isReady, router.query]);

    const fetchUser = async (accessToken) => {
        try {
            const res = await axios.get("http://localhost:8080/auth/me", {
                headers: { Authorization: `Bearer ${accessToken}` },
                withCredentials: true, // 쿠키 전송용
            });
            const user = res.data;
            dispatch(loginSuccess({user, accessToken}));
            router.push("/mypage");
        } catch (err) {
            console.error("User fetch error:", err);
            router.push("/login");
        }
    };

    return (<p>소셜 로그인 처리 중 입니다.</p>);
}