package com.example.rewardcalculator.model;

/**
 * 
 * TransactionResponse Model class used for response purpose.
 * 
 *
 */
public class TransactionResponse {

	private int month1Points;

	private int month2Points;

	private int month3Points;

	private int total;

	public int getMonth1Points() {
		return month1Points;
	}

	public void setMonth1Points(int month1Points) {
		this.month1Points = month1Points;
	}

	public int getMonth2Points() {
		return month2Points;
	}

	public void setMonth2Points(int month2Points) {
		this.month2Points = month2Points;
	}

	public int getMonth3Points() {
		return month3Points;
	}

	public void setMonth3Points(int month3Points) {
		this.month3Points = month3Points;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
