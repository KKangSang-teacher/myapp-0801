package com.test.myapp2.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
