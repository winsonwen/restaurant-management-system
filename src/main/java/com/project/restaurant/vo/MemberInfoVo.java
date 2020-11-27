package com.project.restaurant.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@ToString
@Data
@TableName("customer_info")
public class MemberInfoVo implements Serializable {

    @TableId
    private int id;

//    public MemberInfoVo(String firstName, String lastName, String phoneNumber, String email) {
//        this.staffFirstName = firstName;
//        this.staffLastName = lastName;
//        this.phone = phoneNumber;
//        this.email = email;
//    }
    private Date birthday;

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
    private String phone;
    @NotEmpty(message = "Email should be submitted")
    @Email(message = "Email is not valid")
    private String email;
    private int parentId = 1;
    private String title;
    private String gender;
    public String stressName;
    public MemberInfoVo() {
    }

    public MemberInfoVo(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone = phoneNumber;
        this.email = email;

    }
}
