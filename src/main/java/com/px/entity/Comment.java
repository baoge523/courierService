package com.px.entity;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 17:59
 */

import java.util.Date;

public class Comment {
    private int id;
    private int userId;
    private int horsemanId;
    private int orderId;
    private String message;
    private int satiInt ;
    private Date commentTime;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", horsemanId=" + horsemanId +
                ", orderId=" + orderId +
                ", message='" + message + '\'' +
                ", satiInt=" + satiInt +
                ", commentTime=" + commentTime +
                '}';
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

    public int getHorsemanId() {
        return horsemanId;
    }

    public void setHorsemanId(int horsemanId) {
        this.horsemanId = horsemanId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSatiInt() {
        return satiInt;
    }

    public void setSatiInt(int satiInt) {
        this.satiInt = satiInt;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
