package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

public class LocationDAO {

	public static void insert(Emp emp) {

		// System.out.println("DAO-- " + emp.getName() + " " + emp.getAdd() + " " +
		// emp.getPhone());

		try {
			Connection con = JDBCUtility.getConnnnn();
			PreparedStatement ps = con.prepareStatement("insert into emp values (?,?,?)");

			ps.setString(1, emp.getName());
			ps.setString(2, emp.getAdd());
			ps.setString(3, emp.getPhone());

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data inserted successfully in db");
			}

			else {
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDetail() {
		JSONArray ja = new JSONArray();
		try {
			Connection con = JDBCUtility.getConnnnn();
			PreparedStatement ps = con.prepareStatement("select * from mst_state");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
