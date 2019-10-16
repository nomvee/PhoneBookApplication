package com.PhoneBookApplication.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.Controller;

import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.exceptions.ContactNotFoundException;
import com.PhoneBookApplication.exceptions.IllegalContactException;
import com.PhoneBookApplication.service.PhoneBookService;

@RestController
public class PhoneBookController {

	@Autowired
	private PhoneBookService phoneBookService;

	@GetMapping(value = "/book")
	public ResponseEntity<PhoneBook> create() {

		final PhoneBook phoneBook = new PhoneBook();
		phoneBook.setName("Selby Book");

		final List<Entry> entries = new ArrayList<>();

		final Entry entry1 = new Entry();
		entry1.setName("vee");
		entry1.setPhoneNumber("081458974");

		entries.add(entry1);

		final Entry entry2 = new Entry();
		entry2.setName("lelo");
		entry2.setPhoneNumber("0615487654");
		entries.add(entry2);

		phoneBook.setEntries(entries);

		final PhoneBook createdPhoneBook = phoneBookService.save(phoneBook);

		return ResponseEntity.ok(phoneBookService.save(phoneBook));

	}

}
