package max.reg;

import java.util.List;

public class SHGDTO {
	int shgCode;
	private String gname;
	private String acc;
	private String ifsc;
	private String stCode;

	List<MemDTO> mlist;

	public List<MemDTO> getMlist() {
		return mlist;
	}

	public void setMlist(List<MemDTO> mlist) {
		this.mlist = mlist;
	}

	public int getShgCode() {
		return shgCode;
	}

	public void setShgCode(int shgCode) {
		this.shgCode = shgCode;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getStCode() {
		return stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

}
