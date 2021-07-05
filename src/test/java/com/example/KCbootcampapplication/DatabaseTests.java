package com.example.KCbootcampapplication;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.service.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import static org.junit.Assert.*;

public class DatabaseTests {

    List<Question> questions;
    DatabaseManager dm = new DatabaseManager();
    User u;
    KnowledgeCheck kc;
    Question tq;

    @Before
    public void setUp(){
        u = new User();
        tq = new Question();
        kc = new KnowledgeCheck();
        tq.setTitle("what is life");
        tq.setType("test");
        tq.setAnswer("a");
        kc.setName("Test");
        kc.setIsShow(true);
        kc.setStartTime(LocalDateTime.now());
        kc.setFinishTime(LocalDateTime.now());
        tq.setKnowledgeCheck(kc);
        u.setEmail("test123@testtest.test");
        u.setPassword("test");
        u.setRole("student");
        u.setLogin("test123");
        u.setName("John");
    }

    @After
    public void cleanUp(){
        dm.delete(u);
        dm.delete(tq);
        dm.delete(kc);
    }


    @Test
    public void test00_saveUser(){
            assertEquals( "User info not set correctly","email: test123@testtest.test, role: student", "email: " + u.getEmail() + ", role: " + u.getRole());
            dm.save(u);
            System.out.println("User created" + u.getName());
    }

    @Test
    public void test02_DBMLogin(){
            dm.login(u.getEmail(),u.getPassword());
            System.out.println("Login successful:" + u.getEmail() + ", " + u.getPassword());
    }

    @Test
    public void test03_DBMSave(){
            dm.save(u);
            kc.setUser(u);
            dm.save(kc);
            tq.setKnowledgeCheck(kc);
            dm.save(tq);
    }

    @Test
    public void test04_DBMSaveAndGetQuestions(){
        questions = new ArrayList<>();
        Random a = new Random();
        byte[] letters = new byte[7];
        new Random().nextBytes(letters);
        int b = a.nextInt(30);
        kc.setName("test Save Questions");
        u.setName("Save questions tester");
        dm.save(u);
        dm.save(kc);
        tq.setType("dbmsave");
        tq.setKnowledgeCheck(kc);
        while (b + 1 > 1) {
            String testStr = new String(letters, Charset.forName("UTF-8"));
            tq.setTitle(testStr);
            tq.setAnswer("a" + b);
            dm.save(tq);
            questions.add(tq);
            b--;
        }
        dm.saveQuestions(questions);
        assertEquals("Not the right test", questions.get(0), dm.getQuestionsForKc(kc.getId()).get(0));
    }

//    Question ab = new Question();
//        ab.setTitle("write your name");
//        ab.setType("free");
//        ab.setAnswer("aaaaa");
//        ab.setKnowledgeCheck(kc);
//        questions.add(ab);
//    Question db = new Question();
//        db.setTitle("1. Please write your name and surname with Latin characters only, e.g.");
//    Question cb = new Question();
//        cb.setTitle("2. What is valid method signature as an entry point into Java program:");
//        cb.setOpt1("a) public static main()");
//        cb.setOpt2("b) public void static main (String [] args)");
//        cb.setOpt3("c) public static int main (String [] args)");
//        cb.setOpt4("d) public static void main (String args [])");
//        cb.setAnswer("d");
//        cb.setKnowledgeCheck(kc);
//        cb.setType("aaa");
//        dm.save(cb);
//        dm.save(ab);
//        questions.add(cb);
}
