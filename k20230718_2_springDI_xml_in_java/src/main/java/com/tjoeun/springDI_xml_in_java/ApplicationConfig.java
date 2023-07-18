package com.tjoeun.springDI_xml_in_java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration  
public class ApplicationConfig {
	
	@Bean
	public Student student2() {
		Student student = new Student();
		student.setName("을지문덕");
		student.setAge(46);
		ArrayList<String> subject = new ArrayList<String>();
		subject.add("Java");
		subject.add("JSP");
		subject.add("spring");
		student.setSubject(subject);
		student.setHeight(177);
		student.setWeight(69);
		
		return student; 
	}
	
	
	
	
}
