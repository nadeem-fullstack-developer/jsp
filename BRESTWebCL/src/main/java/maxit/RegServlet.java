package maxit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String add = request.getParameter("add");
		String phone = request.getParameter("phone");


		try {

			JSONObject jsonObject = new JSONObject();

			jsonObject.put("name", name);
			jsonObject.put("address", add);
			jsonObject.put("phone", phone);

			String url = "http://localhost:9595/ARestServer12/ok/rht/save";
			Client client = Client.create();
			WebResource wr = client.resource(url);
			ClientResponse r = wr.accept("application/text").post(ClientResponse.class, jsonObject.toString());
			String rst = r.getEntity(String.class);
			out.println(rst);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
