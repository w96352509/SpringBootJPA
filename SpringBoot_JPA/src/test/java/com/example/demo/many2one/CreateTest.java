package com.example.demo.many2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class CreateTest {

	@Autowired
	CustomerRepository customerReposirory;
	
	@Autowired
	OrderRepository orderReposirory;
	
	@Test
	public void test() {
		
		Customer c1 = new Customer();
		c1.setName("John");
		c1.setAge(20);
		
		Customer c2 = new Customer();
		c2.setName("Mary");
		c2.setAge(30);
		
		Order o1 = new Order();
	    o1.setName("A1");
	    
	    Order o2 = new Order();
	    o2.setName("B2");
	    
	    Order o3 = new Order();
	    o3.setName("C3");
	    
	    // 設置關聯關係
	    o1.setCustomer(c1);
	    o2.setCustomer(c1);
	    o3.setCustomer(c2);
	    
	    // 執行保存
	    // 是先保存單方再保存多方
	    // 相反則失敗
	    customerReposirory.save(c1);
	    customerReposirory.save(c2);
	    orderReposirory.save(o1);
	    orderReposirory.save(o2);
	    orderReposirory.save(o3);
	    
	}
	
}
