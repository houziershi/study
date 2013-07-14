package stringtools;

public enum Color {

	RED(255, 0, 0), BLUE(0, 0, 255), GREEN(0, 255, 0), //
	YELLOW(255, 255, 0), BLACK(0, 0, 0), WHITE(0, 255, 0);

	private int redValue;
	private int greenValue;
	private int blueValue;

	private Color(int rv, int gv, int bv) {
		this.redValue = rv;
		this.greenValue = gv;
		this.blueValue = bv;

	}

	public String toString() {
		return super.toString() + "(" + redValue + "," + greenValue + ","
				+ blueValue + ")";
	}

}
