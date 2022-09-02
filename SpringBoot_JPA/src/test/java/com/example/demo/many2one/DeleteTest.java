package com.example.demo.many2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class DeleteTest {

	@Autowired
	CustomerRepository customerReposirory;
	
	@Autowired
	OrderRepository orderReposirory;
	
	@Test
	public void test() {
		orderReposirory.deleteById(1L);
		
	}
	
}
