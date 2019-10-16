package com.PhoneBookApplication;

import org.springframework.boot.SpringApplication;

 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
 
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.PhoneBookApplication.common.entity.AuditorAwareImpl;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.PhoneBookApplication.mapper"})
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PhoneBookApplication {
	
	@Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

	public static void main(String[] args) {
		SpringApplication.run(PhoneBookApplication.class, args);
	}

}
