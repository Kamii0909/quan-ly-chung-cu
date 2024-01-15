package edu.hust.it3180;

public class Admin {
    int id;
    String username, password;

    public Admin(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
