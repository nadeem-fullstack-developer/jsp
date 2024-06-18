package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "process", urlPatterns = { "/process" })
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String lpname = request.getParameter("lpname");
		String price = request.getParameter("price");

		PrintWriter out = response.getWriter();
		out.print("<h1>Hai ! </h1>");
		out.print("<a href='servlet2?lpname=" + lpname + "&lpprice=" + price + "'>Click here</a>");
	}

}
