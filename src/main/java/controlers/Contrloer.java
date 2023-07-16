package controlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.*;

@WebServlet(name = "Controler", urlPatterns = { "/controler" })
public class Contrloer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con ;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("status", "t");
		
		List<Topic> topics = (List<Topic>) session.getAttribute("topics");
		
		if(topics==null)
		{
			topics = new ArrayList<>();
		}
		topics.clear();
		session.setAttribute("topics", topics);
		
		
		Statement st; 
		ResultSet rs;
		
		try 
		{
			st = con.createStatement();
			rs = st.executeQuery("select * from topic");
			while(rs.next())
			{
				Topic t = new Topic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				topics.add(t);
			}
			session.setAttribute("topics", topics);
			
			RequestDispatcher rd = request.getRequestDispatcher("showTopics.jsp");
			rd.forward(request, response);
			
		} 
		catch (Exception e) 
		{
			
		}
		
		
		
	}

}
