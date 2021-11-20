package com.cos.dietApp.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.dietApp.domain.boardmenu.BoardMenu;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	Page<Board> findByBoardMenu(BoardMenu boardMenu, Pageable page);
	Page<Board> findById(Integer id, Pageable page);
	
}

