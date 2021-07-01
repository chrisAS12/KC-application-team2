package com.example.KCbootcampapplication.service;
import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.domain.UserAnswer;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class KCManager {

    private static SessionFactory factory1;

    public KCManager() {
        try {
            factory1 = new Configuration().configure()
                    .addAnnotatedClass(UserAnswer.class)
                    .addAnnotatedClass(Question.class)
                    .addAnnotatedClass(KnowledgeCheck.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //same for all 10 Knowledge Checks, need to correct only number of Q.knowledgeCheck.id
    private List <Question> getKnowledgeCheck1(){
        var session = factory1.openSession();
        var query = "FROM Question Q where Q.knowledgeCheck.id = 1";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    private List <Question> getKnowledgeCheck2(){
        var session = factory1.openSession();
        var query = "FROM Question Q where Q.knowledgeCheck.id = 2";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }

    // TODO: 7/1/2021 need to call all 10 getKC methods here. Then can call this method in controller
    public void showKnowledgeChecks(){
    getKnowledgeCheck1();
    getKnowledgeCheck2();
    }
}
