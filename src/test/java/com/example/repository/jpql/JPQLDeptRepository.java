package com.example.repository.jpql;

import static org.junit.Assert.*;

import java.math.BigInteger;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.repository.DeptRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class JPQLDeptRepository {

	@Inject
	DeptRepository repo;
	@Test
	public void test() {
		System.out.println(repo.getClass());
	}
	
	@Test
	public void insertRow() {
		Dept d50 = new Dept(new BigInteger("50"), "test", "test"); 
		
		repo.save(d50);
		
		System.out.println(repo.findOne(new BigInteger("50")));
	}
	
	@Test
	public void findOne() {
		Dept dept1 = repo.findOne(new BigInteger("20"));
		System.out.println("findOne(20) = " + dept1);
		
		Dept probe = new Dept();
//		probe.setDeptno(new BigInteger("20"));
		probe.setDname("인사부");
		
		Example<Dept> example = Example.of(probe);
		
		Dept dept2 = repo.findOne(example);
		System.out.println("findOne(20) = " + dept2); 
	}
	
	@Test
	public void findByLoc() {
		Dept dept = repo.findByLoc("서울");
		System.out.println(dept);
	}
	
	@Test
	public void selectDept() {
		repo.findAll().forEach(e -> {
			System.out.println(e);
		});
		repo.selectDept("인사부", "서울").forEach(e -> {
			System.out.println(e);
		});
		repo.selectDept2("인사부", "서울").forEach(e -> {
			System.out.println(e);
		});
	}
	
	@Test
	public void selectDnameLoc() {
		repo.findAll().forEach(e -> {
			System.out.println(e); //e -> Dept
		});
		repo.selectDnameLoc().forEach(e -> {
			System.out.println(e[0] + ", " + e[1]); //e -> Object[]
		});
	}

}
