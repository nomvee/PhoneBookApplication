package com.PhoneBookApplication.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PhoneBookApplication.dao.EntryRepository;
import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.model.EntryModel;

@Service
@Transactional
@RequiredArgsConstructor
public class EntryService {

//	 private final EntryRepository entryRepository;
//
//	@Override
//	public List<Entry> findAll() {
//
//		return entryRepository.findAll();
//	}
//
//	@Override
//	public Entry save(EntryModel entity) {
//
//		return entryRepository.save(entity);
//	}
//
//	@Override
//	public  Optional<Entry> findById(Long id) {
//
//		return entryRepository.findById(id);
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		entryRepository.deleteById(id);
//
//	}

}
