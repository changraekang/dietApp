package com.cos.dietApp.domain.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//save(user) 인서트, 업데이트
//findById(1) 한건셀렉트
//findAll() 전체셀렉트
//deleteById(1) 한건 삭제

// DAO
// @Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	 
	@Query(value = "insert into user (username, password, uName, uPhone, uEmail, uWeight, uHeight, uMuscle, uBMI) values(:username,:password,:uName,:uPhone,:uEmail, :uWeight, :Height, :uMuscle, :uBMI)", nativeQuery = true)
	void join(String username, String password, String uName, String uPhone, String uEmail);
	
	User findByUsernameAndPassword(String username, String password);

	@Query(value = "SELECT * FROM user WHERE id = :id ", nativeQuery = true)
	User mDate(int id);

	User findByUsername(String data);

	User findByUsernameAndName(String username, String name);

	List<User> findByNameContaining(String name);
	Page<User> findByNameContaining(String name, Pageable page);
	
	Page<User> findByUserHeightContaining(Integer id, Pageable page);

}





