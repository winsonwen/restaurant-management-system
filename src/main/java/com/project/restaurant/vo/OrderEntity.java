package com.project.restaurant.vo;


import lombok.ToString;

import java.math.BigDecimal;
@ToString
public class OrderEntity {
    int orderId;
    String foodItems;
    int quantity;
    BigDecimal orderTotal;
    CustomerEntity customerEntity;


    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    int orderStatus;

    public OrderEntity() {
    }

    public OrderEntity(int orderId, String foodItems, int quantity, BigDecimal orderTotal, CustomerEntity customerEntity, int orderStatus) {
        this.orderId = orderId;
        this.foodItems = foodItems;
        this.quantity = quantity;
        this.orderTotal = orderTotal;
        this.customerEntity = customerEntity;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(String foodItems) {
        this.foodItems = foodItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}
