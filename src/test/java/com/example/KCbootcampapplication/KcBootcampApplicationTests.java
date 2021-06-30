package com.example.KCbootcampapplication;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.TestQuestion;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.service.DatabaseManager;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
class KcBootcampApplicationTests{

	List<TestQuestion> testQuestions;
	DatabaseManager dm = new DatabaseManager();
	User u = new User();
	KnowledgeCheck kc;
	TestQuestion tq;

	@Test
	void test00_insertUser(){
		try {
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
	void test01_contextLoads(){
	}

	@Test
	void test02_DBMLogin(){
		try {
			u.setEmail("test123@testtest.test");
			u.setPassword("test");
			u.setRole("student");
			u.setLogin("test123");
			dm.login(u.getEmail(),u.getPassword());
			System.out.println("Login successful:" + u.getEmail() + ", " + u.getPassword());
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void test03_DBMSave(){
		tq = new TestQuestion();
		kc = new KnowledgeCheck();

		u.setEmail("test456@testtest.test");
		u.setPassword("test456");
		u.setRole("student");
		u.setLogin("test456");
		tq.setQuestion("what is life");
		tq.setType("test");
		kc.setKcName("Test");
		kc.setQuestions(testQuestions);
		kc.setIsShow(true);
		kc.setStartTime(LocalDateTime.now());
		kc.setFinishTime(LocalDateTime.now());
		try {
			dm.save(u);
			dm.save(kc);
			dm.save(tq);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void test04DBMSaveQuestions(){
		testQuestions = new ArrayList<>();
		tq = new TestQuestion();
		testQuestions.add(tq);
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
		kc.setQuestions(testQuestions);
		dm.delete(u);
		dm.delete(kc);
		dm.delete(testQuestions);
	}

}
