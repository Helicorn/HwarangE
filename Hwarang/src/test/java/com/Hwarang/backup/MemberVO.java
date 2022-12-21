package com.Hwarang.backup;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(
		name = "MEMBER_SEQ_GENERATOR",
		sequenceName = "MEM_SEQ",	//매핑할 DB 시퀀스 이름
		initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class MemberVO implements Serializable{
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOT_MEMBER_SEQ_GENERATOR")
	private int no; //번호
	
	@Id
	@Column(name="username", unique=true)
	private String username; //id
	private String password; //pw
	private String realname; //이름
	@Column(name="nickname", unique=true)
	private String nickname; //닉네임
	private String phone1;
	private String phone2;
	private String phone3;
	private String email1;
	private String email2;
	private String gender; //성별
	
	private String profile; //프사
	private String addressdo; //도
	private String addresssi; //시
	
	@ColumnDefault("'0'")
	private int state; //0 일반회원 1 관리자 2 탈퇴회원
	@ColumnDefault("'ROLE_USER'")
	private String role; //role_user
	
	@CreationTimestamp
	private Timestamp createdate;
	
	@Builder
	public MemberVO(int no,String username,String password,String realname,String nickname,
					String phone1,String phone2,String phone3,String email1,String email2, String gender,
					String profile,String addressdo,String addresssi,int state,String role,Timestamp createdate) {
		this.no = no;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.nickname = nickname;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.gender = gender;
		this.profile = profile;
		this.addressdo = addressdo;
		this.addresssi = addresssi;
		this.state = state;
		this.role = role;
		this.createdate = createdate;
	}
}
