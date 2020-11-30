package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.controller;

import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.dto.PersonDto;
import com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public  ResponseEntity<List<PersonDto>> getAllPeople(){
        return ResponseEntity.ok(personService.getAll());
    }

}
