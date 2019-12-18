package com.sn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerContoller.class);
	

	@Autowired
	private ISenderService senderService;

	@Autowired
	private ICustService custService;

	@Value("${customer.name :not found}")
	private String customerName;

	@RequestMapping(value = "/cust")
	public String addCustomerTest() {
		// senderService.send(new CustomerVO(1l, "sn", "nag", "s.na@gmail.com"));
		return customerName;
	}
	
	@RequestMapping(value = "/test")
	public CustomerVO getTest() {
		CustomerVO custVo=new CustomerVO();
		custVo.setFirstName("First");
		custVo.setLastName("Last");
		custVo.setEmail("email..");
		return custVo;
	}

	

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String addCustomer(@RequestBody CustomerVO custVo) {

		logger.info("CustomerVO first Name {}",custVo.getFirstName());
		CustomerDBO custdbo = new CustomerDBO(custVo.getFirstName(), custVo.getLastName(), custVo.getEmail());
		custdbo = custService.addCustomer(custdbo);
		logger.info("CustomerVO first Name {}",custdbo.getFirstName());
		custVo.setCustomerId(custdbo.getId());
		senderService.send(custVo);

		return "Customer added successfully and id:" + custdbo.getId();
	}

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public List<CustomerDBO> getCustomers() {
		return custService.getCustomers();
	}

}
