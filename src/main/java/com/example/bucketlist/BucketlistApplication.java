package com.example.bucketlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.bucketlist.domain.Task;
import com.example.bucketlist.domain.TaskRepository;
import com.example.bucketlist.domain.Category;
import com.example.bucketlist.domain.CategoryRepository;
import com.example.bucketlist.domain.User;
import com.example.bucketlist.domain.UserRepository;

@SpringBootApplication
public class BucketlistApplication {
	private static final Logger log = LoggerFactory.getLogger(BucketlistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BucketlistApplication.class, args);
	}

	@Bean
	public CommandLineRunner taskDemo(TaskRepository trepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of categories");
			crepository.save(new Category("Travel"));
			crepository.save(new Category("Relationships"));
			crepository.save(new Category("Career"));
			crepository.save(new Category("Entertainment"));
			crepository.save(new Category("Financial"));
			crepository.save(new Category("Adventure"));
			crepository.save(new Category("Education"));
			crepository.save(new Category("Health"));
			crepository.save(new Category("Creativity"));
			crepository.save(new Category("Other"));
			
			// testi
			// trepository.save(new Task("Benji hyppy", "Kanada", "Heinäkuu 2023", crepository.findByName("Travel").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			

			log.info("fetch all tasks");
			for (Task task : trepository.findAll()) {
				log.info(task.toString());
				
			}

		};
	
}
}
