package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.service.impl;


import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.dto.PersonDto;
import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.entity.Address;
import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.entity.Person;
import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.repository.AddressRepository;
import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.repository.PersonRepository;
import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional      // it applies the below code in the db or not apply
    public PersonDto save(PersonDto personDto) {
       // Assert.isNull(personDto.getName(), "Name must have input");
        Person person = new Person();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        final Person personDB = person = personRepository.save(person);

        List<Address> list = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setPerson(personDB);
            list.add(address);
        });
        addressRepository.saveAll(list);
        personDto.setId(personDB.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        personList.forEach(it -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setLastName(it.getLastName());
            personDto.setAddresses(it.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList()));
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return null;
    }
}
