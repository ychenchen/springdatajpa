package com.embracesource.jpa.springdatajpa.service.cityprovince;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.embracesource.jpa.springdatajpa.domain.cityprovince.Cities;
import com.embracesource.jpa.springdatajpa.domain.cityprovince.Provinces;
import com.embracesource.jpa.springdatajpa.repository.cityprovince.CitiesRepository;
import com.embracesource.jpa.springdatajpa.repository.cityprovince.ProvincesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring/applicationContext*" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestCitiesService {
	@Resource
	private CitiesRepository citiesRepository;
	
	@Resource
	private ProvincesRepository provincesRepository;
	
	/**
	 * 保存城市并保存对应的省份
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveCities1() throws Exception {
		Cities city = new Cities();
		city.setCityCode("370100");
		city.setCityName("济南");
		Provinces provinces = new Provinces();
		provinces.setProvinceCode("370000");
		provinces.setProvinceName("山东");
		city.setProvinces(provinces);
		citiesRepository.save(city);
	}
	
	/**
	 * 单独保存城市不保存对应的省份
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveCitiesWithoutProvinces() throws Exception {
		Cities city = new Cities();
		city.setCityCode("370700");
		city.setCityName("潍坊市");
		citiesRepository.save(city);
	}
	
	/**
	 * 保存完城市后再更新该城市对应的省份
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveCityProvince() throws Exception {
		String cityCode = "370700";
		Provinces province = provincesRepository.findOne(1l);
		citiesRepository.updateCityProvince(cityCode, province);
	}
	
	/**
	 * 保存城市并保存省份为已经存在的省份
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveCities() throws Exception {
		Cities city = new Cities();
		city.setCityCode("370800");
		city.setCityName("济宁市");
		Provinces province = provincesRepository.findOne(1l);
		city.setProvinces(province);
		citiesRepository.save(city);
	}
	
	/**
	 * 数数数据库中一共有多少个城市
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetCitiesCount() throws Exception {
		Long citiesCount = citiesRepository.getCitiesCount();
		System.out.println(citiesCount);
		
		Long citiesCount1 = citiesRepository.count();
		System.out.println(citiesCount1);
		
	}
	
	/**
	 * 删除
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteCityByCityCode() throws Exception {
		String cityCode = "370400";
		citiesRepository.deleteCityByCityCode(cityCode);
	}
	
	/**
	 * 分页+排序
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception {
		PageRequest pageable = new PageRequest(0, 3, new Sort(Direction.valueOf("ASC"), "cityCode"));
		Page<Cities> pages = citiesRepository.findAll(pageable);
		if(pages!=null){
			List<Cities> cities = pages.getContent();
			for (Cities city : cities) {
				System.out.println(city.getCityCode() + ":" + city.getCityName());
			}
		}
		System.err.println("********分割线*********");
		Page<Cities> pages1 = citiesRepository.findAllCities(pageable);
		if(pages1!=null){
			List<Cities> cities = pages1.getContent();
			for (Cities city : cities) {
				System.out.println(city.getCityCode() + ":" + city.getCityName());
			}
		}
	}
	
	/**
	 * 解析方法名称以自动生成查询
	 * find read get count
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindByCityCode() throws Exception {
		String cityCode = "371000";
		Cities city = citiesRepository.findByCityCode(cityCode);
		System.out.println(city.getCityName());
	}
	
	/**
	 * namedQuery
	 * find read get count
	 * 
	 * @throws Exception
	 */
	@Test
	public void findsByCityName() throws Exception {
		String cityName = "威海市";
		Cities city = citiesRepository.findsByCityName(cityName);	//为了区分解析方法名称以自动生成查询，故意将方法名称以finds开头
		System.out.println(city.getCityName());
	}
	
	/**
	 * @ Query 指定查询
	 * 
	 * @throws Exception
	 */
	@Test
	public void getCityByCityCodeAndName() throws Exception {
		String cityCode = "371000";
		String cityName = "威海市";
		Cities city = citiesRepository.getCityByCityCodeAndName(cityCode, cityName);
		System.out.println(city.getProvinces().getProvinceName());
	}
	
	/**
	 * in查询
	 * 
	 * @throws Exception
	 */
	@Test
	public void getCityByCityCodeAndNameIn() throws Exception {
		List<String> cityCodes = new ArrayList<String>();
		cityCodes.add("371000");
		cityCodes.add("370600");
		cityCodes.add("370200");
		List<Cities> cities = citiesRepository.getCityByCityCodeAndName(cityCodes);
		for (Cities city : cities) {
			System.out.println(city.getProvinces().getProvinceName() + city.getCityName());
		}
	}
	
	/**
	 * 命名化参数
	 * 
	 * @throws Exception
	 */
	@Test
	public void getCityByCityCodeAndCityName() throws Exception {
		String cityCode = "371000";
		String cityName = "威海市";
		Cities city = citiesRepository.getCityByCityCodeAndCityName(cityCode, cityName);
		System.out.println(city.getProvinces().getProvinceName());
	}

	/**
	 * 更新查询
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateCityByCityCode() throws Exception {
		String cityCode = "371000";
		String cityName = "威海市";
		citiesRepository.updateCityByCityCode(cityCode, cityName);
	}
	
	/**
	 * Specifications查询
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSpecications() throws Exception {
		Specification<Cities> specification = new Specification<Cities>() {
			public Predicate toPredicate(Root<Cities> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				String searchCriteria = "市";
				if (StringUtils.isNotEmpty(searchCriteria)) {
					Path<String> namePath = root.get("cityName");
					predicates.add(cb.like(namePath, "%"+searchCriteria + "%"));
				}
				Predicate pp = null;Predicate p1 = null;Predicate p2 = null;
				p1 = cb.equal(root.get("cityCode"), "371000");
				p2 = cb.equal(root.get("cityCode"), "370600");
				pp = cb.or(p1, p2);
				if(pp!=null){
					predicates.add(pp);
				}
				//多表连接
				Predicate p3 = null;
				p3 = cb.equal(root.join("provinces").get("provinceCode"), "370000");
				if (p3!=null) {
					predicates.add(p3);
				}
				predicates.add(cb.equal(root.<Long> get("provinces"),1));
				query.where(predicates.toArray(new Predicate[] {}));
				//添加排序（如果用分页，下面这句话需要注释掉）
				query.orderBy(cb.desc(root.get("cityCode").as(String.class)));
				return null;
			}
		};
		
		List<Cities> cities = citiesRepository.findAll(specification);
		for (Cities city : cities) {
			System.out.println("城市编码：" + city.getCityCode() + " 城市名称：" + city.getCityName());
		}
		System.err.println("**************分割线，下面是分页查询的结果**************");
		//添加分页,pageable对象里面有排序，所以在specification里面不应该再指定排序
		PageRequest pageable = new PageRequest(0, 3, new Sort(Direction.valueOf("ASC"), "cityCode"));
		Page<Cities> pageableCities = citiesRepository.findAll(specification, pageable);
		List<Cities> citiesp = pageableCities.getContent();
		for (Cities city : citiesp) {
			System.out.println("城市编码：" + city.getCityCode() + " 城市名称：" + city.getCityName());
		}
	}
	
}
