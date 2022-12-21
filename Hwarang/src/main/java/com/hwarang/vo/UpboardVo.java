package com.hwarang.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpboardVo {
	
	private int upboardNo; 		/*게시번호*/
    private String upboardTitle;	/*제목*/
    private String upboardWriter; 	/*작성자*/
    private String upboardScore; 	/*평점*/
    private String upboardCont; 	/*본문내용*/
    private String upboardPhoto1; 	/*사진1*/
    private String upboardPhoto2; 	/*사진2*/
    private String upboardPhoto3; 	/*사진3*/
    private String upboardPhoto4; 	/*사진4*/
    private String upboardPhoto5; 	/*사진5*/
    private int upboardView; 		/*조회수*/
    private String upboardDate; 	/*등록일*/
    
    //페이징 관련변수
  	private int startrow;//시작행 번호
  	private int endrow;//끝행 번호

  	//검색어와 검색필드 관련변수
  	private String findField;//검색필드
  	private String findName;//검색어	
}
