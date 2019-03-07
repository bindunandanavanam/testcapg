package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {
	int count = 0;
	Account a = new Account();
	Map<String, Account> accountEntry;

	public AccountDaoImpl() {
		accountEntry = new HashMap<>();
		accountEntry.put("7337065675", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9347849476", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9949216854", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9963139934", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9393032616", new Account("Prepaid", "Tushar", 632));

	}

	@Override
	public Account getAccountDetails(String mobileNo) {
		
		for (Map.Entry m : accountEntry.entrySet()) {
			if (mobileNo.equals(m.getKey())) {
				System.out.println("exists");
				a = (Account) m.getValue();
				count++;
				break;
			}
		}
		if (count == 0) {
			return null;
		} else {
			return a;
		}

	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		int res = 0;
		for (Map.Entry m : accountEntry.entrySet()) {
			if (mobileNo.equals(m.getKey())) {
				a=(Account) m.getValue();
				res=(int) (rechargeAmount+a.getAccountBalance());
				a.setAccountBalance(res);
				System.out.println("Hello "+a.getCustomerName() );
				//accountEntry.replace(mobileNo, res);
			count++;
			break;
		}
		}
		if (count == 0) {
			return 0;
		} else {
			return res;
		}

}
}
