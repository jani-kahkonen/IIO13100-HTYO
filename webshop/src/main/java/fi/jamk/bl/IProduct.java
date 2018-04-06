package fi.jamk.bl;

import java.util.List;

import fi.jamk.model.Product;

public interface IProduct
{
	Product select(final int id);
	
	List<Product> selectAll();
	
	int insert(final double price, final String name);
	
	void update(final double price, final String name);
	
	void delete(final int id);
}