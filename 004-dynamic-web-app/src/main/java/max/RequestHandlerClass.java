package max;

import java.util.List;

public class RequestHandlerClass {

	public String getXmlData(String xml) {
		System.out.println("Received " + xml);
		return "Successfull";
	}

	public String getStateDataByXML() {

		LocationDAO lDao = new LocationDAO();
		List<StateBean> list = lDao.getDetail();
		AllState allState = new AllState();
		allState.setList(list);
		XMLClass xmlClass = new XMLClass();
		String xml = xmlClass.generateXML(allState);

		return xml;

	}

	/*
	 * public String m1(String s) { return "Hi " + s.toUpperCase(); }
	 * 
	 * public String getFacto(String n) { int f = 1;
	 * 
	 * int num = Integer.parseInt(n); if (num == 1) { return "Result " + f; } else {
	 * for (int i = num; i > 1; i--) { f = i * f; } return "Result " + f; } }
	 */
}
