package com.embracesource.jpa.springdatajpa.repository.rolemenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.embracesource.jpa.springdatajpa.domain.rolemenu.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>, JpaSpecificationExecutor<Roles>  {
	
}
