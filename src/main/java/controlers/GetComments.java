package controlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import entities.Comment;

/**
 * Servlet implementation class GetComments
 */
@WebServlet("/getComments")
public class GetComments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 session.setAttribute("status", "c");
		 
		 List<Comment> commnets = (List<Comment>) session.getAttribute("comments");
		 
		 if(commnets == null)
		 {
			 commnets = new ArrayList<>();
		 }
		 commnets.clear();
		 
		  
		 
		 
		 String tid = request.getParameter("tid");
		 
		 if( tid == null)
		 {
			 tid = (String) session.getAttribute("tpoicid");
		 }
		 
		 
		 session.setAttribute("tpoicid",  tid);
		 
		 PreparedStatement ps;
		 ResultSet rs;
		 
		 try 
		 {
			 ps = con.prepareStatement("select * from comments where topicid = ?");
			 ps.setInt(1, Integer.parseInt(tid));
			 rs = ps.executeQuery();
			 
			 while(rs.next())
			 {
				 Comment c = new Comment(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4));
				 commnets.add(c);
			 }
			 session.setAttribute("commnets", commnets);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("showComments.jsp");
			 rd.forward(request, response);
			
		 } 
		 catch (Exception e) {
			// TODO: handle exception
			 response.sendRedirect("error.jsp");
		 }
	}

}
