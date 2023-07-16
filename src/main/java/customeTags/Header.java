package customeTags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Header extends SimpleTagSupport
{
	String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public void doTag() throws JspException, IOException {
	 
		String username;
		            
	              username = (String) getJspContext().getAttribute("username", getJspContext().getAttributesScope("username"));
	            
	          
	            

		 
		getJspContext().getOut().print("<div ><h1 style='text-shadow:2px 2px 2px black;color:blue'>Welcome To Blogging App</h1>"
				+ "<form action='http://localhost:8080/BloggingApp/logout' method='get'>"
				+"<span style='float:right'>"+ username +"<input type='submit' value='Logout'/></span></form></div>");
	}
	

}
