package com.pavelkostal.Caloric.Tables.entity;

import javax.persistence.*;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {
    @Id
    @SequenceGenerator(
            name = "apartment_sequence",
            sequenceName = "apartment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "apartment_sequence"
    )
    @Column(name = "id")
    private long id;

    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String userName;

    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    public int age;

    @Column(
            name = "weight",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    public int weight;

    @Column(
            name = "height",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    public int height;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
