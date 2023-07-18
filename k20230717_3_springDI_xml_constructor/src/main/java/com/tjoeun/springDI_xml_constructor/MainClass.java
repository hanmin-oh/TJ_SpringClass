package com.tjoeun.springDI_xml_constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		/*
		 * Student student = new Student(); student.setAge(18); student.setName("이순신");
		 * student.setClassNum(15); student.setGradeNum(8); System.out.println(student);
		 * 
		 * Student student2 = new Student("오한민", 29, 18, 2);
		 * System.out.println(student2);
		 */
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student" , Student.class);
		System.out.println(student);
		
//		Student student2 = new Student("을지문덕", 29, 18, 2);
//		System.out.println(student2);
		
		
	}
}
