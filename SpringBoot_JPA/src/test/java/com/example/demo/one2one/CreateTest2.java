package com.example.demo.one2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2one.Department;
import com.example.demo.entity.one2one.Manager;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ManagerRepository;

@SpringBootTest
public class CreateTest2 {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Test
	public void test() {
		
		Manager manager = managerRepository.findById(1L).get();	
		Department department = new Department();
		department.setName("IT");
		// 設置關聯
		department.setManager(manager);
		// 儲存
		managerRepository.save(manager);
		departmentRepository.save(department);
		System.out.println("ADD ok");
		
	}
	
}
