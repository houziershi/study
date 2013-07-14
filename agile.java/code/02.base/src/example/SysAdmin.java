package example;

public class SysAdmin {
	private int authValue = 0x0;

	public void setAuth(UserAuth ... flags) {
		for(UserAuth f: flags)
			this.authValue |= f.getMask();
	}

	public void unsetAuth(UserAuth ... flags) {
		for(UserAuth f: flags)
			this.authValue &= ~f.getMask();
	}

	public boolean hasAuth(UserAuth ... flags) {
		boolean r = true;
		for(UserAuth f: flags) 
			if(f.getMask() != (this.authValue & f.getMask())) 
			{ r = false; break; }
		return r;
	}

	public int getAuthValue() {
		return this.authValue;
	}
}
