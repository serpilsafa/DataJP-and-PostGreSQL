package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)  //for auto increment
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "person_address_id")
    private Person person;

    public enum AddressType{
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }
}
