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
import com.embracesource.jpa.springdatajpa.domain.rolemenu.Roles;
import com.embracesource.jpa.springdatajpa.domain.rolemenu.RolesMenus;
import com.embracesource.jpa.springdatajpa.repository.rolemenu.MenusRepository;
import com.embracesource.jpa.springdatajpa.repository.rolemenu.RolesMenusRepository;
import com.embracesource.jpa.springdatajpa.repository.rolemenu.RolesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring/applicationContext*" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestRolesMenusService {
	@Resource
	private RolesMenusRepository rolesMenusRepository;
	
	@Resource
	private RolesRepository rolesRepository;
	
	@Resource
	private MenusRepository menusRepository;
	
	/**
	 * 添加角色和用户的关联关系
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveRolesMenus() throws Exception {
		List<RolesMenus> rolesMenus = new ArrayList<RolesMenus>();
		
		Roles role1 = rolesRepository.findOne(1l);
		Menus menu1 = menusRepository.findOne(1l);
		Menus menu2 = menusRepository.findOne(2l);
		Menus menu3 = menusRepository.findOne(3l);
		
		RolesMenus rolesMenus1 = new RolesMenus();
		rolesMenus1.setRoles(role1);
		rolesMenus1.setMenus(menu1);
		rolesMenus.add(rolesMenus1);
		
		RolesMenus rolesMenus2 = new RolesMenus();
		rolesMenus2.setRoles(role1);
		rolesMenus2.setMenus(menu2);
		rolesMenus.add(rolesMenus2);
		
		RolesMenus rolesMenus3 = new RolesMenus();
		rolesMenus3.setRoles(role1);
		rolesMenus3.setMenus(menu3);
		rolesMenus.add(rolesMenus3);
		
		rolesMenusRepository.save(rolesMenus);
	}
	
	
	
}
