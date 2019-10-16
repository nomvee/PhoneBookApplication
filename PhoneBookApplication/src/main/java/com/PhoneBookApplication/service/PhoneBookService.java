package com.PhoneBookApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PhoneBookApplication.dao.EntryRepository;
import com.PhoneBookApplication.dao.PhoneBookRepository;
import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.mapper.EntryMapper;
import com.PhoneBookApplication.mapper.PhoneBookMapper;
import com.PhoneBookApplication.model.EntryModel;
import com.PhoneBookApplication.model.PhoneBookModel;

@Service
@Transactional
public class PhoneBookService {

	@Autowired
	private  PhoneBookRepository phoneBookRepository;
	@Autowired
	private  EntryRepository entryRepository;
	@Autowired
	private  EntryMapper entryMapper;
	@Autowired
	private  PhoneBookMapper phoneBookMapper;

	public List<PhoneBook> findAll() {

		final List<PhoneBookModel> phoneBookModels = phoneBookRepository.findAll();
		List<PhoneBook> phoneBooks = new ArrayList<>();

		phoneBookModels.forEach(phoneBook -> {

			final PhoneBook book = phoneBookMapper.toDto(phoneBook);

			phoneBooks.add(book);

		});

		return phoneBooks;
	}

	public PhoneBook save(PhoneBook phoneBook) {

		final PhoneBookModel phoneBookModel = phoneBookMapper.toEntity(phoneBook);
		final PhoneBookModel createdphoneBookModel = phoneBookRepository.save(phoneBookModel);

		final List<EntryModel> entries = new ArrayList<>();

		phoneBook.getEntries().forEach(entry -> {

			final EntryModel entryModel = entryMapper.toEntity(entry);
			entryModel.setPhoneBook(createdphoneBookModel);
			entries.add(entryModel);

		});
		createdphoneBookModel.setEntryModels(entries);
		entryRepository.saveAll(entries);

		return phoneBookMapper.toDto(createdphoneBookModel);
	}

	public Optional<PhoneBook> findById(Long id) {

		final Optional<PhoneBookModel> phoneBookModel = phoneBookRepository.findById(id);

		return phoneBookMapper.toDto(phoneBookModel);
	}

	public void deleteById(Long id) {
		phoneBookRepository.deleteById(id);

	}

}
