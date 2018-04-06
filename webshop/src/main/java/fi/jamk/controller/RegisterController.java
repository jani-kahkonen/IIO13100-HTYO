package fi.jamk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.jamk.bl.BLAccount;
import fi.jamk.bl.IAccount;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private IAccount account;
	
	public RegisterController()
	{
		account = new BLAccount();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/views/register.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(account.isExist(email) != true)
		{
			account.insert(email, password);
			
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/failure.jsp").forward(request, response);
		}
	}
}