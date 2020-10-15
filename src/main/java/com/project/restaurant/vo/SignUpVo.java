package com.project.restaurant.vo;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ToString
@Data
public class SignUpVo {
    @NotEmpty(message = "user name should be submitted")
    @Length(min=6, max=18,message = "user name should be 6-18 character")
    private String userName;

    @NotEmpty(message = "Password should be submit")
    @Length(min=6, max=18,message = "password should be 6-18 character")
    private String passwords;

    @NotEmpty(message = "First Name should be submitted")
    @Length(min=1, max=18,message = "password should be 1-20 character")
    @Pattern(regexp = "([a-zA-Z]*)", message = "must be all letter ")
    private String firstName;

    @NotEmpty(message = "Last Name should be submitted")
    @Length(min=1, max=20,message = "Last Name should be 1-20 character")
    @Pattern(regexp = "([a-zA-Z]*)", message = "must be all letter ")
    private String lastName;

    @NotEmpty(message = "Phone Number should be submitted")
    @Pattern(regexp = "([\\d]{10})", message = "must be Valid Phone number ")
    private String phoneNumber;


    @NotEmpty(message = "Email should be submitted")
    @Email(message = "Email is not valid")
    private String email;


}
