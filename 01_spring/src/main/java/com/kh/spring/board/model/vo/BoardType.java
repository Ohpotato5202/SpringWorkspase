package com.kh.spring.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@AllArgsConstructor
@Builder
public class BoardType {

	private String boardCode; // BOARD_CD
	private String boardName; // BOARD_NAME
	
}
