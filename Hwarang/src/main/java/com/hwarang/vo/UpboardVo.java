package com.hwarang.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpboardVo {
	
	private int upboard_no; 		/*게시번호*/
    private String upboard_title;	/*제목*/
    private String upboard_writer; 	/*작성자*/
    private String upboard_score; 	/*평점*/
    private String upboard_cont; 	/*본문내용*/
    private String upboard_photo1; 	/*사진1*/
    private String upboard_photo2; 	/*사진2*/
    private String upboard_photo3; 	/*사진3*/
    private String upboard_photo4; 	/*사진4*/
    private String upboard_photo5; 	/*사진5*/
    private int upboard_view; 		/*조회수*/
    private String upboard_date; 	/*등록일*/
    
    //페이징 관련변수
  	private int startrow;//시작행 번호
  	private int endrow;//끝행 번호

  	//검색어와 검색필드 관련변수
  	private String find_field;//검색필드
  	private String find_name;//검색어	
}
