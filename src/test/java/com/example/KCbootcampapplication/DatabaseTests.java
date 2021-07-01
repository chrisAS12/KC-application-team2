package com.example.KCbootcampapplication;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.TestQuestion;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.service.DatabaseManager;
import org.springframework.test.context.ContextConfiguration;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;


@ContextConfiguration(locations = "classpath:hibernate.cfg.xml")
public class DatabaseTests {

    List<TestQuestion> testQuestions;
    DatabaseManager dm = new DatabaseManager();
    User u = new User();
    KnowledgeCheck kc;
    TestQuestion tq;

    @Test
    public void test00_insertUser(){
        try {
            u.setEmail("test123@testtest.test");
            u.setPassword("test");
            u.setRole("student");
            u.setLogin("test123");
            assertEquals( "User info not set correctly","email: test123@testtest.test, role: student", "email: " + u.getEmail() + ", role: " + u.getRole());
            dm.insertUser(u.getEmail(),u.getPassword(), u.getLogin(), u.getRole());
            System.out.println("User created" + u.getLogin());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test02_DBMLogin(){
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
    public void test03_DBMSave(){
        tq = new TestQuestion();
        kc = new KnowledgeCheck();
        testQuestions = new ArrayList<>();
        u.setEmail("test456@testtest.test");
        u.setPassword("test456");
        u.setRole("student");
        u.setLogin("test456");
        tq.setQuestion("what is life");
        tq.setType("test");
        testQuestions.add(tq);
        kc.setKcName("Test");
        kc.setQuestions(testQuestions);
        kc.setIsShow(true);
        kc.setStartTime(LocalDateTime.now());
        kc.setFinishTime(LocalDateTime.now());
        try {
            dm.save(testQuestions);
            dm.save(u);
            dm.save(kc);
            dm.save(tq);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test04_DBMSaveQuestions(){
        testQuestions = new ArrayList<>();
        tq = new TestQuestion();
        tq.setQuestion("what");
        Random a = new Random();
        byte[] letters = new byte[7];
        int b = a.nextInt(30);
        try {
            while (b + 1 > 1) {
                String testStr = new String(letters, Charset.forName("UTF-8"));
                tq.setQuestion(testStr);
                kc.
                tq.setType("a");
                tq.setCorrectAnswer("a" + b);
                testQuestions.add(tq);
                System.out.println(tq.getQuestion() + " " + tq.getCorrectAnswer() + " " + tq.getClass());
                b--;
            }
            dm.saveQuestions(testQuestions);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void test05_DBMUpdate(){
        //dm.update();
    }

    @Test
    public void test06_DBMUpdateQuestions(){
        //dm.updateQuestion();
    }

    //@Test
    public void test07DBMDelete(){
        kc = new KnowledgeCheck();
        testQuestions = new ArrayList<>();
        kc.setKcName("Test");
        testQuestions.add(tq);
        kc.setQuestions(testQuestions);
        kc.setIsShow(true);
        kc.setStartTime(LocalDateTime.now());
        kc.setFinishTime(LocalDateTime.now());
        try {
            dm.delete(u);
            dm.delete(kc);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
