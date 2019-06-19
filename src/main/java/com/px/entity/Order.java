package com.px.entity;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 18:01
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int userId;
    private String companyName;
    private String number;
    private String targetAddr;
    private String username;
    private int status;
    private Date publishTime;
    private int money;
    private Horseman horseman;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", companyName='" + companyName + '\'' +
                ", number='" + number + '\'' +
                ", targetAddr='" + targetAddr + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", publishTime=" + publishTime +
                ", money=" + money +
                ", horseman=" + horseman +
                '}';
    }

    public Horseman getHorseman() {
        return horseman;
    }

    public void setHorseman(Horseman horseman) {
        this.horseman = horseman;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTargetAddr() {
        return targetAddr;
    }

    public void setTargetAddr(String targetAddr) {
        this.targetAddr = targetAddr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPublishTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.publishTime);
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
