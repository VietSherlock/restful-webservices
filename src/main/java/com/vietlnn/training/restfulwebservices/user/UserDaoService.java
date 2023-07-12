package com.vietlnn.training.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Viet", LocalDate.now().minusYears(26)));
        users.add(new User(++userCount, "Steve Jobs", LocalDate.now().minusYears(60)));
        users.add(new User(++userCount, "CR7", LocalDate.now().minusYears(38)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(Integer id) {
        return users.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
