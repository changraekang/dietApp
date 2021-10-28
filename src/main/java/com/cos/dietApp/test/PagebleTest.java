package com.cos.dietApp.test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.dietApp.domain.board.Board;
import com.cos.dietApp.domain.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PagebleTest {
	
	private final BoardRepository boardRepository;
	
	@GetMapping("/test/page")
	public  Page<Board> test(){
		System.out.println("페이징 시작");
		int page=1, menuId=1;
		PageRequest pageRequest = PageRequest.of(page, 5, Sort.by("id").descending());
		Page<Board> boardsEntity = boardRepository.mFindAllPage(menuId, pageRequest);
		
		//Page<Board> boardsEntity = boardRepository.findAll(pageRequest);
		return boardsEntity;
	}

	@GetMapping("/test/list")
	public List<Board> list() {
		int menuId=1;
		List<Board> boardsEntity = boardRepository.mFindAll(menuId);
		
		return boardsEntity;
	}
}
