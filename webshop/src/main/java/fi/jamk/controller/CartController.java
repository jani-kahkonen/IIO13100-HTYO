package fi.jamk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.jamk.bl.BLCart;
import fi.jamk.model.Account;

@WebServlet("/CartController")
public class CartController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private BLCart cart = new BLCart();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		cart = (BLCart) session.getAttribute("cart");
		
		if (cart == null)
		{
			cart = new BLCart();
		}
		
		session.setAttribute("cart", cart);
		
		request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		
		if (action.equals("insert"))
		{
			this.insert(request, response);
		}
		else if (action.equals("delete"))
		{
			this.delete(request, response);
		}
		else if (action.equals("complete"))
		{
			this.complete(request, response);
		}
		
		request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		cart = (BLCart) session.getAttribute("cart");
		
		String id = request.getParameter("productId");
		
		cart.insert(Integer.parseInt(id));
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		cart = (BLCart) session.getAttribute("cart");
		
		String id = request.getParameter("productId");
		
		cart.delete(Integer.parseInt(id));
	}
	
	protected void complete(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("account");
	}
}