package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet2", urlPatterns = { "/servlet2" })
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String str1 = request.getParameter("lpname");
		String str2 = request.getParameter("price");

		PrintWriter out = response.getWriter();
		out.print("<h1>Name = " + str1 + " Price = " + str2 + "</h1>");
	}

}
