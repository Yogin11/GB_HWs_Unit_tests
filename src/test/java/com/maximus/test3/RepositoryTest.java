package com.maximus.test3;

import com.maximus.task3.UserRepository;
import com.maximus.task3.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryTest {
    UserRepository repository;
    User nonAdminUser1;
    User nonAdminUser2;
    User adminUser1;
    User adminUser2;

    @BeforeEach
    void initialize() {
        repository = new UserRepository();
        nonAdminUser1 =  new User("simpleUser1", "12345");
        nonAdminUser2 = new User("simpleUser2","----");
        adminUser1 = new User("admin1","king",true);
        adminUser2 = new User("admin2","tsar",true);
        nonAdminUser1.authorize("simpleUser1", "12345");
        nonAdminUser2.authorize("simpleUser2", "----");
        adminUser1.authorize("admin1","king");
        adminUser2.authorize("admin2","tsar");
    }

    @Test
    void allSimpleUsersAreLoggedOff() {
        repository.addUser(nonAdminUser1);
        repository.addUser(nonAdminUser2);
        repository.logAllOff();
        assertTrue(repository.getRepo().isEmpty());
    }


    @Test
    void adminUserIsKeptLoggedSimpleUserNot() {
        repository.addUser(adminUser1);
        repository.addUser(nonAdminUser1);
        repository.logAllOff();
        assertTrue(repository.findByName("admin1") &&
                   !repository.findByName("simpleUser1"));
    }
    @Test
    void allAdminUsersAreKeptLogged() {
        repository.addUser(adminUser1);
        repository.addUser(adminUser2);
        repository.logAllOff();
        assertThat(repository.getRepo().size()).isEqualTo(2);
    }







}
