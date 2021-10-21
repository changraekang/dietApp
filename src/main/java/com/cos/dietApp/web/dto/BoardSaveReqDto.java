package com.cos.dietApp.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.dietApp.domain.board.Board;
import com.cos.dietApp.domain.boardmenu.BoardMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardSaveReqDto {
	@Size(min = 1, max = 50)
	@NotBlank
	private String title;
	private String content;
	private String thumbnail;
	private String menuId;
	
	public Board toEntity(BoardMenu boardMenu) {
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setThumbnail(thumbnail);
		board.setBoardMenu(boardMenu);
		return board;
	}
}

