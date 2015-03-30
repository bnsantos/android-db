package com.bruno.db.ormlite.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.Date;

/**
 * Created by bruno on 30/03/15.
 */
public class Project {
    @DatabaseField(generatedId = true)
    private String id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private Date createdAt;
    @ForeignCollectionField
    private ForeignCollection<User> users;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ForeignCollection<User> getUsers() {
        return users;
    }

    public void setUsers(ForeignCollection<User> users) {
        this.users = users;
    }
}
