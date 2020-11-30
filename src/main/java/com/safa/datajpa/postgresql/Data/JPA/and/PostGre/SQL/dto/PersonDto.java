package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.dto;

import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.entity.Address;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class PersonDto {

    private Long id;
    private String name;
    private String lastName;
    private List<String> addresses;

}
