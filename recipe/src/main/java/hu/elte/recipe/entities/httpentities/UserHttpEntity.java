package hu.elte.recipe.entities.httpentities;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Role;

/**
 * The Class UserHttpEntity.
 */
public class UserHttpEntity {

  /** The id. */
  private Long id;
    
  /** The user name. */
  private String userName;
    
  /** The password. */
  private String password;
    
  /** The full name. */
  private String fullName;
    
  /** The email. */
  private String email;
    
  /** The role. */
  private Role role;
    
  /** The money. */
  private Integer money;
    
  /** The currency. */
  private Currency currency;

  /**
   * Instantiates a new user http entity.
   */
  public UserHttpEntity() { }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Long id) {
    this.id = id;
  }
    
  /**
   * Gets the user name.
   *
   * @return the user name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the user name.
   *
   * @param userName the new user name
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }
        
  /**
   * Gets the password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   *
   * @param password the new password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets the full name.
   *
   * @return the full name
   */
  public String getFullName() {
    return fullName;
  }
    
  /**
   * Sets the full name.
   *
   * @param fullName the new full name
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the role.
   *
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * Sets the role.
   *
   * @param role the new role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * Gets the money.
   *
   * @return the money
   */
  public Integer getMoney() {
    return money;
  }

  /**
   * Sets the money.
   *
   * @param money the new money
   */
  public void setMoney(Integer money) {
    this.money = money;
  }

  /**
   * Gets the currency.
   *
   * @return the currency
   */
  public Currency getCurrency() {
    return currency;
  }
    
  /**
   * Sets the currency.
   *
   * @param currency the new currency
   */
  public void setCurrency(Currency currency) {
    this.currency = currency;
  }
}
