package com.cos.dietApp.test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.dietApp.domain.board.Board;
import com.cos.dietApp.domain.board.BoardRepository;
import com.cos.dietApp.web.dto.PageReqDto;
import com.cos.dietApp.web.dto.PageRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PagebleTest {
	
	private final BoardRepository boardRepository;
	//@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
	@GetMapping("/test/page")
	public  Page<Board> test( ){
		System.out.println("페이징 시작");
		int page=1, menuId=1;
		PageRequest pageRequest = PageRequest.of(page, 5, Sort.by("id").descending());
		Page<Board> boardsEntity = boardRepository.findAll(pageRequest);
		
		//Page<Board> boardsEntity = boardRepository.findAll(menuId, pageRequest);
		return boardsEntity;
	}

	@GetMapping("/test/list")
	public List<Board> list() {
		int menuId=1;
		List<Board> boardsEntity = boardRepository.mFindAll(menuId);
		
		return boardsEntity;
	}

	@GetMapping("/test/cal/{nowPage}/{totalcount}")
	public @ResponseBody PageRespDto pagecal(@PathVariable int nowPage, @PathVariable int totalcount) {
		int pageten = (int) Math.ceil(nowPage / 10.0) * 10;
		int lastPage = (int) Math.ceil(totalcount / 10.0);
		int prePage = pageten - 10;
		int nextPage = pageten + 1;
		PageRespDto pageRespDto = new PageRespDto (nowPage, lastPage, prePage, nextPage);

		return pageRespDto;
	}
}
