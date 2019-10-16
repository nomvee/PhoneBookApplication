package com.PhoneBookApplication.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.model.PhoneBookModel;

@Component
@Mapper(uses = { EntryMapper.class },componentModel = "spring")
public interface PhoneBookMapper extends EntityMapper<PhoneBook, PhoneBookModel> {

	@Mapping(source = "entryModels", target = "entries")
	Optional<PhoneBook> toDto(final Optional<PhoneBookModel> phoneBookModel);

	PhoneBookModel toEntity(final PhoneBook phoneBook);

	default PhoneBookModel fromId(final Long id) {

		if (id == null) {
			return null;
		}

		final PhoneBookModel phoneModel = new PhoneBookModel();
		phoneModel.setId(id);
		return phoneModel;
	}

}
