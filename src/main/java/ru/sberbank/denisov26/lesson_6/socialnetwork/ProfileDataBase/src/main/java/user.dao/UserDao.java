package user.dao;

import profiles.interfaces.*;
public interface UserDao {
    void addFriend(User user);
    User findFriend(String string);
    void deleteFriend(User user);
}

//public interface UserDao {
//
//    User getUserByUsername(String username) throws Exception;
//
//    List<User> findAllUsers();
//}