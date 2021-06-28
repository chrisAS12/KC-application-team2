package service;

import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private List<User> allUsers = new ArrayList<>();

    public List<User> getAllUsers(){
        Session session = factory.openSession();
        Transaction transcation = null;
       // try{
       // }
    return null;
    }
}
