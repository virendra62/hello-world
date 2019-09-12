package com.example.testdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
public class User implements Serializable {

    private @Id
    Long id; // will be set when persisting

    private String firstName;
    private String lastName;
    private int age;
    private long mobile;	

    public User() {
    }

    public User(String firstName, String lastName, int agen, long mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mobile = mobile;
    }

    // getters and setters: ~30 extra lines of code
}
