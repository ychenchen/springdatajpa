package com.embracesource.jpa.springdatajpa.repository.cityprovince;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.embracesource.jpa.springdatajpa.domain.cityprovince.Provinces;

@Repository
public interface ProvincesRepository  extends JpaRepository<Provinces, Long> {
	
	@Query("select count(id) from Provinces")
	public Long countCities();

	@Query("from Provinces p where p.provinceCode = ?1")
	public List<Provinces> getProvinceByProvinceCode(String provinceCode);
	
	@Modifying
	@Query("update Provinces p set p.provinceName = ?2 where p.provinceCode = ?1")
	public int updateProvinceByProvinceCode(String provinceCode, String provinceName);	//Modifying queries can only use void or int/Integer as return type!
	
	@Modifying
	@Query("delete from Provinces p where p.provinceCode = ?1")
	public int deleteProvinceByProvinceCode(String provinceCode);
	
}
