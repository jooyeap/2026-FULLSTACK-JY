import { useSelector, useDispatch } from 'react-redux'; // 전역 상태, 상태 알림
import { useState, useEffect } from 'react'; // 변수상태변경, 이벤트 변경
import { useRouter } from 'next/router'; // 경로
import { SIGN_UP_REQUEST, SIGN_UP_SUCCESS, NICKNAME_CHECK_REQUEST,
         EMAIL_CHECK_REQUEST
 } from '../reducers/user';

// useSelector - 전역상태
// useDispatch - 스토어 알림
// useState - 변수
// useEffect - 이벤트 변경 감지
// useRouter - 경로

export default function JoinPage(){
    // 1. 코드
    const dispatch = useDispatch();
    const router = useRouter();
    // 1) Store : 전역상태 감지 useSelector
    // 수업 답안 적용시 / checkEmailLoading 추가
    const {me, isLoading, error, signUpDone, isCheck, isEmailCheck} = useSelector( (state) => state.user);
    // console.log("......", me);      
    //      변수, 변수셋팅함수
    const [email, setEmail] = useState('');       // let email = ''
    const [password, setPassword] = useState('');
    const [nickname, setNickname] = useState(''); // 3) 변수 상태 변경 = REACT DOM (useState)

    // 회원가입 요청 액션 dispatch
    const onSubmit = (e) => {
        e.preventDefault();

        // console.log(email.trim());
        // console.log(!email.trim()); !값이있다 -> true / 

        if(!email.trim()){
            alert('이메일을 입력해주세요.');
            return;
        }
        if(!password.trim()){
            alert('비밀번호를 입력해주세요.');
            return;
        }
        if(!nickname.trim()){
            alert('닉네임을 입력해주세요.');
            return;
        }
        if(isCheck === null || isCheck === true){
            alert('닉네임 중복검사는 필수입니다.');
            return;
        }
        if(isEmailCheck === null || isEmailCheck === true){
            alert('이메일 중복검사는 필수입니다.');
            return;
        }
        // 2) Store : 액션 알림 useDispatch
        dispatch({type:SIGN_UP_REQUEST, data:{email,password,nickname} });
        isCheck = null;
        isEmailCheck = null;
    };
    // 5) 상태 변화 감지
    useEffect( () => {
        if(signUpDone){ // 경로 변경
            router.push({
                pathname:'/login',
                query: { signUpSuccess : 'true' } // 회원가입 성공여부 주소표시창 줄
            });
        }
    }, [signUpDone, router]);

    // 로그인시 me의 값이 있다면
    useEffect( () => {
        if(me) router.push('/users');
    }, [me, router]);

    function setChangeEmail(){
        setEmail('..........');
    };

    // 닉네임 체크
    const onCheck = () => {
        if(!nickname){
            alert('닉네임 입력');
            return;
        }
        dispatch({type:NICKNAME_CHECK_REQUEST, data:nickname});
    };

    // 이메일 체크 수업 답안
    // const onCheckEmail = (e) => {
    //     e.preventDefault();
    //     if(!email.trim()){
    //         alert('이메일을 입력해주세요.')
    //         return;
    //     }
    //     dispatch({type:EMAIL_CHECK_REQUEST, data:email});
    // };

    // 이메일 체크
    const onEmailCheck = () => {
        if(!email.trim()){
            alert('이메일을 입력해주세요.');
            return;
        }
        dispatch({type:EMAIL_CHECK_REQUEST, data:email});
    };

    // 2. view - 렌더링 <></>, 공백 , 닫기태그
    return (
        <div className="container my-4">
            <h3 className="mb-3">회원가입</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/* 이메일 입력 */}
                <div className="mb-3 input-group">
                    <input type="email" className="form-control"
                           placeholder="이메일" title="이메일 입력"
                           value={email}
                           onChange={(e) => {setEmail(e.target.value);}}
                           />
                    <button type="button" className="btn btn-secondary" onClick={onEmailCheck}>중복 체크</button>
                </div>
                {isEmailCheck !== null && (isEmailCheck ?
                <div className="alert alert-danger">중복된 이메일입니다.</div> :
                <div className="alert alert-success">사용 가능합니다.</div>)}
                {/* 비밀번호 입력 */}
                <div className="mb-3">
                    <input type="password" className="form-control"
                           placeholder="비밀번호" title="비밀번호 입력"
                           value={password}
                           onChange={(p) => {setPassword(p.target.value);}}
                           />
                </div>
                {/* 닉네임 입력 */}
                <div className="mb-3 input-group">
                    <input type="text" className="form-control"
                           placeholder="닉네임" title="닉네임 입력"
                           value={nickname}
                           onChange={(n) => {setNickname(n.target.value);}}
                           />
                    <button type="button" className="btn btn-secondary" onClick={onCheck}>중복 체크</button>
                </div>
                {isCheck !== null && (isCheck ?
                <div className="alert alert-danger">중복된 닉네임입니다.</div> :
                <div className="alert alert-success">사용 가능합니다.</div>)}
                {/* 버튼 입력 */}
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary w-100"
                            disabled={isLoading}>회원가입</button>
                </div>
            </form>
            {/* 에러 메시지 */}
            {error && <div className="alert alert-danger mt-3">{error}</div> }
        </div>
    );
}
// 버튼 안쪽 답안
// {checkEmailLoading ? '확인 중' : '중복 확인'}

// 하단 메시지 답안
// {isCheck == true && <div className="text-success mb-2">사용 가능한 이메일입니다.</div>}
// {isCheck == false && <div className="text-danger mb-2">중복 된 이메일입니다.</div>}