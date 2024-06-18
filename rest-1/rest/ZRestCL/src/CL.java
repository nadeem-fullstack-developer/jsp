import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CL {
	public static void main(String[] args) {
		try {
			String url = "http://localhost:9595/ARestServer12/ok/rht/data";
			Client client = Client.create();
			WebResource wr = client.resource(url);
			ClientResponse r = wr.accept("application/text").post(ClientResponse.class);
			String rst = r.getEntity(String.class);
			// System.out.println(rst);

			JSONArray jsonArray = new JSONArray(rst);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				System.out.println(jsonObject.getString("stCode") + " " + jsonObject.getString("stName") + " ---- "
						+ (jsonObject.getString("shortName")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
