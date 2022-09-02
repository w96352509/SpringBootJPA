package com.example.demo.many2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class QueryTest {

	@Autowired
	CustomerRepository customerReposirory;
	
	@Autowired
	OrderRepository orderReposirory;
	
	@Test
	public void test() {
		Order order = orderReposirory.findById(1L).get();
		System.out.println(order.getName());
		System.out.println(order.getCustomer().getName());
		
		
	}
	
}
