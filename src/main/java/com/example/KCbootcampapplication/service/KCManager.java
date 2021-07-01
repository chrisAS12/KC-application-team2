package com.example.KCbootcampapplication.service;
import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.TestQuestion;
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
                    .addAnnotatedClass(TestQuestion.class)
                    .addAnnotatedClass(KnowledgeCheck.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //same for all 10 Knowledge Checks, need to correct only range of question id
    private List <TestQuestion> getKnowledgeCheck1(){
        var session = factory1.openSession();
        var query = "FROM TestQuestion T where T.id >=1 and T.id <=20 ORDER BY T.id asc";

        try {
            return session.createQuery(query).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return new ArrayList<>();
    }
}
