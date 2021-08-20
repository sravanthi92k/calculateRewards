package com.example.rewardcalculator.model;

import java.util.Date;

/**
 * 
 * Transaction Model class used for request purpose.
 * 
 *
 */
public class Transaction {

	private int transactionAmount;

	private Date transactionDate;

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}
