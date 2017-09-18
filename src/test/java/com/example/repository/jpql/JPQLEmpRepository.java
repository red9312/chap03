package com.example.repository.jpql;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.repository.EmpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class JPQLEmpRepository {

	@Inject
	EmpRepository repo;
	
	@Test
	public void test() {
		System.out.println(repo.getClass());
	}
	
	@Test
	@Transactional			// 여기에 있는 쿼리는 하나의 트랜젝션안에 들어간다.
	public void findAll() {
		repo.findAll().forEach(e -> {
			System.out.println(e.getEmpno() + ", " + e.getEname() + ", " + e.getDept());
		});
	}
	
	@Test
	@Transactional
	public void selectEmpByDeptno() {
		repo.selectEmpByDeptno(new BigInteger("10")).forEach( e -> {
			System.out.println(e + ", " + e.getDept());
		});
	}
	
	@Test
	@Transactional
	public void selectEmpByDeptno2() {
		repo.selectEmpByDeptno(new BigInteger("10")).forEach( e -> {
			System.out.println(e + ", " + e.getDept());
		});
	}
	
	@Test
	@Transactional
	public void stat() {
//		Object[] result = repo.stat();
//		System.out.println(Arrays.toString(result));
		repo.stat().forEach(e -> {
			System.out.println(Arrays.toString(e));
		});
	}
	
	@Test
	@Transactional
	public void stat2() {
		repo.stat2().forEach(e -> {
//			System.out.println("avg = " + e.get("avg") + ", min = " + e.get("min"));
			System.out.println(e);
		});
	}

}
