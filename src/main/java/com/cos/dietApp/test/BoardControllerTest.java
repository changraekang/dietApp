package com.cos.dietApp.test;

import java.util.ArrayList;
import java.util.List;

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
	
//	@GetMapping("/test/boardinsert")
//	public String boardInsert() {
//		
//		List<Board> bd = new ArrayList<>();
//		
//		BoardMenu menu = new BoardMenu(1, "자유");
//		boardMenuRepository.save(menu);
//		for(int i = 1; i < 2200 ; i++) {
//			Board board = new Board();
//			board.setTitle("자유 제목 " + i);
//			board.setContent("내용 " + i);
//			board.setBoardMenu(menu);
//			bd.add(board);
//		}
//		
//		menu = new BoardMenu(2, "QnA");
//		boardMenuRepository.save(menu);
//		for(int i = 1; i < 1800 ; i++) {
//			Board board = new Board();
//			board.setTitle("QnA 제목 " + i);
//			board.setContent("내용 " + i);
//			board.setBoardMenu(menu);
//			bd.add(board);
//		}
//		
//		menu = new BoardMenu(3, "인증");
//		boardMenuRepository.save(menu);
//		for(int i = 1; i < 1200 ; i++) {
//			Board board = new Board();
//			board.setTitle("인증 제목 " + i);
//			board.setContent("내용 " + i);
//			board.setBoardMenu(menu);
//			bd.add(board);
//		}
//		
//		boardRepository.saveAll(bd);
//		
//		return "redirect:/calorieDic";
//	}
}
