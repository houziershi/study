package sis.studentinfo;

import java.math.BigDecimal;

public class Account implements Accountable {

	public enum BankAccountType
	{
		CHECKING("ck"), SAVINGS("sv");

		private String value;

		private BankAccountType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	public void credit(BigDecimal amount) {
		System.out.println("credit");
	}

	public BigDecimal getBalance() {
		System.out.println("getBalance");
		return new BigDecimal("0");
	}

	public BigDecimal transactionAverage() {
		System.out.println("transactionAverage");
		return new BigDecimal("0");
	}

	public void setBankAba(String bankAba) {
		System.out.println("setBankAba");
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		System.out.println("setBankAccountNumber");
	}

	public void setBankAccountType(
			Account.BankAccountType bankAccountType) 
	{
		System.out.println("setBankAccountType");
	}

	public void transferFromBank(BigDecimal amount) {
		System.out.println("");
	}

}
