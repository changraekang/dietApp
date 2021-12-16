package com.cos.dietApp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
import com.cos.dietApp.domain.boardmenu.BoardMenu;
import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.handler.ex.MyAPINotFoundException;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.service.BoardService;
import com.cos.dietApp.util.PageCalc;
import com.cos.dietApp.web.dto.BoardSaveReqDto;
import com.cos.dietApp.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService boardService;
	private final HttpSession session;
	private final PageCalc calc;
	
	//창래
	//용세
	
	// ---- 게시글 목록 보기
	@GetMapping("/board")
	public String home(Model model,int menuId, @PageableDefault(page=0, size=10, sort="id", direction = Sort.Direction.DESC) Pageable pageRequest) {
		
		BoardMenu boardMenu = boardService.게시글메뉴(menuId);
		Page<Board> boardsEntity = boardService.게시글목록(boardMenu, pageRequest);

		int nowPage = pageRequest.getPageNumber() + 1;
		int lastPage = boardsEntity.getTotalPages();
		model.addAttribute("boardMenu", boardMenu);
		model.addAttribute("boardsEntity", boardsEntity);
		model.addAttribute("page", calc.pagecal(nowPage, lastPage));
		
		return "wagle/list";
	}
	

	// ---- 게시글 상세보기
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("boardEntity", boardService.게시글상세보기(id));
		return "wagle/detail"; // ViewResolver
	}
	
	// ---- 게시글 쓰기
	@PostMapping("/board")
	public @ResponseBody CMRespDto boardInsert(@Valid @RequestBody BoardSaveReqDto dto, BindingResult bindingResult) {
		User principal = (User) session.getAttribute("principal");

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new MyAPINotFoundException(errorMap.toString());
		}
		
		boardService.게시글쓰기(dto, principal);

		return new CMRespDto(1,"성공",null);
	}
	
	// ---- 게시글 쓰기 페이지 이동
	@GetMapping("/board/saveForm")
	public String saveForm(Model model, int menuId) {
		User principal = (User) session.getAttribute("principal");
		
		if (principal == null ) {
			throw new MyNotFoundException("로그인이 필요합니다.");
		}
		model.addAttribute("menuId", menuId);
		return "wagle/saveForm";
	}
	
	// ---- 게시글 수정
	//@requestBody -> 있는 그대로 가져온다
	@PutMapping("/board/{id}")
	public @ResponseBody CMRespDto<String> update(@PathVariable int id,@Valid @RequestBody BoardSaveReqDto dto, BindingResult bindingResult){
		User principal = (User) session.getAttribute("principal");

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new MyAPINotFoundException(errorMap.toString());
		}
		
		Board boardEntity = boardService.게시글상세보기(id);
		boardService.게시글수정(dto, boardEntity, principal);
		return new CMRespDto<>(1, "업데이트 성공", null);
	}
	
	// ---- 게시글 수정 페이지 이동
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(Model model, @PathVariable int id) {
		User principal = (User) session.getAttribute("principal");
		model.addAttribute("boardEntity",boardService.수정페이지이동(id, principal));
		return "wagle/updateForm";
	}
	
	// ---- 게시글 삭제
	@DeleteMapping("/board/{id}")
	public CMRespDto<Object> delete(@PathVariable int id) {
		User principal = (User) session.getAttribute("principal");
		
		boardService.게시글삭제(id, principal);
		
		return new CMRespDto<>(1, "업데이트 성공", null);
	}
	
	@GetMapping("/recipe")
	public String recipe () {
		
		return "wagle/recipe";
	} 
	//규호
	

}
