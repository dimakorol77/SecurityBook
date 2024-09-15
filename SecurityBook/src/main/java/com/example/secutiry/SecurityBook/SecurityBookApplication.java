package com.example.secutiry.SecurityBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.boot.CommandLineRunner;
import com.example.secutiry.SecurityBook.enums.AppRole;
import com.example.secutiry.SecurityBook.model.AppUser;
import com.example.secutiry.SecurityBook.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityBookApplication implements CommandLineRunner {

	@Autowired
	private AppUserRepository appUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityBookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createUserIfNotExists("admin@admin.admin", AppRole.ADMIN);
		createUserIfNotExists("user@user.user", AppRole.USER);
	}

	private void createUserIfNotExists(String email, AppRole role) {
		if (appUserRepository.findByEmail(email).isEmpty()) {
			AppUser user = new AppUser();
			user.setEmail(email);
			user.setPassword(new BCryptPasswordEncoder().encode("pass"));
			user.setRole(role);
			appUserRepository.save(user);
		}
	}
}
