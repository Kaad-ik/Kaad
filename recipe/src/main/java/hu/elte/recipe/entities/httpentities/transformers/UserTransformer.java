package hu.elte.recipe.entities.httpentities.transformers;

import org.springframework.stereotype.Component;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;

@Component
public class UserTransformer {
	
	public UserHttpEntity transformUserToUserHttpEntity(User user) {
		UserHttpEntity userHttpEntity = new UserHttpEntity();
		userHttpEntity.setId(user.getId());
		userHttpEntity.setUserName(user.getUserName());
		userHttpEntity.setEmail(user.getEmail());
		userHttpEntity.setFullName(user.getFullName());
		userHttpEntity.setCurrency(user.getCurrency());
		userHttpEntity.setMoney(user.getMoney());
		userHttpEntity.setRole(user.getRole());
		return userHttpEntity;
	}
}
