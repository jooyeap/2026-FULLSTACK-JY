/*
    reducers/user.js
    ---------------------------
    사용자 관련 상태 ( user state ) 를 관리하는 리듀서
    - 로그인, 로그아웃, 회원가입, 사용자목록, 닉네임수정, 사용자삭제
    - 1. 각 액션타입 정의 2. 초기상태 3. reducer 함수
*/

// 1. 각 액션타입 정의
export const LOG_IN_REQUEST = 'LOG_IN_REQUEST'; // 로그인 요청
export const LOG_IN_SUCCESS = 'LOG_IN_SUCCESS'; // 로그인 성공
export const LOG_IN_FAILURE = 'LOG_IN_FAILURE'; // 로그인 실패

export const LOG_OUT_REQUEST = 'LOG_OUT_REQUEST'; // 로그아웃 요청
export const LOG_OUT_SUCCESS = 'LOG_OUT_SUCCESS'; // 로그아웃 성공
export const LOG_OUT_FAILURE = 'LOG_OUT_FAILURE'; // 로그아웃 실패

export const SIGN_UP_REQUEST = 'SIGN_UP_REQUEST'; // 회원가입 요청
export const SIGN_UP_SUCCESS = 'SIGN_UP_SUCCESS'; // 회원가입 성공
export const SIGN_UP_FAILURE = 'SIGN_UP_FAILURE'; // 회원가입 실패

export const LOAD_USER_REQUEST = 'LOAD_USER_REQUEST'; // 사용자 목록 요청
export const LOAD_USER_SUCCESS = 'LOAD_USER_SUCCESS'; // 사용자 목록 성공
export const LOAD_USER_FAILURE = 'LOAD_USER_FAILURE'; // 사용자 목록 실패

export const UPDATE_NICKNAME_REQUEST = 'UPDATE_NICKNAME_REQUEST'; // 닉네임 수정 요청
export const UPDATE_NICKNAME_SUCCESS = 'UPDATE_NICKNAME_SUCCESS'; // 닉네임 수정 성공
export const UPDATE_NICKNAME_FAILURE = 'UPDATE_NICKNAME_FAILURE'; // 닉네임 수정 실패

export const DELETE_USER_REQUEST = 'DELETE_USER_REQUEST'; // 사용자 삭제 요청
export const DELETE_USER_SUCCESS = 'DELETE_USER_SUCCESS'; // 사용자 삭제 성공
export const DELETE_USER_FAILURE = 'DELETE_USER_FAILURE'; // 사용자 삭제 실패

export const EMAIL_CHECK_REQUEST = 'EMAIL_CHECK_REQUEST'; // 이메일 체크 요청
export const EMAIL_CHECK_SUCCESS = 'EMAIL_CHECK_SUCCESS'; // 이메일 체크 성공
export const EMAIL_CHECK_FAILURE = 'EMAIL_CHECK_FAILURE'; // 이메일 체크 실패

export const NICKNAME_CHECK_REQUEST = 'NICKNAME_CHECK_REQUEST'; // 닉네임 체크 요청
export const NICKNAME_CHECK_SUCCESS = 'NICKNAME_CHECK_SUCCESS'; // 닉네임 체크 성공
export const NICKNAME_CHECK_FAILURE = 'NICKNAME_CHECK_FAILURE'; // 닉네임 체크 실패

// 2. 초기상태
export const initialState={
    me: null, // 로그인 사용자 정보 { id, email, nickname }
    users: [], // 전체 사용자 목록  [{id, email, nickname}]
    isLoading: false, // api 요청중 여부
    error: null, // 에러 메세지
    signUpDone: false, // 회원가입 완료 여부
    isCheck: null, // 닉네임 중복 여부
    isEmailCheck: null, // 이메일 중복 여부

    checkEmailLoading: false,
    checkEmailDone: false,
    checkEmailError: null,
}

// 3. reducer 함수
const reducer = ( state=initialState, action ) => { // 현재상태, 요청액션
    switch( action.type ){
        // 요청 액션 -> 로딩 시작
        case EMAIL_CHECK_REQUEST:
        case NICKNAME_CHECK_REQUEST:
        case LOG_IN_REQUEST:
        case LOG_OUT_REQUEST:
        case SIGN_UP_REQUEST:
        case LOAD_USER_REQUEST:
        case UPDATE_NICKNAME_REQUEST:
        case DELETE_USER_REQUEST:
            return { ...state, isLoading: true, error: null };

        // 수업 답안
        // case EMAIL_CHECK_REQUEST:
        //     return {
        //         checkEmailLoading: true,
        //         checkEmailDone: false,
        //         checkEmailError: null,
        //         isCheck: null
        //     };

        // 성공 액션 -> 상태 업데이트
        case EMAIL_CHECK_SUCCESS:
            return { ...state, isLoading: false, isEmailCheck: action.data };
        case NICKNAME_CHECK_SUCCESS:
            return { ...state, isLoading: false, isCheck: action.data };
        case LOG_IN_SUCCESS:
            return { ...state, isLoading: false, me: action.data };
        case LOG_OUT_SUCCESS:
            return { ...state, isLoading: false, me: null };
        case SIGN_UP_SUCCESS:
            return { ...state, isLoading: false, signUpDone: true };
        case LOAD_USER_SUCCESS:
            return { ...state, isLoading: false, users: action.data };
        case UPDATE_NICKNAME_SUCCESS:
            return { ...state, isLoading: false,
                     me: state.me && state.me.id === action.data.id ?
                     { ...state.me, nickname: action.data.nickname } :
                     state.me,
                     users: state.users.map( (u) =>
                        u.id === action.data.id ? {...u, nickname: action.data.nickname } : u
                    ),
            };
        case DELETE_USER_SUCCESS:
            return { ...state, isLoading: false,
                     me : state.me?.id === action.data.id? null : state.me,
                     users: state.users.filter( (u) => u.id !== action.data.id )
            };

        // 수업답안
        // case EMAIL_CHECK_SUCCESS:
        //     return {
        //         ...state,
        //         checkEmailLoading: false,
        //         checkEmailDone: true,
        //         isCheck: action.data.isAvailable,
        //     }

        // 실패 액션 -> 에러 메세지 저장
        case EMAIL_CHECK_FAILURE:
        case NICKNAME_CHECK_FAILURE:
        case LOG_IN_FAILURE:
        case LOG_OUT_FAILURE:
        case SIGN_UP_FAILURE:
        case LOAD_USER_FAILURE:
        case UPDATE_NICKNAME_FAILURE:
        case DELETE_USER_FAILURE:
            return { ...state, isLoading: false, error: action.error?.message || action.error };

        // 수업답안
        // case EMAIL_CHECK_FAILURE:
        //     return { ...state,
        //              checkEmailLoading: false,
        //              checkEmailError: action.error,
        //              isCheck: false,
        //     }

        // 기본값 -> 상태 변경 없음
        default:
            return state;
    }
};
export default reducer;
