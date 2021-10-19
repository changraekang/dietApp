package com.cos.dietApp.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.dietApp.domain.board.Board;
import com.cos.dietApp.domain.board.BoardRepository;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.web.dto.BoardSaveReqDto;
import com.cos.dietApp.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardRepository boardRepository;
	
	//창래
	//용세
	
	// ---- 게시글 상세보기
	@GetMapping("/test/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + "번은 없는 게시글입니다") );
		model.addAttribute("boardEntity", boardEntity);
		return "wagle/detail"; // ViewResolver
	}
	
	// ---- 게시글 목록
	@GetMapping("/test/board")
	public String home(Model model) {
		System.out.println("호출됨");
		List<Board> boardsEntity = boardRepository.findAll();
		System.out.println("2");
		model.addAttribute("boardsEntity", boardsEntity);
		return "wagle/list";
	}
	
	// ---- 게시글 등록
	@PostMapping("/test/board")
	public @ResponseBody CMRespDto boardInsert(@Valid @RequestBody BoardSaveReqDto dto, BindingResult bindingResult) {
		
		boardRepository.save(dto.toEntity());
		
		return new CMRespDto(1,"성공",null);
	}
	
	@GetMapping("/test/board/saveForm")
	public String saveForm() {
		return "wagle/saveForm";
	}
	//규호
	

}
