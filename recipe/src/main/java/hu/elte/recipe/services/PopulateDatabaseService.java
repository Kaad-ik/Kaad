package hu.elte.recipe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.repositories.UserRepository;

@Service
@Transactional
public class PopulateDatabaseService {
	
	@Autowired private UserRepository userRepository;
	
	public void populateDatabase() {
		savePlayer();
	}

	private void savePlayer() {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");
		user.setEmail("admin@admin.hu");
		user.setCurrency(Currency.HUF);
		user.setMoney(3000);
		user.setFullName("Admin Admin");
		user.setRole(Role.ADMIN);
		userRepository.save(user);
	}

}
