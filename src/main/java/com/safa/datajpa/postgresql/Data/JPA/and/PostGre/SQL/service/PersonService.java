package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.service;

import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.dto.PersonDto;
import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    void delete(Long id);

    List<PersonDto> getAll();

    Page<Person> getAll(Pageable pageable);
}
