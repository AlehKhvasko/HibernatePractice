package repository;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Collection;
import utils.SessionFactoryImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepositoryIT {
    private Transaction transaction;

    public void createUser(User user) {
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public List<User> readAllUsers() {
        List<User> listOfUsers;
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            listOfUsers = session.createQuery("from User", User.class).list();
        }
        return Collections.unmodifiableList(listOfUsers);
    }

    public Optional<User> getById(Integer id) {
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(User.class, id));
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
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
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
        return updatedUser;
    }

    public void removeUser(Integer id) {
        try (Session session = new SessionFactoryImpl().getSession().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }


}
