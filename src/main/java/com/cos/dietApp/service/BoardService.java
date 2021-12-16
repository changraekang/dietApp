package com.cos.dietApp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.dietApp.domain.board.Board;
import com.cos.dietApp.domain.board.BoardRepository;
import com.cos.dietApp.domain.boardmenu.BoardMenu;
import com.cos.dietApp.domain.boardmenu.BoardMenuRepository;
import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.handler.ex.MyAPINotFoundException;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.web.dto.BoardSaveReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	private final BoardMenuRepository boardMenuRepository;
	
	public Page<Board> 게시글목록(BoardMenu boardMenu, Pageable pageRequest) {
		return boardRepository.findByBoardMenu(boardMenu, pageRequest);
	}
	public BoardMenu 게시글메뉴(int menuId) {
		return boardMenuRepository.findById(menuId).get();
	}
	
	public Board 게시글상세보기(int id) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + "번은 없는 게시글입니다") );
		return boardEntity;
	}
	
	@Transactional
	public void 게시글쓰기(BoardSaveReqDto dto, User principal) {
		if (principal == null ) {
			throw new MyNotFoundException("로그인이 필요합니다.");
		}
		BoardMenu bm = boardMenuRepository.findById(Integer.parseInt(dto.getMenuId()))
				.orElseThrow( () -> new MyAPINotFoundException("없는 게시판입니다.") );
		boardRepository.save(dto.toEntity(bm, principal));
	}

	@Transactional
	public void 게시글수정(BoardSaveReqDto dto, Board boardEntity, User principal) {
		if(principal.getId() != boardEntity.getUser().getId()) {
			throw new MyAPINotFoundException("권한이 없습니다.");
		}
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
		boardEntity.setThumbnail(dto.getThumbnail());
	}

	@Transactional
	public void 게시글삭제(int id, User principal) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + "번은 없는 게시글입니다") );
		if(principal.getId() != boardEntity.getUser().getId()) {
			throw new MyAPINotFoundException("권한이 없습니다.");
		}
		boardRepository.deleteById(id);
		
	}

	@Transactional
	public Board 수정페이지이동(int id, User principal) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + "번은 없는 게시글입니다") );
		if(principal.getId() != boardEntity.getUser().getId()) {
			throw new MyNotFoundException("권한이 없습니다.");
		}
		return boardEntity;
	}
}
