package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le driver JDBC
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorrv","root","admin");
            PreparedStatement stm = con.prepareStatement("insert into user(username,email,telephone,mot_de_passe,role) values (?,?,?,?,?)");
            stm.setString(1, username);
            stm.setString(2, email);
            stm.setString(3, telephone);
            stm.setString(4, mot_de_passe);
            stm.setString(5, role);
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC non trouvé !", e);
        }
    }
}
		//PrintWriter out = response.getWriter();
		//out.print("working");
	}

}
