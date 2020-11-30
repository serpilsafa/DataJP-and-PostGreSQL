package com.safa.datajpa.postgresql.Data.JPA.and.PostGre.SQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DataJpaAndPostGreSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaAndPostGreSqlApplication.class, args);
	}

}
