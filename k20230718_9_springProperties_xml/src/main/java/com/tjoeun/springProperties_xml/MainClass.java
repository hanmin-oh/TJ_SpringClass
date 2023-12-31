package com.tjoeun.springProperties_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		AdminConnection adminConnection = ctx.getBean("adminConnection" , AdminConnection.class);
		
		System.out.println("admin.Id: " + adminConnection.getAdminId());
		System.out.println("admin.Pw: " + adminConnection.getAdminPw());
		System.out.println("sub_adminId: " + adminConnection.getSub_adminId());
		System.out.println("sub_adminPw: " + adminConnection.getSub_adminPw());
		
		
	}

}
