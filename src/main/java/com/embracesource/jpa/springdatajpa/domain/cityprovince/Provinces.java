package com.embracesource.jpa.springdatajpa.domain.cityprovince;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.embracesource.jpa.springdatajpa.domain.BaseEntity;

@Entity
@Table(name = "provinces")
public class Provinces extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "province_code",length = 50, unique=true)
	private String provinceCode;
	
	@Column(name = "province_name",length = 50,insertable=true,updatable=true)
	private String provinceName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "provinces")
	private List<Cities> cities;
	
	public Provinces() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public List<Cities> getCities() {
		return cities;
	}

	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}
	
}
