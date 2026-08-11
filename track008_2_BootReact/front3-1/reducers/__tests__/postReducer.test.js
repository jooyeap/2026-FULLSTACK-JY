// __tests__/postReducer.test.js
import postReducer, {
fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
fetchPostDetailRequest, fetchPostDetailSuccess, fetchPostDetailFailure,
createPostRequest, createPostSuccess, createPostFailure, 
updatePostRequest, updatePostSuccess, updatePostFailure,
deletePostRequest, deletePostSuccess, deletePostFailure,
resetPostState
} from '../postReducer'

describe('post slice reducer', () => {
    const initialState = {
        posts : [] , // 전체 게시글 목록
        currentPost : null, // 단건 조회된 상세 게시글
        loading : false,
        error : null,
        success : false
    }

    it('fetchPostsRequest', () => {
        let state = postReducer( initialState, fetchPostsRequest() );
        // 1. fetchPostsRequest() 실행 - 인자 없음
        // 2. 리듀서 툴킷 - {type:fetchPostsRequest, payload:undifined} 객체 만들기
        // 3. 리듀서의 fetchPostsRequest: (state, action) => {}
        //    action = {type:fetchPostsRequest, payload:undifned}
        expect(state.loading).toBe(true);
        expect(state.success).toBe(false);
        expect(state.error).toBeNull();
    });

    it('fetchPostsSuccess', () => {
        const posts = [ {id:1, content:'첫 글'}];
        const state = postReducer( initialState, fetchPostsSuccess(posts) );
        expect(state.loading).toBe(false);
        expect(state.posts).toEqual(posts);
        expect(state.success).toBe(true);
    });

    it('fetchPostDetailSuccess', () => {
        const post = {id:1, content:'첫글'};
        const state = postReducer( initialState, fetchPostDetailSuccess(post) );
        expect(state.loading).toBe(false);
        expect(state.currentPost).toEqual(post);
        expect(state.success).toBe(true);
    });

    it('createPostSuccess', () => {
        const newPost = {id:3, content:'새 글'};
        const state = postReducer(initialState, createPostSuccess(newPost));
        expect(state.loading).toBe(false);
        expect(state.posts[0]).toEqual(newPost);
        expect(state.success).toBe(true);
    })

    it('updatePostSuccess', () => {
        // const post = {id:1, content:'첫 글'};
        const prev = { ...initialState, posts : [{id:3, content:'새 글'}]};
        const updated = {id:3, content:'수정 후'};
        const state = postReducer( prev, updatePostSuccess(updated) );
        expect(state.loading).toBe(false);
        //expect(state.currentPost).toEqual(post);
        expect(state.posts[0].content).toBe('수정 후');
        expect(state.currentPost).toEqual( updated) ;
        expect(state.success).toBe(true);
    });

    it('deletePostSuccess', () => {
        const prev = {
            posts: [
                {id:1, content:"1"},
                {id:2, content:"2"}
            ]
        };
        const state = postReducer( prev, deletePostSuccess(1) );
        expect(state.loading).toBe(false);
        expect(state.posts).toEqual([{id:2,content:"2"}]);
        expect(state.success).toBe(true);
    });

    it('resetPostState', () => {
        const prev = { ...initialState, loading:true, error:'err', success:true };
        const state = postReducer( prev, resetPostState() );
        console.log('posts:', state.posts);
        expect(state.loading).toBe(false);
        expect(state.success).toBe(false);
        expect(state.error).toBeNull();
    });
});