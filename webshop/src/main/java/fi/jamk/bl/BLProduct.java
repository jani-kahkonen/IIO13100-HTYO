package fi.jamk.bl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fi.jamk.dl.DLProduct;
import fi.jamk.model.Product;

public class BLProduct implements IProduct
{
	private DLProduct dlProduct;
	
	public BLProduct()
	{
		dlProduct = new DLProduct();
	}
	
	@Override
	public Product select(final int id)
	{
		Product product = null;
		
		try
		{
			ResultSet rs = dlProduct.select(id);
			
			while(rs.next())
			{
				product = new Product(rs.getInt("id"), rs.getDouble("price"), rs.getString("name"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return product;
	}
	
	@Override
	public List<Product> selectAll()
	{
		List<Product> products = new ArrayList<Product>();
		
		try
		{
			ResultSet rs = dlProduct.selectAll();
			
			while(rs.next())
			{
				products.add(new Product(rs.getInt("id"), rs.getDouble("price"), rs.getString("name")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return products;
	}
	
	@Override
	public int insert(final double price, final String name)
	{
		int count = 0;
		
		try
		{
			count = dlProduct.insert(price, name);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void update(final double price, final String name)
	{
		
	}

	@Override
	public void delete(final int id)
	{
		
	}
}