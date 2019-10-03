package com.motus.emotion.model;

import com.motus.emotion.model.custom.Address;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user",uniqueConstraints = {
        @UniqueConstraint(columnNames = "mail")
})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "first name must be set ")
    private String firstName;

    @Column(nullable = false)
    @NotNull(message = "last name must be set ")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "birth day must be set ")
    @Past(message = "birth Date must be on past  ")
    private Date birthDay;

    @Column(nullable = false)
    @NotNull(message = "Email must be set ")
    @Email
    private String mail;

    @Column(nullable = false)
    @NotNull
    @Max(value = 100, message = "Password contains more than 100 chars")
    private String password;

    @Column(nullable = false)
    @NotNull(message = "phone number must be set ")
    private String phone;

    @Column(nullable = false)
    @NotNull(message = "permit number must be set ")
    private int permitNum;

    @Column(nullable = false)
    @NotNull(message = "address must be set")
    @Embedded
    private Address address;

    @Column(updatable = false)
    private Date creationDate;

    @Column
    private Date modificationDate;

    @ManyToMany
    private Set<Role> roles;

    public User() {
    }

    public User(String firstName,
                String lastName,
                Date birthDay,
                String mail,
                String password,
                int permitNum,
                Address address
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.mail = mail;
        this.password = password;
        this.permitNum = permitNum;
        this.address = address;
        this.creationDate = new Date();
        this.modificationDate = new Date();
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
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

    @Override
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

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
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
                ", phone='" + phone + '\'' +
                ", permitNum=" + permitNum +
                ", address=" + address +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", roles=" + roles +
                '}';
    }
}
