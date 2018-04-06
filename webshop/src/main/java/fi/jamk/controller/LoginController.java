package fi.jamk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.jamk.bl.BLAccount;
import fi.jamk.bl.BLCart;
import fi.jamk.bl.IAccount;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private IAccount account;
	
	public LoginController()
	{
		account = new BLAccount();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(account.isExist(email, password) != false)
		{
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/failure.jsp").forward(request, response);
		}
	}
	
}