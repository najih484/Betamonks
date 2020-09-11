package com.usersappointment.entity;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
//import java.sql.Time;

@Entity
@Table(name = "USER_APPOINTMENT_TABLE")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer id;

    @NotNull
    @Column(name="name")
    public String name;

    @NotNull
    @Column(name="email")
    @Email(message = "Please enter a valid mail address")
    public String email;

    @NotNull
    @Column(name="phone")
    @Pattern(regexp="(^$|[0-9]{10})")
    public String phone;



    @NotNull
    @Column(name="time")
    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
    //@Temporal(TemporalType.TIME)
    public String time;

    @NotNull
    @Column(name= "date")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    @FutureOrPresent
    @Temporal(TemporalType.DATE)
    public Date date;


    public Users(){


    }

    public Users(Integer id, @NotNull String name, @NotNull @Email(message = "Please enter a valid mail address") String email, @NotNull @Pattern(regexp = "(^$|[0-9]{10})") String phone, @NotNull @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]") String time, @NotNull @FutureOrPresent Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.time = time;
        this.date = date;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
