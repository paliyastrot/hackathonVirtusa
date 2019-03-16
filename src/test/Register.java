
package test;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

//class for Registering the participant
@SuppressWarnings("unchecked")
public class Register extends HttpServlet 
{
	/**
	 * 
	 */
//	private static final long serialVersionUID = -6992092601232596459L;

	//overriding the service method
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        try
        {
        	String email = request.getParameter("email");
		    String name = request.getParameter("name");
		    String college_name = request.getParameter("college_name");
		    String event_name = request.getParameter("event_name");
		    String contact_number = request.getParameter("contact_number");
//		    String s = request.getParameter("registration_amount");
//		    Integer registration_amount = Integer.parseInt(request.getParameter("registration_amount"));
		    Integer registration_amount = 50;
		    String year = request.getParameter("year");
		    String branch = request.getParameter("branch");
		    System.out.println(email +" "+name+ " "+ college_name + " "+event_name +" "+contact_number+ " "+ year +" "+branch);
		    
		    String flag = DBConnection.insertUser(email, name, college_name, event_name, contact_number, registration_amount, year, branch);
//		    System.out.println(flag);
		    if(flag.equals("Done") && college_name.equals("G.L. Bajaj Institute of Technology and Management, Greater Noida"))
		    {
		    	response.sendRedirect("success.html");
		    }
		    
		    else if(flag.equals("Done"))
		    {
		    	response.sendRedirect("payment.html");
		    }
		    else
		    {
//		    	System.out.println(flag);
		    	response.sendRedirect("error.html");
		    }
		    
        }
        
        
        catch(SQLException exception)
        {
        	exception.printStackTrace();
        	return ;
        }

    }
    
}