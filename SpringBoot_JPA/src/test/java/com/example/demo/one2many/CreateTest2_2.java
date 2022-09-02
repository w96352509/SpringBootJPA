package com.example.demo.one2many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

// 雙向
@SpringBootTest
public class CreateTest2_2 {

	@Autowired
	MenuGroupRepository meunGroupRepository;
	
	@Autowired
	MenuItemRepository meunItemRepository;
	
	@Test
	public void test() {
		
		MenuGroup mg1 = new MenuGroup();
		mg1.setName("2號餐");
		
		MenuItem m1 = new MenuItem();
		m1.setName("紅茶");
		m1.setPrice(15);
		
		MenuItem m2 = new MenuItem();
		m2.setName("熱狗");
		m2.setPrice(40);
		
		// 設置關聯(雙向由多方)
		// 因為在單方有設定 mappedBy 所以可以不用建立單方關聯
		// 因以上下兩行不需撰寫
		// mg1.getItems().add(m1);
		// mg1.getItems().add(m2);
		m1.setMenuGroup(mg1);
		m2.setMenuGroup(mg1);
		
		// 執行保存
		meunGroupRepository.save(mg1);
		meunItemRepository.save(m1);
		meunItemRepository.save(m2);
		
	}
	
}
