package br.com.boletos.aplicacao;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.boletos.util.CustomJacksonObjectMapper;


@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = "br.com.boletos")
@EnableJpaRepositories(basePackages = "br.com.boletos")
@EntityScan(basePackages = "br.com.boletos")
public class Application {
	
	@Bean
	ObjectMapper jacksonObjectMapper() {
		return new CustomJacksonObjectMapper();
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.local")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//ClienteRepositorio repositorio = ctx.getBean(ClienteRepositorio.class);
	}
}
