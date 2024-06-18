package noida;

import java.rmi.RemoteException;

import max.RequestHandlerClassProxy;

public class CL {

	public static void main(String[] args) {

		RequestHandlerClassProxy proxy = new RequestHandlerClassProxy();

		/*
		 * try { String m1 = proxy.m1("aaa"); System.out.println(m1); } catch
		 * (RemoteException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		try {
			String xml = proxy.getStateDataByXML();
			System.out.println(xml);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
