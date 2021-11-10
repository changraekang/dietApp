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
	
	
	public User 로그인(LoginReqDto loginDto) {
		return userRepository.mLogin(loginDto.getUsername(), SHA.encrypt(loginDto.getPassword(), MyAlgorithm.SHA256));
	}
	
	@Transactional(rollbackFor = MyNotFoundException.class)
	public void 회원가입(JoinReqDto joinDto) {
		String encPassword = SHA.encrypt(joinDto.getPassword(), MyAlgorithm.SHA256);
		joinDto.setPassword(encPassword);
		double weight = joinDto.getUserWeight();
		double height = joinDto.getUserHeight();
		double bmi =Math.round((weight / ((height/100) * (height/100))) * 100) / 100.0;
		
		joinDto.setUserBMI(bmi);
		System.out.println(bmi);
		userRepository.save(joinDto.toEntity());
	}
	
	@Transactional
	public void 회원정보수정(User principal, int id, UserUpdateDto dto) {
		
		User userEntity = userRepository.findById(id).orElseThrow(()-> new MyAPINotFoundException("해당회원을 찾을 수 없습니다"));

		if (principal.getId() != userEntity.getId()) {
			throw new MyAPINotFoundException("회원정보를 수정할 권한이 없습니다");
		}
		System.out.println(dto.getName());
		System.out.println(dto.getUserEmail());
		System.out.println(dto.getUserWeight());
		System.out.println(dto.getUserHeight());
		principal.setName(dto.getName());
		principal.setUserPhone(dto.getUserPhone());
		principal.setUserEmail(dto.getUserEmail());
		principal.setUserWeight(dto.getUserWeight());
		principal.setUserHeight(dto.getUserHeight());
		double weight = dto.getUserWeight();
		double height = dto.getUserHeight();
		double bmi =Math.round((weight / ((height/100) * (height/100))) * 100) / 100.0;
		
		principal.setUserBMI(bmi);
		principal.setGoalWeight(dto.getGoalWeight());
		principal.setGoalPeriod(dto.getGoalPeriod());
		userRepository.save(principal);
	}
	
	
	
}













