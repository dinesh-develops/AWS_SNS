package com.friendship.sns.AWS_SNS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = ContextStackAutoConfiguration.class)
public class AwsSnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSnsApplication.class, args);
	}

}
