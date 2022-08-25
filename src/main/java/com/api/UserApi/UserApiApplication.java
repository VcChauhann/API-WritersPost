package com.api.UserApi;

import com.api.UserApi.Repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(UserApiApplication.class, args);

		UserRepo repo = context.getBean(UserRepo.class);
	}

}
