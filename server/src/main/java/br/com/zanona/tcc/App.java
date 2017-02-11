package br.com.zanona.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages = { "br.com.zanona.tcc.server.domain" })
@EnableJpaRepositories(basePackages = { "br.com.zanona.tcc.server.persistence" })
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
