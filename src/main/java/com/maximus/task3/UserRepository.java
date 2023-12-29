package com.maximus.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UserRepository {

    private List<User> repo;

    public UserRepository() {
        repo = new ArrayList<>();
    }

    public void addUser(User user) {   //User is logging in
        if (user.isAuthorized()) {
            repo.add(user);
        }
    }

    public List<User> getRepo() {
        return repo;
    }

    public boolean findByName(String username) {
        for (User user : repo) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logAllOff() {   // Users are being logged off
//        repo.removeIf(user -> !user.isAdmin());
        Iterator<User> iterator = repo.iterator();
        while (iterator.hasNext())
            if (!iterator.next().isAdmin()) {
                iterator.remove();
            }
    }


}
