package com.nyy.bookstore.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BOOK_STORE_USER")
public class BookstoreUser {

    @Id
    @SequenceGenerator(name="book_user_seq",sequenceName = "book_user_seq",allocationSize = 50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "book_user_seq")
    private int userId;

    @Column(name="USER_NAME",nullable = false,length = 256)
    private String userName;

    @Column(name="FIRST_NAME",nullable = true,length = 256)
    private String firstName;

    @Column(name="LAST_NAME",nullable = false,length = 256)
    private String lastName;

    @Column(name="ADDRESS",nullable = true,length = 512)
    private String address;

    @Column(name="DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    public BookstoreUser()
    {

    }

    public BookstoreUser(String userName, String firstName, String lastName, String address, Date dob) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "BookstoreUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                '}';
    }
}
