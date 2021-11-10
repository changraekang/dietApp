package com.cos.dietApp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		BoardMenu boardMenu = boardMenuRepository.findById(menuId).get();
		model.addAttribute("boardsEntity", boardsEntity);
		model.addAttribute("menuId", menuId);
		model.addAttribute("boardMenu", boardMenu);
		
		
		if(menuId != 3)
			return "wagle/list";
		else
			return "wagle/showoff";
	}
	

	// ---- 게시글 상세보기
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + "번은 없는 게시글입니다") );
		model.addAttribute("boardEntity", boardEntity);
		return "wagle/detail"; // ViewResolver
	}
	
	// ---- 게시글 쓰기
	@PostMapping("/board")
	public @ResponseBody CMRespDto boardInsert(@Valid @RequestBody BoardSaveReqDto dto, BindingResult bindingResult) {
		
		// 유효성 검사
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new MyAPINotFoundException(errorMap.toString());
		}
		
		BoardMenu bm = boardMenuRepository.findById(Integer.parseInt(dto.getMenuId()))
				.orElseThrow( () -> new MyAPINotFoundException("없는 게시판입니다.") );
		
		boardRepository.save(dto.toEntity(bm));
		
		return new CMRespDto(1,"성공",null);
	}
	
	// ---- 게시글 쓰기 페이지 이동
	@GetMapping("/board/saveForm")
	public String saveForm(Model model, int menuId) {
		model.addAttribute("menuId", menuId);
		return "wagle/saveForm";
	}
	
	// ---- 게시글 수정
	//@requestBody -> 있는 그대로 가져온다
	@PutMapping("/board/{id}")
	public @ResponseBody CMRespDto<String> update(@PathVariable int id,@Valid @RequestBody BoardSaveReqDto dto, BindingResult bindingResult){
		
		// 유효성 검사
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new MyAPINotFoundException(errorMap.toString());
		}
		
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow( () -> new MyAPINotFoundException("없는 게시글입니다.") );
		
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
		boardEntity.setThumbnail(dto.getThumbnail());
		
		boardRepository.save(boardEntity);
		return new CMRespDto<>(1, "업데이트 성공", null);
	}
	
	// ---- 게시글 수정 페이지 이동
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(Model model, @PathVariable int id) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException("없는 게시글입니다."));
		model.addAttribute("boardEntity",boardEntity);
		return "wagle/updateForm";
	}
	
	// ---- 게시글 삭제
	@DeleteMapping("/board/{id}")
	public CMRespDto<Object> delete(@PathVariable int id) {
		boardRepository.deleteById(id);
		
		return new CMRespDto<>(1, "업데이트 성공", null);
	}
	
	@GetMapping("/recipe")
	public String recipe () {
		
		return "wagle/recipe";
	} 
	//규호
	

}
