package com.sn.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sn.vo.CustomerVO;

@Service
public class SenderService implements ISenderService{
	
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${customer.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${customer.rabbitmq.routingkey}")
	private String routingkey;
	

	@Override
	public void send(CustomerVO custVO) {
		amqpTemplate.convertAndSend(exchange,routingkey,custVO);
		
	}
	
	
	

}
