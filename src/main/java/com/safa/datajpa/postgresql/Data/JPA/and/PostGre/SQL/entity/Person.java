package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Person {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)  //for auto increment
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "person_address_id")
    private List<Address> addresses;    //It is a join
}
