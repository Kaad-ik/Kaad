package hu.elte.recipe.entities.httpentities;

import java.util.List;

import hu.elte.recipe.entities.Currency;
import hu.elte.recipe.entities.Role;

public class UserHttpEntity {
	
	private Long id;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private Role role;
    private Integer money;
    private Currency currency;

    public UserHttpEntity() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
        
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}
    
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Currency getCurrency() {
		return currency;
	}
    
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
