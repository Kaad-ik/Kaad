package hu.elte.recipe.entities.httpentities.transformers;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;

import org.springframework.stereotype.Component;

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
