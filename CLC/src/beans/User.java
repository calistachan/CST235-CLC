package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {
	@NotNull()
	@Size(min=4, max=15)
	public String username;
	
	@NotNull()
	@Size(min=8, max=15)
	public String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@PostConstruct
	public void init() {
		// Get the logged in Principle
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if(principle == null)
			{
				setUsername("Unknown");
				setPassword("");
			}
			else
			{
				setUsername(principle.getName());
				setPassword("");
			}
	}
}
