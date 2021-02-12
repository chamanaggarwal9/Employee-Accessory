package com.example.postGresAcc.dto;

import java.util.ArrayList;

public class  EmployeeDto {

    private int userId;
    private String name;
    private String email;
    private int phoneNo;
    private String team;
    private String designation;
    private ArrayList<Integer> accessories = new ArrayList<Integer>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public ArrayList<Integer> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<Integer> accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                ", team='" + team + '\'' +
                ", designation='" + designation + '\'' +
                ", accessories=" + accessories +
                '}';
    }
}
