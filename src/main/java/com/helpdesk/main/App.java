package com.helpdesk.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.helpdesk.config.DatabaseConfig;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		System.out.println("Spring Application Started Successfully!");
		
	}
}
