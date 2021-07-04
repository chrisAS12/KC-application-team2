package com.example.KCbootcampapplication;

import com.example.KCbootcampapplication.controller.AdminController;
import com.example.KCbootcampapplication.controller.LoginController;
import com.example.KCbootcampapplication.controller.StudentController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class KcBootcampApplicationTests{

	@Autowired
	public AdminController adminController;

	@Autowired
	public LoginController loginController;

	@Autowired
	public StudentController studentController;


	@Test
	public void contextLoads() throws Exception{
		assertThat(adminController).isNotNull();
		assertThat(loginController).isNotNull();
		assertThat(studentController).isNotNull();

	}

	@Test
	public void loginTest(){
		//assertThat(this.)
	}

}
