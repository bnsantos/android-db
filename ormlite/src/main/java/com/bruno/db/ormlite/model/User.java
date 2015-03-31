package com.bruno.db.ormlite.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by bruno on 30/03/15.
 */
public class User {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            return id == ((User) o).id && name.equals(((User) o).name) && createdAt.equals(((User) o).createdAt);
        }
        return false;
    }
}
