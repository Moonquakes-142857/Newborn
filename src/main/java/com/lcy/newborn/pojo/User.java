package com.lcy.newborn.pojo;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class User {

    @Autowired
    int id;
    @Autowired
    String username;
    @Autowired
    String password;
}
