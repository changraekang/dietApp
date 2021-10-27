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
import com.cos.dietApp.domain.boardmenu.BoardMenu;
import com.cos.dietApp.domain.boardmenu.BoardMenuRepository;
import com.cos.dietApp.handler.ex.MyAPINotFoundException;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.web.dto.BoardSaveReqDto;
import com.cos.dietApp.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardRepository boardRepository;
	private final BoardMenuRepository boardMenuRepository;
	
	//창래
	@GetMapping("/wagleFree")
	public String wagleFree () {
		
		return "wagle/Free";
	}
	@GetMapping("/wagleQnA")
	public String wagleQnA () {
		
		return "wagle/QnA";
	}
	@GetMapping("/wagleShowoff")
	public String wagleShowoff () {
		
		return "wagle/showoff";
	}
	//용세
	
	// ---- 게시글 목록 보기
	@GetMapping("/board")
	public String home(Model model, int menuId) {

		List<Board> boardsEntity = boardRepository.mFindAll(menuId);
		model.addAttribute("boardsEntity", boardsEntity);
		model.addAttribute("menuId", menuId);
		return "wagle/list";
	}
	

	// ---- 게시글 상세보기
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + "번은 없는 게시글입니다") );
		model.addAttribute("boardEntity", boardEntity);
		return "wagle/detail"; // ViewResolver
	}
	

	@PostMapping("/board")
	public @ResponseBody CMRespDto boardInsert(@Valid @RequestBody BoardSaveReqDto dto, BindingResult bindingResult) {
		BoardMenu bm = boardMenuRepository.findById(Integer.parseInt(dto.getMenuId()))
				.orElseThrow( () -> new MyAPINotFoundException("없는 게시판입니다.") );
		
		boardRepository.save(dto.toEntity(bm));
		
		return new CMRespDto(1,"성공",null);
	}
	
	// ---- 게시글 쓰기 페이지로 이동
	@GetMapping("/board/saveForm")
	public String saveForm(Model model, int menuId) {
		model.addAttribute("menuId", menuId);
		return "wagle/saveForm";
	}
	@GetMapping("/board/updateForm")
	public String updateForm() {
		return "wagle/updateForm";
	}
	
	
	@GetMapping("/calorieDic")
	public String calorieDic () {
		
		return "wagle/calorieDic";
	}
	@GetMapping("/recipe")
	public String recipe () {
		
		return "wagle/recipe";
	} 
	//규호
	

}
