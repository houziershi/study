package sis.studentinfo;

import java.lang.reflect.*;
import sis.security.*;

public class AccountFactory {

	public static Accountable create(Permission permission) {
		switch (permission) {
			case UPDATE:
				return new Account();
			case READ_ONLY:
				return createSecuredAccount();
		}
		return null;
	}

	private static Accountable createSecuredAccount() {
		SecureProxy secureAccount = new SecureProxy(
			new Account(),
			"credit",
			"setBankAba",
			"setBankAccountNumber",
			"setBankAccountType",
			"transferFromBank"
		);

		return (Accountable)Proxy.newProxyInstance(
			Accountable.class.getClassLoader(),
			new Class[] { Accountable.class },
			secureAccount
		);
	}
}
