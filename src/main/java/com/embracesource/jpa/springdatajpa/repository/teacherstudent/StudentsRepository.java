package com.embracesource.jpa.springdatajpa.repository.teacherstudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.embracesource.jpa.springdatajpa.domain.teacherstudent.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long>, JpaSpecificationExecutor<Students>  {

}
