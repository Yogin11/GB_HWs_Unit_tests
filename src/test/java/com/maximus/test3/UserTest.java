package com.maximus.test3;

import com.maximus.task3.UserRepository;

import com.maximus.task3.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    User user;
    UserRepository repo;

    @BeforeEach
    void initialize(){
        user = new User("name","password");
        repo = new UserRepository();
    }

    @Test
    void isUserAuthenified(){
        user.authorize("name", "password");
        assertTrue(user.isAuthorized());
    }

    @ParameterizedTest
    @CsvSource({
            "nick,password",
            "name, pppp",
            "nick, pppp"})
    void isNotAuthorized(String name, String pass){
        user.authorize(name, pass);
        assertFalse(user.isAuthorized());
    }

    @Test
    void userIsAdded(){
        user.authorize("name", "password");
        repo.addUser(user);
        assertTrue(repo.findByName(user.getName()));
    }

    @Test
    void userIsNotAdded(){
        repo.addUser(user);
        assertFalse(repo.findByName(user.getName()));
    }

}
