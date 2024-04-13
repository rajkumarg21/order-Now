package com.raj.orderNow.services;

import java.util.List;

import com.raj.orderNow.Entities.Order;
import com.raj.orderNow.Entities.User;

public interface OrderService {
	public Order createOrder(Order order);
	public List<Order> getOrders();
	public Order getOrder(Integer orderId);
	public Order updateOrder(Order order);
	public String deleteOrder(Integer orderId);
}
