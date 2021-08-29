package test.app.service;

import org.springframework.stereotype.Service;
import test.app.dao.UserDao;
import test.app.model.User;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

}
