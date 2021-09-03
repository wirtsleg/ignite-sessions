package com.github.wirtsleg.ignitesessions;

import org.apache.ignite.springdata22.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.github.wirtsleg.ignitesessions.repository.jdbc")
@EnableIgniteRepositories(basePackages = "com.github.wirtsleg.ignitesessions.repository.ignite")
public class IgniteSessionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgniteSessionsApplication.class, args);
	}
}
