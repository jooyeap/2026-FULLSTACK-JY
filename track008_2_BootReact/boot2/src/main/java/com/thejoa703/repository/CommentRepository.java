package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	// 특정 게시글의 삭제되지 않은 댓글 목록 조회
	// @ManyToOne - post가 1개여서 join 쿼리를 만들어줌
	// findBy 조건1 AND 조건2
	// SELECT c FROM Comment c WHERE c.post.id = :postId AND c.delete=false
	public List<Comment> findByPostIdAndDeletedFalse(Long postId);
	
	// 삭제되지 않은 댓글의 수를 집계
	// SELECT COUNT(C.id) FROM Comment c WHERE c.post.id = :postId AND c.delete=false
	public long countByPostIdAndDeletedFalse(Long postId);
}

/*

1. findBy 조회		+ And
2. countBy 갯수		+ Or
3. existsBy 존재여부	+ 엔티티안에 다른엔티티 Post엔티티 안에 Long id
4. deleteBy 

*/