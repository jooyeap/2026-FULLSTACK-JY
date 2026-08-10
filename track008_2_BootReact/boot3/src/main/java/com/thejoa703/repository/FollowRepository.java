package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long>{
	
	// 팔로우 단건 조회 / 어떤 팔로워,팔로위 조회
	Optional<Follow> findByFollower_IdAndFollowee_Id(Long followerId, Long followeeId);
	
	// 팔로잉 목록 조회
	// 1) 쿼리 1개 : findByFollower_Id(1L) 팔로잉 목록 10명
	// 2) 추가 쿼리 10개 : 각각의 정보를 가져오려면 쿼리 10번 더 실행
	// -> 1 + N 의 쿼리를 실행하지 않으려고 아래 어노테이션 사용
	// 쿼리 실행할때 Followee의 데이터 까지 한꺼번에 조회
	@EntityGraph(attributePaths = {"followee"}) 
	List<Follow> findByFollower_Id(Long followerId);
	
	// 팔로워 목록 조회
	@EntityGraph(attributePaths = {"follower"})
	List<Follow> findByFollowee_Id(Long followeeId);
	
	// 팔로잉 수 집계
	long countByFollower_Id(Long followerId);
	
	// 팔로워 수 집계
	long countByFollowee_Id(Long followeeId);
}
