package com.example.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
	@Id
	@Column(precision=2)
	private BigInteger deptno;
	@Column(length=14, nullable=false)
	private String dname;
	@Column(length=13)
	private String loc;
}
