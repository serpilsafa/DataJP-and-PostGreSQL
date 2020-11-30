package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.repository;

import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
