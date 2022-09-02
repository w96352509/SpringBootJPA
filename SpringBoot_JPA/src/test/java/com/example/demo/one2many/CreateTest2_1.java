package com.example.demo.one2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

// 雙向傳統
@SpringBootTest
public class CreateTest2_1 {

	@Autowired
	MenuGroupRepository meunGroupRepository;
	
	@Autowired
	MenuItemRepository meunItemRepository;
	
	@Test
	public void test() {
		
		MenuGroup mg1 = new MenuGroup();
		mg1.setName("1號餐");
		
		MenuItem m1 = new MenuItem();
		m1.setName("可樂");
		m1.setPrice(20);
		
		MenuItem m2 = new MenuItem();
		m2.setName("漢堡");
		m2.setPrice(60);
		
		// 設置關聯(傳統方式)
		mg1.getItems().add(m1);
		mg1.getItems().add(m2);
		m1.setMenuGroup(mg1);
		m2.setMenuGroup(mg1);
		
		// 執行保存
		meunGroupRepository.save(mg1);
		meunItemRepository.save(m1);
		meunItemRepository.save(m2);
		
	}
	
}
