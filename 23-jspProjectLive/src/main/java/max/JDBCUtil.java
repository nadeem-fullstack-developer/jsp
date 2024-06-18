package max;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class JDBCUtil {
	private JDBCUtil() {

	}

	private static Connection com;
	static {
		try {

			Class.forName("org.postgresql.Driver");
			com = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oct", "postgres", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnnn() {
		return com;
	}

	public static int getMid(Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select max(mem_code) as mem_code  from member_detail");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int mem_code = rs.getInt("mem_code");
				System.out.println("dao " + mem_code);
				return mem_code + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0 + 1;
	}

	public static int updateFlag(Connection con, String uid) {
		try {
			PreparedStatement ps = con.prepareStatement("update lgn_mst set status =? where uid=?");
			ps.setString(1, "N");
			ps.setString(2, uid);
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int logCount(Connection con, String uid) {
		try {
			PreparedStatement ps = con.prepareStatement("select logcount from lgn_mst where uid=?");

			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int logcount = Integer.parseInt(rs.getString("logcount"));
				return logcount + 1;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void updateLogCount(Connection con, String uid, int logvalue) {
		try {
			PreparedStatement ps = con.prepareStatement("update lgn_mst set logcount=?  where uid=?");
			ps.setString(1, String.valueOf(logvalue));
			ps.setString(2, uid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String loggeduser(Connection con, String uid) {
		try {
			PreparedStatement ps = con.prepareStatement("update lgn_mst set logcount=?,status=?  where uid=?");
			ps.setString(1, getSys());
			ps.setString(2, "L");
			ps.setString(3, uid);
			ps.executeUpdate();
			return "LoggedUser";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String getSys() {
		long currentTimeInMillis = System.currentTimeMillis();

		Date currentDate = new Date(currentTimeInMillis);

		String currentDateTime = currentDate.toString();
		return currentDateTime;
	}
}
