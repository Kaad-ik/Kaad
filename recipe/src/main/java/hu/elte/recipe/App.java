package hu.elte.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The Class App.
 */
@SpringBootApplication
@EnableJpaRepositories
public class App extends WebMvcConfigurerAdapter {

  /** The auth interceptor. */
  @Autowired private HandlerInterceptor authInterceptor;

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authInterceptor);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**");
  }
}
