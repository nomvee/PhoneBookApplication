package com.PhoneBookApplication.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
 

@Data
public class PhoneBook implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private List<Entry> entries = new ArrayList<>();

}
