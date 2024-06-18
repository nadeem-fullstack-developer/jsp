package max;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class XMLClass {

	public String generateXML(AllState allState) {

		try {

			JAXBContext jc = JAXBContext.newInstance(AllState.class);
			Marshaller m = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			m.marshal(allState, sw);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
