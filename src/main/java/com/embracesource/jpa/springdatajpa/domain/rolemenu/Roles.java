package com.embracesource.jpa.springdatajpa.domain.rolemenu;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.embracesource.jpa.springdatajpa.domain.BaseEntity;

@Entity
@Table(name = "roles", uniqueConstraints = { @UniqueConstraint(name = "roles_unique_code", columnNames = { "roleCode" }),
		@UniqueConstraint(name = "roles_unique_name", columnNames = { "roleCode" }) })
public class Roles extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String roleCode;

	@Column(length = 50)
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
	private List<RolesMenus> rolesMenus;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public List<RolesMenus> getRolesMenus() {
		return rolesMenus;
	}

	public void setRolesMenus(List<RolesMenus> rolesMenus) {
		this.rolesMenus = rolesMenus;
	}
	
}
