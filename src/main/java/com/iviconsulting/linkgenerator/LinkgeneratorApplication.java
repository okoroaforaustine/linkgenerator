package com.iviconsulting.linkgenerator;

import com.iviconsulting.linkgenerator.repository.InvoiceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class LinkgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkgeneratorApplication.class, args);
	}


}
