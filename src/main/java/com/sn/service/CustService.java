package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sn.dbo.CustomerDBO;
import com.sn.repo.CustRepo;

@Service
public class CustService implements ICustService {
	
	@Autowired
	private CustRepo custRepo;

	@Override
	public CustomerDBO addCustomer(CustomerDBO custdbo) {
		return custRepo.save(custdbo);
		
	}
	
	
	@Override
	public List<CustomerDBO> getCustomers() {
		return custRepo.findAll();
	}


}
