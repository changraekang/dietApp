package com.cos.dietApp.domain.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.dietApp.domain.boardmenu.BoardMenu;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	@Query(value = "select * from Board where menuId = :menuId order by id desc", nativeQuery = true)
	List<Board> mFindAll(int menuId);

	Page<Board> findByBoardMenu(BoardMenu id, Pageable page);
	Page<Board> findById(Integer id, Pageable page);
	
}
