package io.agileintelligence.ppmtool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PpmtoolApplication {

	private static final Logger logger = LoggerFactory.getLogger(PpmtoolApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PpmtoolApplication.class, args);
		logger.info("{} application started.", PpmtoolApplication.class);
	}

}
