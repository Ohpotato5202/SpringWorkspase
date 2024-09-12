package com.kh.spring.board.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class BoardExt extends Board{
	private BoardImg attachment;
	private String userName;
	
	private List<Reply> replyList;
}
