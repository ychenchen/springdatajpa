package com.embracesource.jpa.springdatajpa.service.rolemenu;

//import static org.junit.Assert.*;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.embracesource.jpa.springdatajpa.domain.rolemenu.Menus;
import com.embracesource.jpa.springdatajpa.repository.rolemenu.MenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring/applicationContext*" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestMenusService {
	@Resource
	private MenusRepository menusRepository;
	
	@Test
	public void testSaveMenus() throws Exception {
		List<Menus> menus = new ArrayList<Menus>();
		
		Menus menu1 = new Menus();
		menu1.setMenuCode("m0001");
		menu1.setMenuName("城市查询");
		menus.add(menu1);
		
		Menus menu2 = new Menus();
		menu2.setMenuCode("m0002");
		menu2.setMenuName("省份查询");
		menus.add(menu2);
		
		Menus menu3 = new Menus();
		menu3.setMenuCode("m0003");
		menu3.setMenuName("教师查询");
		menus.add(menu3);
		
		Menus menu4 = new Menus();
		menu4.setMenuCode("m0004");
		menu4.setMenuName("学生查询");
		menus.add(menu4);
		
		menusRepository.save(menus);
	}
	
}
