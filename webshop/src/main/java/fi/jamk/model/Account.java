package fi.jamk.model;

import javax.validation.constraints.Size;

public class Account implements Cloneable
{
	private int id;
	private boolean active;
	@Size(min = 1, max = 99)
	private String email;
	@Size(min = 1, max = 99)
	private String password;
	private String role;
	
	public Account()
	{
		super();
	}
	
	public Account(int id, boolean active, String email, String password, String role)
	{
		super();
		this.id = id;
		this.active = active;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	@Override
	public String toString()
	{
		return "Account [" + id + ", " + active + ", " + email + ", " + password + ", " + role + "]";
	}
}