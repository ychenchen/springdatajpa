package com.embracesource.jpa.springdatajpa.repository.rolemenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.embracesource.jpa.springdatajpa.domain.rolemenu.RolesMenus;

@Repository
public interface RolesMenusRepository extends JpaRepository<RolesMenus, Long>, JpaSpecificationExecutor<RolesMenus>  {
	
}
