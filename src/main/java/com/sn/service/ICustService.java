package com.sn.service;

import java.util.List;

import com.sn.dbo.CustomerDBO;

public interface ICustService {
	
	public CustomerDBO addCustomer(final CustomerDBO custdbo);
	
	public List<CustomerDBO> getCustomers() ;


}
