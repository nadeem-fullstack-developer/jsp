package max;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "india")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllState {

	@XmlElement(name = "state")
	List<StateBean> list;

	public List<StateBean> getList() {
		return list;
	}

	public void setList(List<StateBean> list) {
		this.list = list;
	}

}
