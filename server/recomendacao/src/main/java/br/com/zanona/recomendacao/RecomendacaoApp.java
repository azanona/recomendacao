package br.com.zanona.recomendacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RecomendacaoApp {

	public static void main(String[] args) {
		SpringApplication.run(RecomendacaoApp.class, args);
	}
}
