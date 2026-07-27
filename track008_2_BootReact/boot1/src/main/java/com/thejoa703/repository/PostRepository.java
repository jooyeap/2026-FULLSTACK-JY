package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	// List<Post> - 결과가 여러개일때 : List
	// Optional<Post> - 결과 값이 1개이거나 없을때 : Optional
	List<Post> findByDeletedFalse();
	
	// 비교 -> 중복된 유저 1명이거나 없을때
	// Optional<AppUser> findByEmail(String email);
	
	@Query(
			value = "SELECT * FROM ( " +
	                "SELECT p.*, ROWNUM AS rnum " +
	                "FROM (SELECT * FROM POSTS WHERE DELETED = 0 ORDER BY CREATED_AT DESC) p " + 
	                ") " +
	                "WHERE rnum BETWEEN :start AND :end",
			nativeQuery = true
	)
	List<Post> findPostsWithPaging(@Param("start") int start,
								   @Param("end") int end);
}

/*
	사용할수 있는 기본 SQL
	1. CREATE
		save
		- insert into 테이블명 컬럼 values (?,?,?,,,)
	2. READ
		findAll
		- select * from 테이블명
		findById
		- select * from 테이블명 where id = ?
	3. UPDATE
		save
		- update 테이블명 set 컬럼 = ? where id = ?
	4. DELETE
		deleteById
		- delete from 테이블명 where id = ?
	
	삭제 안 된 게시글 찾기 findBy필드명
		List<Post> findByDeletedFalse();
		
	복잡한 sql - @Query
		@Query(
			value = "SELECT * FROM ( " +
	                "SELECT p.*, ROWNUM AS rnum " +
	                "FROM (SELECT * FROM POSTS WHERE DELETED = 0 ORDER BY CREATED_AT DESC) p " + 
	                ") " +
	                "WHERE rnum BETWEEN :start AND :end",
			nativeQuery = true
		)
		List<Post> findPostsWithPaging(@Param("start") int start,
									   @Param("end") int end);
*/