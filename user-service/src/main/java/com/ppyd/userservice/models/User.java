package com.ppyd.userservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Long phone;
    private String address;
}
