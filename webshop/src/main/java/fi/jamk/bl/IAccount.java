package fi.jamk.bl;

import fi.jamk.model.Account;

public interface IAccount
{
	Account select(final int id);
	
	int insert(final String password, final String role);
	
	void update(final boolean active, final String email, final String password, final String role);
	
	void delete(final int id);
	
	boolean isExist(final String email);
	
	boolean isExist(final String email, final String password);
}