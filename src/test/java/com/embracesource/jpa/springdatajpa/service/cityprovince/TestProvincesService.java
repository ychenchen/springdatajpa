package com.embracesource.jpa.springdatajpa.service.cityprovince;

//import static org.junit.Assert.*;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.embracesource.jpa.springdatajpa.domain.cityprovince.Cities;
import com.embracesource.jpa.springdatajpa.domain.cityprovince.Provinces;
import com.embracesource.jpa.springdatajpa.repository.cityprovince.ProvincesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring/applicationContext*" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestProvincesService {
	@Resource
	private ProvincesRepository provincesRepository;
	
	/**
	 * 保存省份并同时保存对应的多个城市
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveProvinces() throws Exception {
		Provinces province = new Provinces();
		province.setProvinceCode("370000");
		province.setProvinceName("山东省");
		
		List<Cities> cities= new ArrayList<Cities>();
		Cities city1 = new Cities();
		city1.setCityCode("371000");
		city1.setCityName("威海市");
		city1.setProvinces(province);
		cities.add(city1);
		
		Cities city2 = new Cities();
		city2.setCityCode("370600");
		city2.setCityName("烟台市");
		city2.setProvinces(province);
		cities.add(city2);

		Cities city3 = new Cities();
		city3.setCityCode("370100");
		city3.setCityName("济南市");
		city3.setProvinces(province);
		cities.add(city3);

		Cities city4 = new Cities();
		city4.setCityCode("370200");
		city4.setCityName("青岛市");
		city4.setProvinces(province);
		cities.add(city4);

		Cities city5 = new Cities();
		city5.setCityCode("370300");
		city5.setCityName("淄博市");
		city5.setProvinces(province);
		cities.add(city5);

		Cities city6 = new Cities();
		city6.setCityCode("370400");
		city6.setCityName("枣庄市");
		city6.setProvinces(province);
		cities.add(city6);
		
		province.setCities(cities);
		
		provincesRepository.save(province);
	}
	
	/**
	 * 根据省份信息查询，包括查询对应的城市信息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetProvinces() throws Exception {
		String provinceCode = "370000";
		List<Provinces> provinces = provincesRepository.getProvinceByProvinceCode(provinceCode);
		
		for (Provinces province : provinces) {
			System.out.println("省份名称：" + province.getProvinceName());
			System.out.println("该省共有：" + province.getCities().size() + "个城市");
			List<Cities> cities = province.getCities();
			System.out.println("这些城市的名称是：");
			for (Cities city : cities) {
				System.out.println(city.getCityName());
			}
		}
		System.err.println("**************我是省份的分界线**************");
	}
	
	@Test
	public void testUpdateProvince() throws Exception {
		String provinceCode = "110000";
		String provinceName = "中国北京";
		provincesRepository.updateProvinceByProvinceCode(provinceCode, provinceName );
	}
	
	/**
	 * 级联删除，会因为外键关联而导致无法删除成功
	 * 生产时也不建议强制级联删除，因为它删除的不仅仅是关联关系，还包括整个对象
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteProvince() throws Exception {
		String provinceCode = "110000";
		provincesRepository.deleteProvinceByProvinceCode(provinceCode);
	}
	
}
