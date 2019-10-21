package com.motus.emotion.dto;

import com.motus.emotion.model.Address;

import javax.validation.constraints.*;
import java.util.Date;

public class UserDto {

    @Size(min = 4,max = 100)
    @NotBlank(message = "first name should be set")
    private String firstName;

    @Size(min = 4,max = 100)
    @NotBlank(message = "last name should be set")
    private String lastName;

    @NotNull(message = "birth day should be set")
    @Past
    private Date birthDay;

    @Size(min = 4,max = 100)
    @NotBlank(message = "mail should be set")
    @Email
    private String mail;
    @Size(min = 6, max = 200)
    @NotBlank(message = "password must be set")
    private String password;

    @Size(min = 6, max = 200)
    @NotBlank(message = "phone number must be set")
    private String phone;

    @Min(value = 9)
    @NotNull(message = "permitNum must be set  must be set")
    private int permitNum;

    // @NotNull(message = "Address  must be set")
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
