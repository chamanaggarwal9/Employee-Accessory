package com.example.postGresAcc.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AccessoryDto {

    @Id
    private int accessoryId;
    private String accessoryName;
    private String category;
    private int model;

    @Transient
    private int userId = 0;

    public int getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(int accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AccessoryDto{" +
                "accessoryId=" + accessoryId +
                ", accessoryName='" + accessoryName + '\'' +
                ", category='" + category + '\'' +
                ", model=" + model +
                ", userId=" + userId +
                '}';
    }
}
