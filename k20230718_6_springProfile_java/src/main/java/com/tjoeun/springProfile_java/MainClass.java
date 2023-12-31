package com.tjoeun.springProfile_java;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("실행할 작업 환경을 입력하세요(1 => dev, 2=> run): ");
		int info = scanner.nextInt();
		String config = "";
		switch (info) {
		case 1:
			config = "dev";	
			break;
		case 2:
			config = "run";
			break;
		}
		
		// profile이 설정된 xml 파일의 bean을 읽어오기 위해서는 DI 컨테이너를 먼저 만든 후 읽어올 bean의 profile을 지정한 다음
		// 해당 profile이 지정된 bean을 load 시켜야 한다. 
		// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		// profile이 설정된 xml 파일의 bean을 읽어오기 위해서는 DI 컨테이너를 먼저 만든 후 읽어올 bean의 profile을 지정한 다음
		// 해당 profile이 지정된 bean을 load 시켜야 한다. 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		
		// 읽어올 bean의 profile을 넣어준다.
		// getEnvironment() 메소드로 DI 컨테이너의 환경 설정 정보를 얻어온 후 setActiveProfiles() 메소드로 읽어올 profile을 넣어준다.
		ctx.getEnvironment().setActiveProfiles(config);
		
//		ctx.load("classpath:applicationCTX_run.xml" , "classpath:applicationCTX_dev.xml");
		
		
		ctx.register(ApplicationConfigDev.class , ApplicationConfigRun.class);
		ctx.refresh();
		ServerInfo serverInfo  = ctx.getBean("serverInfo" , ServerInfo.class);
		System.out.println(serverInfo);
		
		ctx.close();
	}

}
