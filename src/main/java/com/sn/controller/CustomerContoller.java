package com.sn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sn.dbo.CustomerDBO;
import com.sn.service.ICustService;
import com.sn.service.ISenderService;
import com.sn.vo.CustomerVO;

@RestController
@RequestMapping("/service1")
public class CustomerContoller {

	@Autowired
	private ISenderService senderService;

	@Autowired
	private ICustService custService;
	
	
	@Value("${customer.name :not found}")
	private String customerName;
	


	@RequestMapping(value = "/cust")
	public String addCustomerTest() {
		//senderService.send(new CustomerVO(1l, "sn", "nag", "s.na@gmail.com"));
		return customerName;
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String addCustomer(CustomerDBO custdbo) {
		custdbo = custService.addCustomer(custdbo);
		senderService.send(
				new CustomerVO(custdbo.getId(), custdbo.getFirstName(), custdbo.getLastName(), custdbo.getEmail()));

		return "Customer added successfully and id:" + custdbo.getId();
	}

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public List<CustomerDBO> getCustomers() {
		return custService.getCustomers();
	}
	
	
	

}
