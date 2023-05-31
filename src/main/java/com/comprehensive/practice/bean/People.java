package com.comprehensive.practice.bean;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "\n People{" +
                "index=" + index +
                ", userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
