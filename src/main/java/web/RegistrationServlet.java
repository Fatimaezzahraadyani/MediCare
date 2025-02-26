package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = request.getParameter("nom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String mot_de_passe = request.getParameter("password");
		String role = request.getParameter("role");
		RequestDispatcher dispatcher = null;
		Connection con = null ;
		try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le driver JDBC
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorRv","root","admin");
            PreparedStatement stm = con.prepareStatement("insert into user(username,email,telephone,mot_de_passe,role) values (?,?,?,?,?)");
            stm.setString(1, username);
            stm.setString(2, email);
            stm.setString(3, telephone);
            stm.setString(4, mot_de_passe);
            stm.setString(5, role);
            
            int rowCount = stm.executeUpdate(); 
            dispatcher = request.getRequestDispatcher("register.jsp");
            if(rowCount > 0){
            	request.setAttribute("status ", "success");
        }else {
        	request.setAttribute("status ", "failed");
        } 
            dispatcher.forward(request,response); 
		}catch (Exception e) {
			e.printStackTrace();
            //throw new SQLException("Driver JDBC non trouvé !", e);
        }finally {
        try {
        con.close();
        } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } 
        }
    }
}
		//PrintWriter out = response.getWriter();
		//out.print("working");
	


