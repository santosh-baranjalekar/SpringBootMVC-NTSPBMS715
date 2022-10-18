package com.nt.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "BOOT_EMP")
@Data
@SQLDelete(sql = "UPDATE BOOT_EMP SET STATUS='INACTIVE' WHERE ENO=?")
@Where(clause = "STATUS <> 'INACTIVE'")
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "EMP_SPRING_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer eno;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno;
	private String status = "ACTIVE";
}