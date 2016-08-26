package com.embracesource.jpa.springdatajpa.domain.rolemenu;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.embracesource.jpa.springdatajpa.domain.BaseEntity;

@Entity
@Table(name = "roles_menus")
public class RolesMenus extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	@ForeignKey(name = "roles_menus_role_id_fkey")
	private Roles roles;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "menu_id")
	@ForeignKey(name = "roles_menus_menu_id_fkey")
	private Menus menus;

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Menus getMenus() {
		return menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

}
