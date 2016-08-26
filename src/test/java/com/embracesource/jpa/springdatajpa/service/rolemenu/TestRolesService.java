package com.embracesource.jpa.springdatajpa.service.rolemenu;

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

import com.embracesource.jpa.springdatajpa.domain.rolemenu.Roles;
import com.embracesource.jpa.springdatajpa.domain.rolemenu.RolesMenus;
import com.embracesource.jpa.springdatajpa.repository.rolemenu.RolesRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring/applicationContext*" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestRolesService {
	@Resource
	private RolesRepository rolesRepository;
	
	@Test
	public void testSaveRoles() throws Exception {
		List<Roles> roles = new ArrayList<Roles>();
		
		Roles role1 = new Roles();
		role1.setRoleCode("r0001");
		role1.setRoleName("超级管理员");
		roles.add(role1);
		
		Roles role2 = new Roles();
		role2.setRoleCode("r0002");
		role2.setRoleName("普通管理员");
		roles.add(role2);
		
		Roles role3 = new Roles();
		role3.setRoleCode("r0003");
		role3.setRoleName("普通用户");
		roles.add(role3);
		
		rolesRepository.save(roles);
	}
	
	/**
	 * 查询角色拥有的菜单
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetMenusByRoleId() throws Exception {
		Roles role = rolesRepository.findOne(1l);
		List<RolesMenus> rolesMenus = role.getRolesMenus();
		
		for (RolesMenus rolesMenus1: rolesMenus) {
			System.out.println(rolesMenus1.getMenus().getMenuName());
		}
		
	}
}
