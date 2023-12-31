package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.entity.User;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public User get(String userName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = (User) session.get(User.class,userName);
            transaction.commit();
            session.close();
            return user;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean update(User entity) {
        return false;
    }
}
