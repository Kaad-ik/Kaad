package hu.elte.recipe.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserUpdateController {

	
	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public String updateUser() {
		
		System.out.println("update user");
		return "redirect:user/details.html";
	}
}
