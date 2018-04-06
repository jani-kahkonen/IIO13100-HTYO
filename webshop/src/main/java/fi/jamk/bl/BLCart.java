package fi.jamk.bl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fi.jamk.dl.DLProduct;
import fi.jamk.model.Product;

public class BLCart
{
	private DLProduct dlProduct;
	
	private List<Product> products = new ArrayList<Product>();

	public BLCart()
	{
		dlProduct = new DLProduct();
	}
	
	public List<Product> getProducts()
	{
		return products;
	}
	
	public void setProducts(List<Product> products)
	{
		this.products = products;
	}
	
	public void insert(final int id)
	{
		try
		{
			ResultSet rs = dlProduct.select(id);
			
			while(rs.next())
			{
				products.add(new Product(rs.getInt("id"), rs.getDouble("price"), rs.getString("name")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void delete(final int id)
	{
		products.remove(id);
	}
}