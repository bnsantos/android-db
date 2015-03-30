package com.bruno.db.ormlite.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by bruno on 30/03/15.
 */
public class User {
    @DatabaseField(generatedId = true)
    private String id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private Date createdAd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAd() {
        return createdAd;
    }

    public void setCreatedAd(Date createdAd) {
        this.createdAd = createdAd;
    }
}
