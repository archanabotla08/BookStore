package com.blz.bookstore.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.bookstore.dto.EmailObject;
import com.blz.bookstore.model.CartData;
import com.blz.bookstore.model.CustomerModel;
import com.blz.bookstore.model.OrderData;
import com.blz.bookstore.model.UserModel;
import com.blz.bookstore.repository.CartRepository;
import com.blz.bookstore.repository.CustomerRepository;
import com.blz.bookstore.repository.OrderRepository;
import com.blz.bookstore.repository.UserRepository;
import com.blz.utility.EmailSender;
import com.blz.utility.JwtGenerator;
//import com.blz.utility.MailData;
import com.blz.utility.RabbitMQSender;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailSender emailSender;

	public OrderData getOrderSummary(String token) {
		Long userId = JwtGenerator.decodeJWT(token);
		Optional<OrderData> userOrders = orderRepository.findByUserId(userId);
		return userOrders.get();
	}

	public Long placeOrder(String token) throws MessagingException {
		Long orderId = generateOrderId();
		Long userId = JwtGenerator.decodeJWT(token);
		List<CartData> cart = cartRepository.findByUserId(userId);
		Optional<UserModel> user = userRepository.findById(userId);
		double totalPrice = cart.stream().mapToDouble(book -> book.getPrice() * book.getQuantity()).sum();
		Optional<CustomerModel> customer = customerRepository.findByUserId(userId);
		OrderData order = new OrderData(orderId, userId, cart, totalPrice, customer.get());
		OrderData save = orderRepository.save(order);
		System.out.println(save);
		String body = "OrderId: " + orderId + "\n" + "customer: " + customer.get() + "\n" + "totalPrice: " + totalPrice + "cart: " + cart ;
//		String orderMail = mailData.getOrderMail(orderId, customer.get(), totalPrice, cart);
//		rabbitMQSender.send(new EmailObject(user.get().getEmailId(), "Order Summary", orderMail));
		
		emailSender.send(user.get().getEmailId(), "Order Summary",body, token);
		return orderId;
	}

	public Long generateOrderId() {
		boolean isUnique = false;
		Long orderId = Long.valueOf(0);
		while (!isUnique) {
			orderId = (long) Math.floor(100000 + Math.random() * 999999);
			Optional<OrderData> byId = orderRepository.findById(orderId);
			if (!byId.isPresent()) {
				isUnique = true;
			}
		}
		return orderId;
	}
}
