package com.embracesource.jpa.springdatajpa.repository.teacherstudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.embracesource.jpa.springdatajpa.domain.teacherstudent.Teachers;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Long>, JpaSpecificationExecutor<Teachers>  {

}
