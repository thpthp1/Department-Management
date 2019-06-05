package com.example.demomanager.models;

import org.springframework.core.style.ToStringCreator;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "dept")
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "DEPTNO")
    @Digits(integer = 2, fraction = 0)
    private Long number;

    @Column(name = "DNAME")
    @NotEmpty
    private String name;

    @Column(name = "LOC")
    @NotEmpty
    private String location;

    public Department(){

    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setLocation(String location) {
        this.location = location.toUpperCase();
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public boolean isNew(){
        return number == null;
    }

    @Override
    public String toString(){
        return new ToStringCreator(this).append("number", number)
                            .append("new", isNew())
                            .append("location", location)
                            .append("name", name)
                            .toString();
    }
}
