package com.food.Model;

import java.util.List;

public class OrderHistory {

    private OrderTable order;

    private Restaurant restaurant;

    private List<OrderItem> items;

    public OrderHistory() {
    }

    public OrderHistory(OrderTable order,
                        Restaurant restaurant,
                        List<OrderItem> items){

        this.order=order;

        this.restaurant=restaurant;

        this.items=items;
    }

    public OrderTable getOrder() {
        return order;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getItems() {
        return items;
    }

}