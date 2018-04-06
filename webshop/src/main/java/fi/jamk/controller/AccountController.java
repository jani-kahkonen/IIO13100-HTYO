package fi.jamk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.jamk.bl.BLAccount;
import fi.jamk.bl.IAccount;

@WebServlet("/AccountController")
public class AccountController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private IAccount account;
	
	public AccountController()
	{
		account = new BLAccount();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("account", account.select(1));
		
		request.getRequestDispatcher("/views/account.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
}