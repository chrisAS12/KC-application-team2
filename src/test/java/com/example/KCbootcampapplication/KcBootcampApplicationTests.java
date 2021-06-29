package com.example.KCbootcampapplication;

import com.example.KCbootcampapplication.domain.TestQuestion;
import com.example.KCbootcampapplication.domain.User;

import com.example.KCbootcampapplication.service.DatabaseManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@SpringBootTest
@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
class KcBootcampApplicationTests {

	static List<TestQuestion> testQuestions;
	DatabaseManager dm = new DatabaseManager();
	static User u;

	@Test
	void test00insertUser(){
		try {
			u = new User();
			u.setEmail("test123@testtest.test");
			u.setPassword("test");
			u.setRole("student");
			u.setLogin("test123");
			Assert.assertEquals("User info not ok","email: test123@testtest.test, role: student", "email: " + u.getEmail() + ", role: " + u.getRole());
			dm.insertUser(u.getEmail(),u.getPassword(), u.getLogin(), u.getRole());
			System.out.println("User created" +  u.getId());
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Test
	void test01contextLoads(){
	}

	@Test
	void test02DBMLogin(){   //need to be able to create users to test this
		try {
			dm.login(u.getEmail(),u.getPassword());
			System.out.println("Login successful:" + u.getEmail() + ", " + u.getPassword());
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void test03DBMSave(){

		testQuestions = new Vector<>();
		//testQuestions.add();
		try {
			dm.save(testQuestions);

		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void test04DBMSaveQuestions(){
		dm.saveQuestions(testQuestions);
	}

	@Test
	void test05DBMUpdate(){
		//dm.update();
	}

	@Test
	void test06DBMUpdateQuestions(){
		//dm.updateQuestion();
	}

	@Test
	void test07DBMDelete(){
		//dm.delete();
	}

}
