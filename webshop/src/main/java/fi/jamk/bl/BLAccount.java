package fi.jamk.bl;

import java.sql.ResultSet;
import java.sql.SQLException;

import fi.jamk.dl.DLAccount;
import fi.jamk.model.Account;

public class BLAccount implements IAccount
{
	private DLAccount dlAccount;
	
	public BLAccount()
	{
		dlAccount = new DLAccount();
	}
	
	@Override
	public Account select(final int id)
	{
		Account account = null;
		
		try
		{
			ResultSet rs = dlAccount.select(id);
			
			while(rs.next())
			{
				account = new Account(rs.getInt("id"), rs.getBoolean("active"), rs.getString("email"), rs.getString("password"), rs.getString("role"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return account;
	}

	@Override
	public int insert(String email, String password)
	{
		int count = 0;
		
		try
		{
			count = dlAccount.insert(true, email, password, "customer");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void update(boolean active, String email, String password, String role)
	{
		
	}

	@Override
	public void delete(final int id)
	{
		
	}
	
	@Override
	public boolean isExist(String email)
	{
		boolean exist = false;
		
		try
		{
			ResultSet rs = dlAccount.select(email);
			
			exist = rs.next();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return exist;
	}
	
	@Override
	public boolean isExist(String email, String password)
	{
		boolean exist = false;
		
		try
		{
			ResultSet rs = dlAccount.select(email, password);
			
			exist = rs.next();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return exist;
	}
}