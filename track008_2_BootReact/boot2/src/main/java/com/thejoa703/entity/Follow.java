package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
	name = "FOLLOWS",
	uniqueConstraints = @UniqueConstraint(columnNames = {"FOLLOWR_ID", "FOLLOWW_ID"})
)
@Getter
@Setter
@NoArgsConstructor
public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
	@SequenceGenerator(name = "follow_seq", sequenceName = "FOLLOW_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name = "CREATED_AT", nullable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	public Follow(AppUser follower, AppUser followee) {
		super();
		this.follower = follower;
		this.followee = followee;
	}
	
	
	// @ManyToOne(fetch = FetchType.LAZY) 
	// 연관된 엔티티(AppUser) 당장 가져오지않고
	// 실제 객체를 사용하는 시점에서 쿼리 실행, 불필요한 join 줄이기
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "FOLLOWR_ID", nullable = false)
	private AppUser follower; // @ManyToOne 보는 사람
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOLLOWW_ID", nullable = false)
	private AppUser followee; // @ManyToOne 보여지는 사람
}
