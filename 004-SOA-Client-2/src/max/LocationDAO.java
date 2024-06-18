package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {

	public List<StateBean> getDetail() {

		ArrayList<StateBean> list = new ArrayList<StateBean>();

		try {
			Connection con = JDBCUtility.getConnnnn();
			PreparedStatement ps = con.prepareStatement("select * from mst_state");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				StateBean sb = new StateBean();
				sb.setStCode(rs.getInt(1));
				sb.setStName(rs.getString(2));
				sb.setShortName(rs.getString(3));
				list.add(sb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
