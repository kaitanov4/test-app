package test.app.dao;

import test.app.model.User;

public interface UserDao {

    void save(User user);

    void update(User user);

}