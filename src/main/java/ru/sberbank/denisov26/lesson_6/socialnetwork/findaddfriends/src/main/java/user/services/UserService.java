package user.services;

import profiles.interfaces.User;
import user.dao.UserDao;

public class UserService {

    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public User findFriend(String someText) {
        return dao.findFriend(someText);
    }

}