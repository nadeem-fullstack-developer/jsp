import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class CL {
public static void main(String[] args) {
	try {
		String url="http://localhost:8081/ARestServer12/ok/rht/data";
		Client client = Client.create();
		WebResource wr = client.resource(url);
ClientResponse r = wr.accept("application/text").post(ClientResponse.class);
	   String rst = r.getEntity(String.class);
	JSONArray ja = new JSONArray(rst);
	   for(int i=0;i<ja.length();i++)
	   {
		  JSONObject b = ja.getJSONObject(i);
		  
System.out.println(b.getString("stCode")+" "+b.getString("stName")+" --- "+b.getString("shortName"));
	   }
	   
	   
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
