package com.sn.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sn.dbo.CustomerDBO;

@Repository
@Transactional
public interface CustRepo extends JpaRepository<CustomerDBO, Long> {

}
