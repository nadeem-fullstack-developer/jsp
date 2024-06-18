package noida;

import java.util.List;

import max.AllState;
import max.LocationDAO;
import max.StateBean;
import max.XMLClass;

public class CL {

	public static void main(String[] args) {

		//RequestHandlerClassProxy proxy = new RequestHandlerClassProxy();

		try {
			LocationDAO locationDAO = new LocationDAO();
			
			List<StateBean> list = locationDAO.getDetail();

			AllState allState = new AllState();
			allState.setList(list);
			
			XMLClass xmlClass = new XMLClass();
			String xml = xmlClass.generateXML(allState);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
