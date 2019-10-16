package com.PhoneBookApplication.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

	List<T> findAll();

	T save(T entity);

	 Optional<T> findById(Long id);

	void deleteById(Long id);

 
}