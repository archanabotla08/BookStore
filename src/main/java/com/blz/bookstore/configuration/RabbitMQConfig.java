package com.blz.bookstore.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class RabbitMQConfig {

	@Autowired
	private ConnectionFactory rabbitConnectionFactory;

	@Bean
	public DirectExchange rubeExchange() {
		return new DirectExchange("rmq.rube.exchange", true, false);
	}

	@Bean
	public Queue rubeQueue() {
		return new Queue("rmq.rube.queue", true);
	}

	@Bean
	public Binding rubeExchangeBinding(DirectExchange rubeExchange, Queue rubeQueue) {
		return BindingBuilder.bind(rubeQueue).to(rubeExchange).with("rube.key");
	}

	@Bean
	public RabbitTemplate rubeExchangeTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
		rabbitTemplate.setConnectionFactory(rabbitConnectionFactory);
		rabbitTemplate.setExchange("rmq.rube.exchange");
		rabbitTemplate.setRoutingKey("rube.key");
		return rabbitTemplate;
	}
}