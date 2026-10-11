package com.food.DAO;

import java.util.List;

import com.food.Model.OrderTable;

public interface OrderTableDAO {

    int addOrder(OrderTable order);

    OrderTable getOrder(int orderId);

    void updateOrder(OrderTable order);

    void deleteOrder(int orderId);

    List<OrderTable> getAllOrders();
}