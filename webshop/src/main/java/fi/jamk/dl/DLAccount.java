package fi.jamk.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DLAccount
{
	private static final String DB_DRIVER = "org.h2.Driver";
	
	private static final String DB_CONNECTION = "jdbc:h2:tcp://localhost/~/softat/h2/demo;DATABASE_TO_UPPER=false;MODE=MySQL";
	
	private static final String DB_USERNAME = "sa";
	
	private static final String DB_PASSWORD = "";
	
	private Connection connection = null;
	
	public ResultSet select(final int id) throws SQLException
	{
		ResultSet rs = null;
		
		try
		{
			Class.forName(DB_DRIVER);
			
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM account WHERE id=?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
		}
		catch (SQLException e)
		{
			connection.rollback();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet select(final String email) throws SQLException
	{
		ResultSet rs = null;
		
		try
		{
			Class.forName(DB_DRIVER);
			
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement pstmt = connection.prepareStatement("SELECT id FROM account WHERE email=?");
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
		}
		catch (SQLException e)
		{
			connection.rollback();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet select(final String email, final String password) throws SQLException
	{
		ResultSet rs = null;
		
		try
		{
			Class.forName(DB_DRIVER);
			
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement pstmt = connection.prepareStatement("SELECT id FROM account WHERE email=? AND password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
		}
		catch (SQLException e)
		{
			connection.rollback();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int insert(final boolean active, final String email, final String password, final String role) throws SQLException
	{
		int count = 0;
		
		try
		{
			Class.forName(DB_DRIVER);
			
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO account (active, email, password, role) VALUES (?, ?, ?, ?)");
			pstmt.setBoolean(1, active);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, role);
			
			count = pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			connection.rollback();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
}