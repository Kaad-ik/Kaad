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

		User user1 = new User();
		user1.setUserName("Harriet");
		user1.setPassword("asdfgh");
		user1.setEmail("harri@recipe.hu");
		user1.setCurrency(Currency.USD);
		user1.setMoney(200);
		user1.setFullName("Harriet Sanders");
		user1.setRole(Role.USER);
		userRepository.save(user1);

		User user2 = new User();
		user2.setUserName("Louis");
		user2.setPassword("lulu1234");
		user2.setEmail("lulu@recipe.hu");
		user2.setCurrency(Currency.EUR);
		user2.setMoney(450);
		user2.setFullName("Louis Miller");
		user2.setRole(Role.USER);
		userRepository.save(user2);

		User user3 = new User();
		user3.setUserName("Réka");
		user3.setPassword("recipeApp01");
		user3.setEmail("r200@recipe.hu");
		user3.setCurrency(Currency.HUF);
		user3.setMoney(8000);
		user3.setFullName("Horváth Réka");
		user3.setRole(Role.USER);
		userRepository.save(user3);

		User user4 = new User();
		user4.setUserName("Keitha");
		user4.setPassword("safepsw");
		user4.setEmail("keitha@recipe.hu");
		user4.setCurrency(Currency.HUF);
		user4.setMoney(4500);
		user4.setFullName("Keitha Garcia");
		user4.setRole(Role.USER);
		userRepository.save(user4);

		User user5 = new User();
		user5.setUserName("Nicola");
		user5.setPassword("nic1990");
		user5.setEmail("nic@recipe.hu");
		user5.setCurrency(Currency.USD);
		user5.setMoney(1000);
		user5.setFullName("Nicola Bailey");
		user5.setRole(Role.USER);
		userRepository.save(user5);

		User user6 = new User();
		user6.setUserName("Derek");
		user6.setPassword("dboyasd");
		user6.setEmail("derek@recipe.hu");
		user6.setCurrency(Currency.USD);
		user6.setMoney(300);
		user6.setFullName("Derek Matthews");
		user6.setRole(Role.USER);
		userRepository.save(user6);

		User user7 = new User();
		user7.setUserName("Jamesina");
		user7.setPassword("idkpsw");
		user7.setEmail("jami@recipe.hu");
		user7.setCurrency(Currency.EUR);
		user7.setMoney(150);
		user7.setFullName("Jamesina Blaese");
		user7.setRole(Role.GUEST);
		userRepository.save(user7);

		User user8 = new User();
		user8.setUserName("Tammy");
		user8.setPassword("ymmat");
		user8.setEmail("tammy@recipe.hu");
		user8.setCurrency(Currency.EUR);
		user8.setMoney(70);
		user8.setFullName("Tammy Watson");
		user8.setRole(Role.GUEST);
		userRepository.save(user8);

		User user9 = new User();
		user9.setUserName("Nick");
		user9.setPassword("nickname");
		user9.setEmail("nick@recipe.hu");
		user9.setCurrency(Currency.EUR);
		user9.setMoney(70);
		user9.setFullName("Nick Anderson");
		user9.setRole(Role.GUEST);
		userRepository.save(user9);
	}

}
