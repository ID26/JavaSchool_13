package user.dao;


import profiles.interfaces.User;

import java.util.HashMap;
import java.util.Map;


public class UserDaoImpl implements UserDao {

    private static Map<Long, User> peoples;

    public UserDaoImpl() {
        peoples = new HashMap<>();

        User user1 = new User("Петр", "Иванов", 25, "Куйбышев");
        User user2 = new User("Виктор", "Петров", 26, "Энгельс");
        User user3 = new User("Инокентий", "Сидоров", 24, "Сызрань");
        peoples.put(user1.getId(), user1);
        peoples.put(user2.getId(), user2);
        peoples.put(user3.getId(), user3);
    }

    @Override
    public void addFriend(User user) {
        peoples.put(user.getId(), user);
    }

    @Override
    public User findFriend(String string) {
        long id = Long.parseLong(string);
        return peoples.get(id);
    }

    @Override
    public void deleteFriend(User user) {
        peoples.remove(user.getId());
        System.out.println(String.format("People %s remove from you friends list", user.getName()));
    }

    public static Map<Long, User> getPeoples() {
        return peoples;
    }
}

//import java.util.Arrays;
//import java.util.List;
//
//public class UserDaoImpl implements UserDao {
//
//    private List<User> users;
//
//    public UserDaoImpl() {
//        this.users = Arrays.asList(
//                new User("olesya@gmail.com", "GUEST"),
//                new User("kirill@gmail.com", "USER"),
//                new User("remy@gmail.com", "ADMIN")
//        );
//    }
//
//    @Override
//    public User getUserByUsername(String username) throws Exception {
//        return users.stream().filter(u -> u.getUsername().equals(username))
//                .findAny().orElse(null);
//    }
//
//    @Override
//    public List<User> findAllUsers() {
//        return users;
//    }
//}


