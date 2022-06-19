package com.cos.photogramstart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPassword;
	
	@Transactional
	public User 회원수정(int id, User user) {
		
		//1.영속화
		User userEntity = userRepository.findById(id).get(); //1.무조건 찾았다 걱정마 -get(), 2.못찾았어 익셉션 발동 시킬게 -orElseThrow()
		
		//2.영속화된 오브젝트 수정 - > 더티체킹(업데이트 완료)
		userEntity.setName(user.getName());
		
		String rawPassword = user.getPassword();
		String encodePassword = bCryptPassword.encode(rawPassword);
		userEntity.setPassword(encodePassword);
		
		userEntity.setBio(user.getBio());
		userEntity.setWebsite(user.getWebsite());
		userEntity.setPhone(user.getPhone());
		userEntity.setGender(user.getGender());
		
		return userEntity;
	}
	
}
