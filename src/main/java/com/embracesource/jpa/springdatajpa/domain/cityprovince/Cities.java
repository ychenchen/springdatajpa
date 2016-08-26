package com.embracesource.jpa.springdatajpa.domain.cityprovince;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NamedQuery;

import com.embracesource.jpa.springdatajpa.domain.BaseEntity;

@Entity
@Table(name = "cities")
@NamedQuery(name="Cities.findsByCityName", query="select c from Cities c where c.cityName=?1")	//NamedQuery
public class Cities extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "city_code",length = 50, unique=true)
	private String cityCode;
	
	@Column(name = "city_name",length = 50)
	private String cityName;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "province_id")
	@ForeignKey(name = "cities_provinces_fk")
	private Provinces provinces;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Provinces getProvinces() {
		return provinces;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}

}
