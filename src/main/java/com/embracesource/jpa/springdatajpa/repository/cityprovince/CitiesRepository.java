package com.embracesource.jpa.springdatajpa.repository.cityprovince;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.embracesource.jpa.springdatajpa.domain.cityprovince.Cities;
import com.embracesource.jpa.springdatajpa.domain.cityprovince.Provinces;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Long>, JpaSpecificationExecutor<Cities>  {
	
	@Query("select count(id) from Cities")
	public Long getCitiesCount();
	
	@Modifying
	@Query("delete from Cities c where c.cityCode = ?1")
	public int deleteCityByCityCode(String cityCode);
	
	@Query(value = "select c from Cities c")
	public Page<Cities> findAllCities(Pageable page);
	
	@Query("from Cities c where c.cityCode= ?1 and c.cityName = ?2")
	public Cities getCityByCityCodeAndName(String cityCode, String cityName);
	
	@Query("from Cities c where c.cityCode in (:cityCode)")
	public List<Cities> getCityByCityCodeAndName(@Param("cityCode") List<String> cityCode);
	
	@Query("from Cities c where c.cityCode= :cityCodes and c.cityName = :cityName")
	public Cities getCityByCityCodeAndCityName(@Param("cityCodes") String cityCode, @Param("cityName") String cityName);
	
	@Modifying
	@Query("update Cities c set c.cityName = ?2 where c.cityCode = ?1")
	public int updateCityByCityCode(String cityCode, String cityName);

	public Cities findByCityCode(String cityCode);	//解析方法名称自动生成查询，不用加注解
	
	public Cities findsByCityName(String cityName);	//NamedQueries,需要先在实体类上添加该注解
	
	@Modifying
	@Query("update Cities c set c.provinces = ?2 where c.cityCode = ?1")
	public void updateCityProvince(String cityCode, Provinces province);

}
