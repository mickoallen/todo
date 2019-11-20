package com.mo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@EnableAutoConfiguration
@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		Properties properties = new Properties();
		SpringApplication app =
				new SpringApplication(TodoApplication.class);
		properties.setProperty("spring.resources.static-locations",
				"file:/app/my-app/");
		app.setDefaultProperties(properties);
		app.run(args);
	}

	/**
	 * this isnt ideal but helps for local testing - lookup webpack dev server proxy instead!
	 */
	@Configuration
	public class Config implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("*");
		}
	}

}
