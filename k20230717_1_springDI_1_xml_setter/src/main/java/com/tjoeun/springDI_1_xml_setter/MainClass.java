package com.tjoeun.springDI_1_xml_setter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		// 자바에서 사용하던 방식
		MyCalculator myCalculator  = new MyCalculator();
		myCalculator.setFirstNum(5);
		myCalculator.setSecondNum(15);
		
		Calculator calculator = new Calculator();
		myCalculator.setCalculator(calculator);
	
		*/
		
		// xml 파일에서 설정한 bean 정보를 읽어들인다. 
		// class의 bean을 설정하는 xml 파일 만들기 : src/main/resources에서 우클릭 => New =>
		// spring Bean Configuration File => xml 파일이름 입력 => Finish
		
		// xml 파일에서 설정한 bean을 얻어온다. 
		// applicationCTX.xml이 위치한 경로 src/main/resources를 classpath 라고 부른다. 
		String configLocation = "classpath:applicationCTX.xml";
		
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		MyCalculator myCalculator = ctx.getBean("myCalculator" , MyCalculator.class);
		System.out.println(myCalculator);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
		
		
	}

}
