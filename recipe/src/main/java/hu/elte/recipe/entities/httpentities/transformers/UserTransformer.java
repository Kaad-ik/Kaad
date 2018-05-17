package hu.elte.recipe.entities.httpentities.transformers;

import org.springframework.stereotype.Component;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class UserTransformer.
 */
@Component
public class UserTransformer {
	
	/**
	 * Transform user to user http entity.
	 *
	 * @param user the user
	 * @return the user http entity
	 */
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
