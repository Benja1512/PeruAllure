package com.peruallure.peruallure;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.peruallure.peruallure.tienda.model") // 🔥 Escanea las entidades
@EnableJpaRepositories(basePackages = "com.peruallure.peruallure.tienda.repository") // 🔥 Escanea los repositorios
@ComponentScan(basePackages = "com.peruallure.peruallure.tienda") // 🔥 Escanea los servicios y controladores
public class PeruAllureApplication {
	public static void main(String[] args) {
		SpringApplication.run(PeruAllureApplication.class, args);
	}
}
