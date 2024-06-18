package max;

public class RqstHndlrClass {

	public String getFacto(String n) {
		int f = 1;

		int num = Integer.parseInt(n);

		if (num == 1) {
			return "Result " + f;
		}

		else {
			for (int i = num; i > 1; i--) {
				f = i * f;
			}
			return "Result " + f;
		}
	}
}
