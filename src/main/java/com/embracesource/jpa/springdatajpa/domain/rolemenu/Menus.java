package com.embracesource.jpa.springdatajpa.domain.rolemenu;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.embracesource.jpa.springdatajpa.domain.BaseEntity;

@Entity
@Table(name = "menus")
public class Menus extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String menuCode;

	@Column(length = 50)
	private String menuName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "menus")
	private List<RolesMenus> rolesMenus;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public List<RolesMenus> getRolesMenus() {
		return rolesMenus;
	}

	public void setRolesMenus(List<RolesMenus> rolesMenus) {
		this.rolesMenus = rolesMenus;
	}
	
}
