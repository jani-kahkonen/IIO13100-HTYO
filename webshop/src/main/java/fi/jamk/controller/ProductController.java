package fi.jamk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.jamk.bl.BLProduct;
import fi.jamk.bl.IProduct;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private IProduct product;
	
	public ProductController()
	{
		product = new BLProduct();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("product", product.select(1));
		
		request.setAttribute("products", product.selectAll());
		
		request.getRequestDispatcher("/views/product.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}