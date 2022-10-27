package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.home.interceptors.StudyInterceptor;
import com.iu.home.interceptors.TestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired //IOC Inversion Of Control
	private TestInterceptor testInterceptor;
	
	@Autowired
	private StudyInterceptor studyInterceptor;
	
	
	@Override
		public void addInterceptors(InterceptorRegistry registry) {
			// method 체이닝
			//적용할 Interceptor 등록 및 interceptor를 적용할 URL , 제외할 URL 등록
			registry.addInterceptor(testInterceptor).addPathPatterns("/qna/**").addPathPatterns("/notice/**").excludePathPatterns("/qna/detail").excludePathPatterns("/qna/add");
			
			//추가 인터셉터 등록 가능
			registry.addInterceptor(studyInterceptor).addPathPatterns("/qna/**");
		
			//WebMvcConfigurer.super.addInterceptors(registry);
		}
}
