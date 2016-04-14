package com.bruno.db.sugar.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by bruno on 31/03/15.
 */
public class Book extends SugarRecord<Book> {
    private String name;
    private Date createdAt;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
