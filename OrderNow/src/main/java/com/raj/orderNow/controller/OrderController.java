package com.raj.orderNow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.raj.orderNow.Entities.Order;
import com.raj.orderNow.Entities.User;
import com.raj.orderNow.services.OrderService;
import com.raj.orderNow.services.UserService;

@Controller
public class OrderController {

	private UserService userService;

	private OrderService orderService;

	public OrderController(UserService userService, OrderService orderService) {
		this.userService = userService;
		this.orderService = orderService;
	}

	@MutationMapping
	public Order createOrder(@Argument String orderDetails, @Argument int price, @Argument String address,
			@Argument int userId) {
		Order order = new Order();
		User user = userService.getUser(userId);
		order.setOrderDetails(orderDetails);
		order.setPrice(price);
		order.setAddress(address);
		order.setUser(user);
		Order order1 = orderService.createOrder(order);
		return order1;

	}

	@QueryMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}

	@QueryMapping
	public Order getOrder(@Argument int orderId) {
		return orderService.getOrder(orderId);
	}

	@MutationMapping
	public String deleteOrder(@Argument int orderId) {
		return orderService.deleteOrder(orderId);
	}
}
