package controlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

 
@WebServlet("/logincheck")
public class LogingCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
	}

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		entities.User user = (User) session.getAttribute("user");
		String username = (String) session.getAttribute("username");
		String status = (String) session.getAttribute("status");
		PreparedStatement ps;
		ResultSet rs;
		
		String u_id = request.getParameter("uid");
		String password = request.getParameter("pwd");
		try {
			ps = con.prepareStatement("select * from users where uid=? and password=?");
			ps.setString(1, u_id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next())
			{
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				session.setAttribute("user", user);
				username = rs.getString(3)+" "+ rs.getString(4);
				session.setAttribute("username", username);
				
				if(status != null)
				{
					if(status.compareTo("t") == 0)
						response.sendRedirect("addTopics.jsp");
					else 
						response.sendRedirect("AddComments.jsp");
				}
				else
					{
					RequestDispatcher rd = request.getRequestDispatcher("controler");
					rd.forward(request, response);
					}
				
			}
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
