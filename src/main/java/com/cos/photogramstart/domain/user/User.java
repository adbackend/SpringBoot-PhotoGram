package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // 모든필드 생성자
@NoArgsConstructor // 기본 생성자
@Data
@Entity // 디비에 테이블 생성
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //번호증가 전력은 데이터베이스를 따라간다
	private int id;
	
	@Column(length = 20, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)

	private String name;
	private String website; //웹사이트
	private String bio; //자기소개
	
	@Column(nullable = false)
	private String email;
	private String phone;
	private String gender; //성별
	
	private String profileImageUrl; //사진
	private String role; //권한
	
	private LocalDateTime createDate;
	
	@PrePersist // db에 insert 되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}

}
