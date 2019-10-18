package com.PhoneBookApplication.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String phoneNumber;
	private Long phoneBookId;

	

}
