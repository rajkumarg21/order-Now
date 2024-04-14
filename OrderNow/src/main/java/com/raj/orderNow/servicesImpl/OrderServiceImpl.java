package com.raj.orderNow.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.orderNow.Entities.Order;
import com.raj.orderNow.Repository.OrderRepository;
import com.raj.orderNow.helper.ExceptionHelper;
import com.raj.orderNow.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	// Create order
	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	// get all order
	@Override
	public List<Order> getOrders() {

		return orderRepository.findAll();
	}

// get order by id
	@Override
	public Order getOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	// delete order
	@Override
	public String deleteOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		orderRepository.delete(order);

		return "order deleted !! ";
	}

}
