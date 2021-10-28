package com.te.springproject.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee implements Serializable {
	@Id
	private int id;
	private String username;
	private String password;
	private Date date;
}
