package com.kh.spring.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	
	private int boardNo; 
	private String boardTitle;
	private String boardContent;
	private String boardWriter; // id, userNo, name 
	private int count;
	private Date createDate;
	private String status;
	private String boardCd;
	

}




