package com.tjoeun.spring_Envrioment;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

// AdminConnection 클래스의 bean이 생성되는 순간 admin.properties 파일의 내용을 읽어서 필드에 저장한다. 
public class AdminConnection implements InitializingBean, DisposableBean, EnvironmentAware{
	
	private String adminId; //admin.properties 파일의 admin.id에 할당된 데이터를 저장한다. 
	private String adminPw; //admin.properties 파일의 admin.pw에 하당된 데이터를 저장한다.
	private Environment env; // DI 컨테이너의 환경 설정 정보를 저장한다. 
	
	
	public AdminConnection() {
		System.out.println("AdminConnection 클래스의 bean이 생성되었습니다.");
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	@Override
	public String toString() {
		return "AdminConnection [adminId=" + adminId + ", adminPw=" + adminPw + ", env=" + env + "]";
	}

	// EnvironmentAware 인터페이스를 구현하면 사용할 수 있고 EnvrionmentAware 인터페이스가 구현된 클래스의 bean이
	// 생성(refresh() 메소드가 실행)된 후 자동으로 실행되는 메소드
	// setEnvironment() 메소드의 인수인 DI 컨테이너 환경 설정 정보를 기억하는 Enviroment 인터페이스 타입의 객체 
	// environment에 스프링이 알아서 EnvironmentAware 인터페이스가 구현된 클래스의 bean이 생성되는 순간 DI 컨테이너의 환경
	// 설정 정보를 넘겨준다. => properties 파일의 정보가 넘어온다.
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("AdminConnection 클래스의 bean이 생성된 후 자동으로 setEnvironment() 메소드 실행");
		// System.out.println("admin.id: " + environment.getProperty("admin.id"));
		// System.out.println("admin.pw: " + environment.getProperty("admin.pw"));
		// Environment 인터페이스 객체로 넘어온 DI 컨테이너 환경 설정 정보를 AdminConnection 클래스에서 사용하기 위해 
		// 필드로 선언한 Environment 인터페이스 객체 env에 저장한다. 
		env = environment;
	}
	
	// DisposableBean 인터페이스를 구현하면 사용할 수 있고 bean이 소멸될 때 자동으로 실행되는 메소드
	@Override
	public void destroy() throws Exception {
		System.out.println("AdminConnection 클래스의 bean이 소멸된 후 자동으로 destory() 메소드 실행");
	}
	
	// InitializingBean 인터페이스를 구현하면 사용할 수 있고 bean이 생성될 때 자동으로 실행되는 메소드
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("생성자가 실행된 후 자동으로 afterPropertiesSet() 메소드 실행");
		// Environment 인터페이스 객체 env에 저장된 환경 설정 정보의 properties 정보를 필드에 넣어준다. 
		adminId = env.getProperty("admin.id");
		adminPw = env.getProperty("admin.pw");
	}


	
	
}
