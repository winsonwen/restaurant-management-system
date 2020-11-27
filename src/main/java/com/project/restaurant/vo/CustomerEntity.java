package com.project.restaurant.vo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CustomerEntity {

    private String firstName;
    private String lastName;
    private String phone;
    public String stressName;

    public CustomerEntity() {
    }

    public CustomerEntity(String firstName, String lastName, String phone, String stressName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.stressName = stressName;
    }

}
