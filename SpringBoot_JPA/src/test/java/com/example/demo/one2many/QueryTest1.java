package com.example.demo.one2many;

import javax.persistence.CascadeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

@SpringBootTest
public class QueryTest1 {
	
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	public void test() {
		// 無設定 FetchType 多單方都查
		// 設定為 LAZY 時只查多方表
		MenuItem m1 = menuItemRepository.findById(1L).get();
		System.out.println(m1.getName());
		// 注意 FetchType.LAZY 加載策略若要實施 , 需再 application.yml 中加入 enable_lazy_load_no_trans: true
	    System.out.println(m1.getMenuGroup().getName());
	}
}
