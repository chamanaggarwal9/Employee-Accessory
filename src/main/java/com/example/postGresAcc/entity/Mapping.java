package com.example.postGresAcc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mapping")
public class Mapping {

    @Id
    private int mappingId;
    private int userId;
    private int accessoryId;

    public int getMappingId() {
        return mappingId;
    }

    public void setMappingId(int mappingId) {
        this.mappingId = mappingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(int accessoryId) {
        this.accessoryId = accessoryId;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "mappingId=" + mappingId +
                ", userId=" + userId +
                ", accessoryId=" + accessoryId +
                '}';
    }
}
