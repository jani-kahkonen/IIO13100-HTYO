package fi.jamk.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DLProduct
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
			
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM product WHERE id=?");
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
	
	public ResultSet selectAll() throws SQLException
	{
		ResultSet rs = null;
		
		try
		{
			Class.forName(DB_DRIVER);
			
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM product");
			
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
	
	public int insert(final double price, final String name) throws SQLException
	{
		int count = 0;
		
		try
		{
			Class.forName(DB_DRIVER);
			
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO product (price, name) VALUES (?, ?)");
			pstmt.setDouble(1, price);
			pstmt.setString(2, name);
			
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