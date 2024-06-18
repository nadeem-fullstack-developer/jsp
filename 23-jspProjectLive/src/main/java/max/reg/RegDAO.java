package max.reg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import max.JDBCUtil;

public class RegDAO {

	public SHGMem viewDeatil() {
		SHGMem sHGMem = new SHGMem();
		List<SHGDTO> shgList = new ArrayList<SHGDTO>();
		List<MemDTO> memList = new ArrayList<MemDTO>();
		try {
			Connection con = JDBCUtil.getConnnn();
			PreparedStatement ps = con.prepareStatement("select * from shg_detail");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SHGDTO shg = new SHGDTO();
				shg.setAcc(rs.getString("shg_acc"));
				shg.setGname(rs.getString("shg_name"));
				shg.setIfsc(rs.getString("shg_ifsc"));
				shg.setStCode(rs.getString("st_code"));
				shg.setShgCode(rs.getInt("shg"));
				shgList.add(shg);
			}

			if (shgList.size() > 0)
				ps = con.prepareStatement("select * from member_detail");
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				MemDTO m = new MemDTO();
				m.setAge(rs1.getString("mem_age"));
				m.setCadhar(rs1.getString("mem_cadhar"));
				m.setCname(rs1.getString("mem_name"));
				m.setMemCode(rs1.getInt("mem_code"));
				m.setShgCode(rs1.getInt("shgcode"));
				memList.add(m);
			}

			sHGMem.setMemList(memList);
			sHGMem.setShgList(shgList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sHGMem;
	}

	public String save(SHGBean shgBean, MemberBean memberBean) {
		Connection con = JDBCUtil.getConnnn();

		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("insert into shg_detail values (?,?,?,?,?)");
			int shgcode = JDBCUtil.getMid(con);

			ps.setInt(1, shgcode);
			ps.setString(2, shgBean.getStCode());
			ps.setString(3, shgBean.getGname());
			ps.setString(4, shgBean.getAcc());
			ps.setString(5, shgBean.getIfsc());
			int j = ps.executeUpdate();

			if (j > 0) {
				ps = con.prepareStatement("insert into member_detail values(?,?,?,?,?)");
				String[] a = memberBean.getAge();
				String[] adh = memberBean.getCadhar();
				String[] n = memberBean.getCname();
				int mcode = shgcode;

				for (int i = 0; i < a.length; i++) {
					ps.setInt(1, ++mcode);
					ps.setString(2, n[i]);
					ps.setString(3, a[i]);
					ps.setString(4, adh[i]);
					ps.setInt(5, shgcode);
					ps.addBatch();
					// k=ps.executeUpdate();
				}
				int[] k = ps.executeBatch();

				if (k.length > 0) {
					con.commit();
					return "Success";
				}

				else {
					con.rollback();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "FAIL";
	}
}
