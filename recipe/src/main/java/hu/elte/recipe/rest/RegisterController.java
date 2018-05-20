package hu.elte.recipe.rest;

import hu.elte.recipe.entities.User;
import hu.elte.recipe.entities.httpentities.UserHttpEntity;
import hu.elte.recipe.exceptions.DuplicationException;
import hu.elte.recipe.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * The Class RegisterController.
 */
@RestController
public class RegisterController {

  /** The user service. */
  @Autowired private UserService userService;

  /**
   * Show login page.
   *
   * @return the model and view
   */
  @RequestMapping(value = "register.html", method = RequestMethod.GET)
  public ModelAndView showLoginPage() {
    return new ModelAndView("register");
  }

  /**
   * Login.
   *
   * @param user the user
   * @param result the result
   * @param redirectAttributes the redirect attributes
   * @return the model and view
   */
  @RequestMapping(value = "register", method = RequestMethod.POST)
  public ModelAndView login(@ModelAttribute("user") UserHttpEntity user,
      BindingResult result, RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return new ModelAndView("jajj");
    }
    try {
      User u = userService.register(user);
      if (u != null) {
        redirectAttributes.addFlashAttribute("message", "Congratulations!\nSuccessful registration.");
      }
      return new ModelAndView("redirect:/");
    } catch (DuplicationException u) {
      redirectAttributes.addFlashAttribute("message", "Registration failed.\nTry again!");
      return new ModelAndView("redirect:/");
    }
  }
}
