package com.px.entity;/* *
 * @ Author: LJH
 * @ Date: 2019/6/14 17:57
 */

public class Detail {
    //骑手接单产生的一张表
    private int id;
    private int horsemanId;//骑手id
    private int orderId;//订单id

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", horsemanId=" + horsemanId +
                ", orderId=" + orderId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
