import { useSelector, useDispatch } from "react-redux";
import { useState, useEffect } from "react";
import { useRouter } from "next/router";
import { LOG_OUT_REQUEST,
         UPDATE_NICKNAME_REQUEST,
         DELETE_USER_REQUEST,
         LOAD_USER_REQUEST,
} from "../reducers/user";

export default function UsersPage(){
    // 1. 코드

    const dispatch = useDispatch(); // 1) 전역상태 -store 변화감지
    const router = useRouter(); // 3) 경로 - useRouter
    const {me, isLoading, error, users} = useSelector( (state) => state.user); // 2) 전역상태

    // 사용자 목록 불러오기
    useEffect( () => {
        if(!me) router.push('/login'); // 로그인이 안되어 있을때
        else dispatch({type: LOAD_USER_REQUEST}); // 사용자 목록 요청
    }, [me, router]);

    // 로그아웃
    const onLogout = (e) => {
        e.preventDefault();
        if(!confirm('로그아웃?')) return;

        dispatch({type:LOG_OUT_REQUEST});
    };

    // 로그아웃시 로그인 페이지로 이동
    useEffect( () => {
        if(me === null) router.push('/login');
    }, [me, router])

    // 유저 삭제
    const onDelete = (id) => {
        if(!confirm('유저삭제?')) return;

        dispatch({type:DELETE_USER_REQUEST, data: {id}});
    }

    // 닉네임 수정

    // 수정모드
    const [editId, setEditId] = useState(''); // 닉네임 수정할 id
    const onEdit = (id) => setEditId(id);

    // 수정처리
    const [newNickname, setNewNickname] = useState('');
    const onEditNickname = (id) => {
        dispatch({type:UPDATE_NICKNAME_REQUEST, data: {nickname:newNickname, id}})
        setEditId(null);
        setNewNickname('');
    };

    // const onChangeNickname = (id) => {
    //     const result = prompt('변경할 닉네임');
    //     if(!result) return;
    //     dispatch({type:UPDATE_NICKNAME_REQUEST, data: {nickname:result, id}})
    // };

    // 2. 뷰 - 렌더링
    return (
        <div className="container my-4">
            <h3 className="mb-3">사용자 목록</h3>
            {/* 로딩/에러 상태 표시 */}
            { isLoading && <div className="alert alert-info">로딩 중 ..</div>}
            { error && <div className="alert alert-danger">에러 메시지</div>}
            {/* 사용자 목록 테이블 */}
            <table className="table table-bordered table-striped table-hover">
                <caption>사용자 목록</caption>
                <thead>
                    <tr>
                        <th scope="col">EMAIL</th>
                        <th scope="col">NICKNAME</th>
                        <th scope="col">UPDATE/DELETE</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map( (u) => (<tr key={u.id}>
                        <td>{u.email}</td>
                        <td>
                            { editId === u.id
                            ? <input type="text" className="form-control" placeholder="새 닉네임 입력"
                                     value={newNickname} onChange={(e) => setNewNickname(e.target.value)}/>
                            : (u.nickname)
                            }
                        </td>
                        <td>
                            { editId !== u.id
                            ? <button className="btn btn-primary btn-sm me-2" onClick={() => onEdit(u.id)}>닉네임 수정</button>
                            : <button className="btn btn-primary btn-sm me-2" onClick={() => onEditNickname(u.id)}>수정 완료</button>
                            }
                            <button className="btn btn-danger btn-sm" onClick={() => onDelete(u.id)}>삭제</button>
                        </td>
                    </tr>))}
                </tbody>
            </table>
            {/* 로그아웃 */}
            <div>
                <button className="btn btn-secondary" onClick={onLogout}>로그아웃</button>
            </div>
        </div>
    );
};