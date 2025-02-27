package web;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String email = request.getParameter("email");
		String mot_de_passe = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le driver JDBC
	           Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorRv?useSSL=false","root","admin");
	           PreparedStatement stm = con.prepareStatement("select * from user where email=? and mot_de_passe=?");
	           stm.setString(1, email);
	           stm.setString(2, mot_de_passe);
	           
	          ResultSet rs = stm.executeQuery();
	        if(rs.next()) {
	        	session.setAttribute("name", rs.getString("name"));
	        	PrintWriter out = response.getWriter();
	    		out.print("working");
	        	//dispatcher = request.getRequestDispatcher("hello dear");
	        }else {
	        	request.setAttribute("status", "failed");
	        	dispatcher = request.getRequestDispatcher("login.jsp");
	        }
	        dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
	          
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		//out.print("working");
		//doGet(request, response);
	
	

