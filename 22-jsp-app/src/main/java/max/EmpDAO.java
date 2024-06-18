package max;

public class EmpDAO {

	public boolean getUserDetail(Emp emp) {
		try {

			// Connection con = JDBCUtility.getConnnnn();
			System.out.println("DAO " + emp.getUid() + " " + emp.getAdd() + " " + emp.getMob());

			if (emp.getMob().length() == 10) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
