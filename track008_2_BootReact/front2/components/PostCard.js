export default function PostCard(){
    return (
    <div>
        {/* 게시판 리스트 */}
        <h3> 게시글 : {posts.length}</h3>
        {posts.map( (post, index) => (
            <Card key={post.id || index} style={{marginBottom:"10px"}}>
                <p>{post.content}</p>
            </Card>
        ))}
    </div>
    );
}