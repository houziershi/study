package example;

public enum UserAuth {
	ADD(1),EDIT(2),DELETE(4),SEARCH(8);

	private int mask;

	UserAuth(int mask) {
		this.mask = mask;
	}

	public int getMask() {
		return this.mask;
	}
}
