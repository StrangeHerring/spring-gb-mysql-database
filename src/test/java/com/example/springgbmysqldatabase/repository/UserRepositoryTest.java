package com.example.springgbmysqldatabase.repository;

import com.example.springgbmysqldatabase.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@TestPropertySource(locations="classpath:application.properties")
@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void MainTest(){
        List<User> users = userData();
        List<User> savedUsers = userRepository.saveAll(users);

        User max = userRepository.getOne(3L);
        Assertions.assertEquals("Max", max.getName());

        List<User> allByAgeBetween25and35 = userRepository.findAllByAgeBetween(25, 35);
        Assertions.assertEquals(4, allByAgeBetween25and35.size());
    }

    private List<User> userData(){
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User(null, "Ivan",25 ,"ivan@mail.ru"));
        userList.add(new User(null, "Fedor",18 ,"fedor@mail.ru"));
        userList.add(new User(null, "Max",43 ,"max@mail.ru"));
        userList.add(new User(null, "Oleg",27 ,"oleg@mail.ru"));
        userList.add(new User(null, "Konstantin",19 ,"kosnt@mail.ru"));
        userList.add(new User(null, "Max",40 ,"maxim@mail.ru"));
        userList.add(new User(null, "Ivan",36 ,"vano@mail.ru"));
        userList.add(new User(null, "John",30 ,"john@mail.ru"));
        userList.add(new User(null, "Anton",33 ,"anton@mail.ru"));
        userList.add(new User(null, "Sergey",21 ,"sergey@mail.ru"));
        return userList;
    }

}