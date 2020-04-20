package com.dayplan.domains;


import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Integer roadTime;
    private String taskName;
    private String time;
    private String taskDescription;
    private String address;
    private Integer holdingTime;

    @ManyToOne
    @JoinColumn(name = "user_login")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoadTime() {
        return roadTime;
    }

    public void setRoadTime(Integer roadTime) {
        this.roadTime = roadTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHoldingTime() {
        return holdingTime;
    }

    public void setHoldingTime(Integer holdingTime) {
        this.holdingTime = holdingTime;
    }
}
