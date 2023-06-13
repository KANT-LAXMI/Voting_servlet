package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("in init method" +getClass()+e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
		} catch (Exception e) {
		  System.out.println("in destroy method"+getClass()+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String firstName=request.getParameter("firstnm");
			String lastName=request.getParameter("lastnm");
			String email=request.getParameter("email");
			String password=request.getParameter("pass");
			String dob=request.getParameter("dob");
			 Date newDate=Date.valueOf("dob");
			 boolean user=userDao.addUser(firstName, lastName, email, password, newDate);
			 if(user) {
		    		response.sendRedirect("login.html");
		    	}else {
//		    		System.out.println("in user");
		    		response.sendRedirect("registration.html");
		    	}
		      
		    } catch (Exception e) {
				throw new ServletException("err in do- " + getClass(), e);
			}
		}
	}


