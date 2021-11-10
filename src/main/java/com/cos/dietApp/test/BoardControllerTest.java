package com.cos.dietApp.test;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.domain.board.Board;
import com.cos.dietApp.domain.board.BoardRepository;
import com.cos.dietApp.domain.boardmenu.BoardMenu;
import com.cos.dietApp.domain.boardmenu.BoardMenuRepository;
import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardControllerTest {
	
	private final BoardRepository boardRepository;
	private final BoardMenuRepository boardMenuRepository;

	@GetMapping("/test/board")
	public @ResponseBody Page<Board> board(@PageableDefault(page=0, size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageRequest) {
		int menuId = 1;
		BoardMenu boardMenu = boardMenuRepository.findById(menuId).get();
		Page<Board> board = boardRepository.findByBoardMenu(boardMenu, pageRequest);
		
		return board;
	}
}
