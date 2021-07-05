package com.example.KCbootcampapplication.service;

import com.example.KCbootcampapplication.domain.KnowledgeCheck;
import com.example.KCbootcampapplication.domain.Question;
import com.example.KCbootcampapplication.domain.User;
import com.example.KCbootcampapplication.domain.UserAnswer;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(6);
    ;
    static SessionFactory factory;

    public DatabaseManager() {
        try {
            factory = new Configuration().configure()
                    .addAnnotatedClass(UserAnswer.class)
                    .addAnnotatedClass(Question.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(KnowledgeCheck.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public User login(String email, String password) {
        var session = factory.openSession();
        try {
            String hql = "FROM User U WHERE U.email = :email";
            Query query1 = session.createQuery(hql);

            query1.setParameter("email", email);
            var results = query1.list();
            for (int i = 0; i < results.size(); i++) {
                if (passwordEncoder.matches(password, ((User) results.get(i)).getPassword())) {
                    return (User) results.get(i);
                }
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public void save(Object item) {
        var session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void saveQuestions(List<Question> items) {
        var session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for (var item : items
            ) {
                session.save(item);
            }
            tx.commit();
        } catch (HibernateException exception) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public void update(Object item) {
        var session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void updateQuestion(Question question) {
        if (question.getId() == 0) {
            return;
        }
        update(question);
    }

    public void delete(Object obj) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException exception) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public Question getQuestionsFromTestId(int knowledgeCheckId) {
        var session = factory.openSession();
        try {
            // FIXME
            String hql = "FROM KnowledgeCheck K WHERE  K.question = :knowledgeCheckId";
            Query query = session.createQuery(hql);

            query.setParameter("knowledgeCheckId", knowledgeCheckId);
            var results = query.list();

            if (results.size() > 0) {
                return (Question) results;
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public List<KnowledgeCheck> getKnowledgeChecksByNames(User user) {
        var session = factory.openSession();
        try {
            String hql = "FROM KnowledgeCheck K WHERE  K.user = :user";
            Query query = session.createQuery(hql);
            query.setParameter("user", user);
            return query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public void createQuestion() {
        Question question = new Question();
    }

    public KnowledgeCheck getKcById (int id){

        var session = factory.openSession();

        try {
            return session.get(KnowledgeCheck.class, id);
        } catch (HibernateException exception) {
            System.err.println(exception);
        } finally {
            session.close();
        }
        return null;
    }

    public List <Question> getQuestionsforKc(int kcId){
        var session = factory.openSession();
        var query = "FROM Question Q where Q.knowledgeCheck.id = :kcId";

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
