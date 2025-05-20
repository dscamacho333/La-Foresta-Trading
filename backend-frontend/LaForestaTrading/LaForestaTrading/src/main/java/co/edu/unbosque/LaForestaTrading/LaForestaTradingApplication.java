package co.edu.unbosque.LaForestaTrading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LaForestaTradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaForestaTradingApplication.class, args);
	}

}
