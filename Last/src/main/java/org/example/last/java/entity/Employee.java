package org.example.last.java.entity;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    public String username;
    public String password;


    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
