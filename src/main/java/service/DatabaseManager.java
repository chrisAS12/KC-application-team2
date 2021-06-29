package service;
import domain.TestAnswer;
import domain.TestQuestion;
import domain.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class DatabaseManager {

    private static SessionFactory factory;

    public DatabaseManager() {
        try {
            factory = new Configuration().configure()
                    .addAnnotatedClass(TestAnswer.class)
                    .addAnnotatedClass(TestQuestion.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public User login(String email, String password) {
        var session = factory.openSession();

        try {
            String hql = "FROM User U WHERE U.email = :email and U.password = MD5(:pwd)";
            Query query1 = session.createQuery(hql);

            query1.setParameter("email", email);
            query1.setParameter("pwd", password);

            var results = query1.list();

            if (results.size() > 0) {
                return (User) results.get(0);
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
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void saveQuestions(List <Object> items){

        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            for ( var item: items
                 ) {
             session.save(item);
            }
            tx.commit();
        } catch (HibernateException exception) {
            if(tx !=null){
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
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(ex);
        } finally {
            session.close();
        }
    }

    public void updateQuestion(TestQuestion testQuestion) {
        if(testQuestion.getId() == 0) {
            return;
        }
        update(testQuestion);
    }

    public void delete(Object obj) {
        var session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException exception) {
            if(tx != null) {
                tx.rollback();
            }
            System.err.println(exception);
        } finally {
            session.close();
        }
    }

    public TestQuestion getQuestionsFromTestId(int testId){
        var session = factory.openSession();
        try {
            String hql = "FROM TestQuestion T WHERE T.test_question_id = :testId";
            Query query1 = session.createQuery(hql);

            query1.setParameter("testId", testId);
            var results = query1.list();

            if (results.size() > 0) {
                return (TestQuestion) results;
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public void createQuestion(){
        TestQuestion question = new TestQuestion();
    }

// FROM Questions Q WHERE Q.id = :1
    // question_variants
}
