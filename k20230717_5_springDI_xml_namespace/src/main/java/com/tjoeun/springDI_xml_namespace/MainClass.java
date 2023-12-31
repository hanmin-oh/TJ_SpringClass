package com.tjoeun.springDI_xml_namespace;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		
		String configLocation = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation , configLocation2);
		
		Student student = ctx.getBean("student" , Student.class);
		System.out.println(student);
		System.out.println("이름: " + student.getName());
		System.out.println("취미: " + student.getSubject());
		System.out.println("=================================");
		
		Student student2 = ctx.getBean("student", Student.class);
		System.out.println(student2);
		System.out.println("이름: " + student2.getName());
		System.out.println("취미: " + student2.getSubject());
		System.out.println("=================================");
		
		System.out.println(student.equals(student2) ? "같다" : "다르다");
		System.out.println("=================================");
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student2);
		System.out.println("이름: " + student3.getName());
		System.out.println("취미: " + student3.getSubject());
		System.out.println("=================================");
		
		System.out.println(student.equals(student3) ? "같다" : "다르다");
		System.out.println("=================================");
		
		Student student4 = ctx.getBean("student4", Student.class);
		System.out.println(student2);
		System.out.println("이름: " + student4.getName());
		System.out.println("취미: " + student4.getSubject());
		System.out.println("=================================");
		
		System.out.println(student.equals(student4) ? "같다" : "다르다");
		System.out.println("=================================");
		
		StudentInfo studentInfo = ctx.getBean("studentInfo" , StudentInfo.class);
		System.out.println(studentInfo);
		studentInfo.getStudentInfo();
		System.out.println("=================================");
		
		Student student5 = ctx.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("이름: " + student5.getName());
		System.out.println("취미: " + student5.getSubject());
		System.out.println("=================================");
		
		Family family = ctx.getBean("family" , Family.class);
		System.out.println(family);
		
	}

}
