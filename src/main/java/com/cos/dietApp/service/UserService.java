package com.cos.dietApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.domain.user.UserRepository;
import com.cos.dietApp.handler.ex.MyAPINotFoundException;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.util.MyAlgorithm;
import com.cos.dietApp.util.SHA;
import com.cos.dietApp.web.dto.JoinReqDto;
import com.cos.dietApp.web.dto.LoginReqDto;
import com.cos.dietApp.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	
	// 이건 하나의 서비스(핵심로직)인가? (principal 값 변경, update치고, 세션값 변경(x))
	
	@Transactional(rollbackFor = MyAPINotFoundException.class)
	public void 회원수정(User principal, UserUpdateDto userUpdateDto) {
		User userEntity = userRepository.findById(principal.getId())
				.orElseThrow(()-> new MyAPINotFoundException("회원정보를 찾을 수 없습니다."));
		userEntity.setUEmail(userUpdateDto.getUsername());
//		userEntity.set(userUpdateDto.getPassword());
		userEntity.setUName(userUpdateDto.getUName());
		userEntity.setUPhone(userUpdateDto.getUPhone());
		userEntity.setUEmail(userUpdateDto.getUEmail());
		userEntity.setUGender(userUpdateDto.getUGender());
		userEntity.setUWeight(userUpdateDto.getUWeight());
		userEntity.setUHeight(userUpdateDto.getUHeight());
		userEntity.setUMuscle(userUpdateDto.getUMuscle());
		userEntity.setUBMI(userUpdateDto.getUBMI());
		
	} // 더티 체킹
	
	public User 로그인(LoginReqDto loginDto) {
		return userRepository.mLogin(loginDto.getUsername(), SHA.encrypt(loginDto.getPassword(), MyAlgorithm.SHA256));
	}
	
	@Transactional(rollbackFor = MyNotFoundException.class)
	public void 회원가입(JoinReqDto joinDto) {
		String encPassword = SHA.encrypt(joinDto.getPassword(), MyAlgorithm.SHA256);
		joinDto.setPassword(encPassword);
		userRepository.save(joinDto.toEntity());
	}
}













