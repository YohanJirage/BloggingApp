package controlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;


@WebServlet("/addCommentsServlet")
public class AddCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmnt = request.getParameter("cmnt");
		HttpSession session =  request.getSession();
		entities.User user =  (User) session.getAttribute("user");
		String uid = user.getU_id();
		int tid =  Integer.parseInt((String) session.getAttribute("tpoicid"));
		
		String desc = request.getParameter("desc");
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into comments values(default,?,?,?)");
			ps.setString(1,cmnt);
			ps.setInt(2,tid);
			ps.setString(3,uid);
			ps.executeUpdate();
			RequestDispatcher rd =  request.getRequestDispatcher("/getComments");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
