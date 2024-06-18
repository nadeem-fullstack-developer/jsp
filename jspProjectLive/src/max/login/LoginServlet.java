package max.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		String mob = request.getParameter("mob");
		String otp = request.getParameter("otp");
		LoginBean lb=new LoginBean();
		lb.setMob(mob);
		lb.setOtp(otp);
		lb.setPass(pass);
		lb.setUid(uid);
		LoginDAO lgnDAO=new LoginDAO();
		String st = lgnDAO.login(lb);
		if(st.equalsIgnoreCase("WELCOME"))
		{
			HttpSession s = request.getSession(true);
			s.setAttribute("uid", uid);
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}
		else
		out.println(st);
	}

}
