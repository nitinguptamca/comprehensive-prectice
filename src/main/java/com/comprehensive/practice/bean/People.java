package com.comprehensive.practice.bean;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class People {

    private int index;
    private String userId;
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String jobTitle;
}
