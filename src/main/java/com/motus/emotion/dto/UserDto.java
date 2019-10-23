package com.motus.emotion.dto;

import com.motus.emotion.model.Address;

import javax.validation.constraints.*;
import java.util.Date;

public class UserDto {

    private String firstName;

    private String lastName;

    private Date birthDay;

    private String mail;
    private String password;

    private String phone;

    private int permitNum;

    private Address address;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPermitNum() {
        return permitNum;
    }

    public void setPermitNum(int permitNum) {
        this.permitNum = permitNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
