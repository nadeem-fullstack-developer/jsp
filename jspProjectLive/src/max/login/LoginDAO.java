package max.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import max.EncryPass;
import max.JDBCUtil;

public class LoginDAO {

	public List<StateBean> getStateList() {
		List<StateBean> list = new ArrayList<StateBean>();
		try {
			Connection con = JDBCUtil.getConnnn();
			PreparedStatement ps = con.prepareStatement("select * from mst_state");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StateBean sb = new StateBean();

				sb.setStCode("" + rs.getInt(1));
				sb.setStName(rs.getString(2));
				sb.setShrtName(rs.getString(3));
				list.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String login(LoginBean loginBean) {
		try {
			Connection con = JDBCUtil.getConnnn();
			PreparedStatement ps = con.prepareStatement("select pass,status from lgn_mst where uid=?");
			ps.setString(1, loginBean.getUid());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String pass = rs.getString("pass");
				String status = rs.getString("status");
				if (status.equalsIgnoreCase("Y")) {
					if (pass.equals(EncryPass.getMd5(loginBean.getPass()))) {
						JDBCUtil.updateFlag(con, loginBean.getUid());
						return "WELCOME";
					} else {
						int logvalue = JDBCUtil.logCount(con, loginBean.getUid());
						if (logvalue == 1 || logvalue == 2) {
							JDBCUtil.updateLogCount(con, loginBean.getUid(), logvalue);
						} else {
							return JDBCUtil.loggeduser(con, loginBean.getUid());
						}
					}

				}

				else if (status.equalsIgnoreCase("N")) {
					return "User Already Logged in";
				} else if (status.equalsIgnoreCase("L")) {
					return "User  Logged";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Wrong UID";

	}

	public String verifyOtp(String mob) {
		try {
			Connection con = JDBCUtil.getConnnn();
			PreparedStatement ps = con.prepareStatement("select mobile from lgn_mst where mobile=?");
			ps.setString(1, mob);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String mobile = rs.getString("mobile");
				if (mobile.equalsIgnoreCase(mob)) {
					String otp = genrateOTPP();
					ps = con.prepareStatement("update lgn_mst set otp=? where mobile=?");
					ps.setInt(1, Integer.parseInt(otp));
					ps.setString(2, mobile);
					int i = ps.executeUpdate();
					if (i > 0) {
						return otp;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "wrong";
	}

	public String genrateOTPP() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 9; i++) {
			sb.append(new Random().nextInt(10));
		}
		return sb.substring(6, 9);
	}

}
