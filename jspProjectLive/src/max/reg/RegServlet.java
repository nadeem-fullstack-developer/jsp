package max.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  PrintWriter out = response.getWriter();
    	   String gname = request.getParameter("gname");
    	   String acc = request.getParameter("acc");
    	   String ifsc = request.getParameter("ifsc");
    	   String stCode = request.getParameter("stCode");
    	   SHGBean sHGBean=new SHGBean();
    	   sHGBean.setAcc(acc);
    	   sHGBean.setGname(gname);
    	   sHGBean.setIfsc(ifsc);
    	   sHGBean.setStCode(stCode);
    	   String[] cname = request.getParameterValues("cname");
    	   String[] age = request.getParameterValues("age");
    	   String[] cadhar = request.getParameterValues("cadhar");
    	   MemberBean mBean=new MemberBean();
    	   mBean.setAge(age);
    	   mBean.setCadhar(cadhar);
    	   mBean.setCname(cname);
    	   RegDAO regDAO=new RegDAO();
    	  String st = regDAO.save(sHGBean, mBean);
    	  out.println(st);
	}

}
