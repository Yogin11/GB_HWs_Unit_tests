package com.maximus.task3;



public class User {

    private String name;
    private String password;
    private boolean isAdmin;
    private boolean isAuthorized;

    public User(String name, String password) {
       this(name,password,false);
    }

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void authorize(String name, String pass){
        if (this.name.equals(name)&& this.password.equals(pass)){
            isAuthorized = true;
        }
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public String getName() {return name; }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
