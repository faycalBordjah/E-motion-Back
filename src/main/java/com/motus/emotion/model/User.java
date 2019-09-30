package com.motus.emotion.model;

import com.motus.emotion.model.custom.Address;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Date birthDay;
    @Column(nullable = false)
    private String mail;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int zipCode;
    @Column(nullable = false)
    private int permitNum;
    @Column(nullable = false)
    @Embedded
    private Address address;
    @Column(nullable = false, updatable = false)
    private Date creationDate;
    @Column(nullable = false)
    private Date modificationDate;

    public User() {
    }

    public User(String firstName, String lastName, Date birthDay, String mail, String password, int permitNum, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.mail = mail;
        this.password = password;
        this.permitNum = permitNum;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", permitNum=" + permitNum +
                ", address=" + address +
                '}';
    }
}
