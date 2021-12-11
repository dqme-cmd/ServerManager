package com.cpatt.server;

import com.cpatt.server.enumeration.Status;
import com.cpatt.server.model.Server;
import com.cpatt.server.repo.ServerRepo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "com.cpatt")
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


@Bean
	CommandLineRunner run(ServerRepo serverRepo) {
		return args -> {
		serverRepo.save(new Server
				(
						null,
						"66.222.220.70",
						"Ubuntu Linux",
						"16 GB",
						"Personal PC",
						"https://localhost:8080/Desktop/ServerManagerIcons/server.png", Status.SERVER_UP));

		serverRepo.save(new Server
					(
							null,
							"192.168.1.63",
							"Fedora Linux",
							"8 GB",
							"Work PC",
							"https://localhost:8080/Desktop/ServerManagerIcons/server1.png", Status.SERVER_UP));

		serverRepo.save(new Server
					(
							null,
							"192.168.1.88",
							"Windows 11",
							"32 GB",
							"Dell Tower",
							"https://localhost:8080/Desktop/ServerManagerIcons/server2.png", Status.SERVER_UP));

		serverRepo.save(new Server
					(
							null,
							"192.168.1.91",
							"Mac OS",
							"128 GB",
							"Web Server",
							"https://localhost:8080/Desktop/ServerManagerIcons/server3.png", Status.SERVER_UP));
		};
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost4200", "http://localhost8080", "http://localhost:3306"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Taken", "Authorization", "Origin, Accept", "X-Request-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-token",
				"Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
