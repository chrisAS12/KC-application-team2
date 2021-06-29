package com.example.KCbootcampapplication;

import com.example.KCbootcampapplication.domain.User;

import com.example.KCbootcampapplication.service.DatabaseManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
class KcBootcampApplicationTests {

	List<Object> testQuestions;
	DatabaseManager dm = new DatabaseManager();
	User u;

	@Test
	void test00createUser(){
		try {
			u = new User();
			u.setEmail("test123@testtest.test");
			u.setPassword("test");
			u.setRole("student");
			u.setLogin("test123");
			Assert.assertEquals("User info not ok","email: test123@testtest.test, role: student", "email: " + u.getEmail() + ", role: " + u.getRole());
			dm.insertUser(u.getEmail(),u.getPassword(), u.getLogin(), u.getRole());
			System.out.println("User created");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Test
	void test01contextLoads(){
	}

	@Test
	void test02DBMLogin(){   //need to be able to create users to test this
		//manager.login()
	}

	@Test
	void test03DBMSave(){
		testQuestions = new ArrayList<>();
		testQuestions.add(new String("test"));
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
