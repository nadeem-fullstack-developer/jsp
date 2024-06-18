package abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.RequestHandlerClassProxy;

@WebServlet("/ok")
public class ServiceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String fn = request.getParameter("fn");

		RequestHandlerClassProxy bb = new RequestHandlerClassProxy();

		//String r = bb.getFacto(fn);
		//out.println(r);
	}

}
