package com.PhoneBookApplication.common.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.PhoneBookApplication.service.PhoneBookService;
import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.dto.PhoneBook;

@Component
public class DataLoader implements CommandLineRunner{
	
	@Autowired
	private PhoneBookService phoneBookService;

	@Override
	public void run(String... args) throws Exception {
		 
		
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

		phoneBook.setDtoEntries(entries);

		final PhoneBook createdPhoneBook = phoneBookService.save(phoneBook);
		System.out.println(createdPhoneBook.getName());
		
	}

}
