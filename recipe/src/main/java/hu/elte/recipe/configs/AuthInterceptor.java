package hu.elte.recipe.configs;

import hu.elte.recipe.annotations.BusinessRole;
import hu.elte.recipe.entities.Role;
import hu.elte.recipe.entities.User;
import hu.elte.recipe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doma on 2017.10.31..
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if(!(handler instanceof HandlerMethod)){
                return true; }
            List<Role> routeRoles = getRoles((HandlerMethod) handler);
            User user = userService.getActualUser();

            if (routeRoles.isEmpty() || routeRoles.contains(Role.GUEST)) {
                return true;
            }

            if (userService.isLoggedIn() && routeRoles.contains(user.getRole())) {
                return true;
            }
        response.setStatus(401);
        return false;
    }

    private List<Role> getRoles(HandlerMethod handler) {
        BusinessRole businessRole = handler.getMethodAnnotation(BusinessRole.class);
        return businessRole == null ? Collections.emptyList() : Arrays.asList(businessRole.value());
    }
}
