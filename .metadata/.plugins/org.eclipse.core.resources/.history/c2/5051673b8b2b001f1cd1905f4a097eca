package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class LocationDAO {
	public String getDetail()
	{    
		JSONArray ja = new JSONArray();
		try {
			Connection con = JDBCUtility.getConnnnn();
			  PreparedStatement ps = con.prepareStatement("select * from mst_state");
		ResultSet rs = ps.executeQuery();
		 while(rs.next())
		 {
			 JSONObject j = new JSONObject();
			 j.put("stCode", rs.getInt(1));
			 j.put("stName", rs.getString(2));
			 j.put("shortName", rs.getString(3));
			ja.put(j);
		 }
		return ja.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
