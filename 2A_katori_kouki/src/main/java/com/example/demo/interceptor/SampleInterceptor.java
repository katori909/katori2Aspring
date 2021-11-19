package com.example.demo.interceptor;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class SampleInterceptor {
	@Autowired
	private HttpSession session;
	
	@Before("execution(* com.example.demo.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void outputMessage(JoinPoint joinPoint ) {
		String userName = (String) session.getAttribute("userName");
		System.out.println("AOPを動かしました");
		//System.out.println("入力された内容は：" + userName + "です。");
	}
	@After("execution(* com.example.demo.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void outputMessage1(JoinPoint joinPoint ) {
		String userName = (String) session.getAttribute("userName");
		System.out.println("AOPを動かしましたその2");
		//System.out.println("入力された内容は：" + userName + "です。");
	}
}