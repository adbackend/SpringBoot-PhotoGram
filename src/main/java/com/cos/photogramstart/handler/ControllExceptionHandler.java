package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice
public class ControllExceptionHandler {

	@ExceptionHandler(CustomValidationException.class)
	public String validationException(CustomValidationException e) {
		
		System.out.println("cccccccccccccccccccc");
		
		// 1.클라이언트에게 응답할때는 Script가 좋음
		// 2.Ajax통신 - CMRespDto
		// 3.안드로이드 통신 - CMRespDto
		
		return Script.back(e.getErrorMap().toString());
	}
}
