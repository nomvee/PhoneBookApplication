package com.PhoneBookApplication;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
 

import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.service.PhoneBookService;

import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
public class PhoneBookApplicationTests {

	@Autowired
	private PhoneBookService phoneBookService;

	@Test
	public void savePhoneBook() {

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

		final List<Entry> createdentries = createdPhoneBook.getEntries();
		assertThat(createdentries).hasSize(2);
		createdentries.forEach(entry -> assertThat(entry.getPhoneBookId()).isEqualTo(createdPhoneBook.getId()));
	}
}
