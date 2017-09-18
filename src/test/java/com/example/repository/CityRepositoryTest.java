package com.example.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class CityRepositoryTest {

	@Inject
	CityRepository cityrepository;
	
	@Test
	public void findAll() {
		cityrepository.findAll().forEach(e ->{
			System.out.println(e);
		});
		
		System.out.println("count = " + cityrepository.count());
		
		City city = new City();
		city.setCountrycode("KOR");
		Example<City> example = Example.of(city);
		
		cityrepository.findAll(example).forEach(e -> {
			System.out.println(e);
		});
	}

}
