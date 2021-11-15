package com.cos.dietApp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.domain.user.UserRepository;
import com.cos.dietApp.handler.ex.MyAPINotFoundException;
import com.cos.dietApp.handler.ex.MyNotFoundException;
import com.cos.dietApp.handler.ex.MyNotFoundUsernameException;
import com.cos.dietApp.util.MyAlgorithm;
import com.cos.dietApp.util.SHA;
import com.cos.dietApp.util.Script;
import com.cos.dietApp.web.dto.JoinReqDto;
import com.cos.dietApp.web.dto.LoginReqDto;
import com.cos.dietApp.web.dto.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	
	// 이건 하나의 서비스(핵심로직)인가? (principal 값 변경, update치고, 세션값 변경(x))
	
	
	
	
	public int 날짜계산 (int id) {
		
		String goalDate =  userRepository.mDate(id).getGoalPeriod();
		
		LocalDate localDate = LocalDate.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//String goalString = dto.getGoalPeriod().toString();
		String nowString = localDate.format(formatter);
		String date1 = goalDate;
	    String date2 = nowString;

	     System.out.println(goalDate);
		System.out.println(nowString);
		try{ // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서 에러가 발생해서 컴파일을 할 수 없다.
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        // date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
	        Date FirstDate =  format.parse(date1);
	        Date SecondDate =  format.parse(date2);
	        System.out.println(FirstDate + "1");
	        System.out.println(SecondDate + "2");
	        // Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
	        // 연산결과 -950400000. long type 으로 return 된다.
	        long calDate = FirstDate.getTime() - SecondDate.getTime(); 
	        System.out.println("caldate:" + calDate);
	        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
	        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
	        long calDateDays = calDate / ( 24*60*60*1000); 
	        System.out.println(( 24*60*60*1000));
	        calDateDays = Math.abs(calDateDays);
	        
	        System.out.println("두 날짜의 날짜 차이: "+calDateDays);
	        return (int) calDateDays; 
	        }
	        catch(ParseException e)
	        {
	            // 예외 처리
	        	return 0; 
	        }
		
		
		
	}
	public User 로그인(LoginReqDto loginDto) {
		return userRepository.findByUsernameAndPassword(loginDto.getUsername(), SHA.encrypt(loginDto.getPassword(), MyAlgorithm.SHA256));
	}
	
	@Transactional(rollbackFor = MyNotFoundException.class)
	public void 회원가입(JoinReqDto joinDto) {
		
		User user = userRepository.findByUsername(joinDto.getUsername());
		if(user != null) {
			throw new MyNotFoundUsernameException("아이디 중복");
		}
		
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
		System.out.println(dto.getGoalPeriod());
		principal.setName(dto.getName());
		principal.setUserPhone(dto.getUserPhone());
		principal.setUserEmail(dto.getUserEmail());
		principal.setUserWeight(dto.getUserWeight());
		principal.setUserHeight(dto.getUserHeight());
		double weight = dto.getUserWeight();
		double height = dto.getUserHeight();
		double bmi =Math.round((weight / ((height/100) * (height/100))) * 100) / 100.0;
		principal.setGoalPeriod(dto.getGoalPeriod());
		/*
		 * SimpleDateFormat goalDate = new SimpleDateFormat("yyyy-MM-dd");
		 * System.out.println(goalDate.format(dto.getGoalPeriod()));
		 */
		principal.setUserBMI(bmi);
		principal.setGoalWeight(dto.getGoalWeight());
		userRepository.save(principal);
	}
	
	
	
}













