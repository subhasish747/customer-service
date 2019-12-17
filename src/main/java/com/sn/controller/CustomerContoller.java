package com.sn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sn.service.ISenderService;
import com.sn.service.SenderService;
import com.sn.vo.CustomerVO;

@RestController
public class CustomerContoller {
	
	
	@Autowired
	private ISenderService senderService;
	
	@RequestMapping(value="/cust")
	public void addCustomer() {
		senderService.send(new CustomerVO(1l,"sn","nag","s.na@gmail.com"));
	}

}
