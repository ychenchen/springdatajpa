package com.embracesource.jpa.springdatajpa.repository.rolemenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.embracesource.jpa.springdatajpa.domain.rolemenu.Menus;

@Repository
public interface MenusRepository extends JpaRepository<Menus, Long>, JpaSpecificationExecutor<Menus>  {
	
}
