package repository;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.SessionFactoryImpl;

import java.util.List;

public class UserRepositoryImpl implements UserRepositoryIT {
    private Transaction transaction;

    public void createUser(User user) {
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List readAllUsers() {
        List<User> listOfUsers;
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfUsers = session.createQuery("from User", User.class).list();
            transaction.commit();
        }
        return listOfUsers;
    }

    public User getById(Integer id) {
        User user;
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        }
        return user;
    }

    public User update(Integer id, User user) {
        User updatedUser;
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            updatedUser = session.get(User.class, id);
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setCompanyName(user.getCompanyName());
            session.persist(updatedUser);
            transaction.commit();
        }
        return updatedUser;
    }

    public void removeUser(Integer id) {
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            transaction.commit();
        }
    }


}
