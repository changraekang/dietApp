package com.cos.dietApp.domain.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	@Query(value = "select * from Board where menuId = :menuId order by id desc", nativeQuery = true)
	List<Board> mFindAll(int menuId);
}
