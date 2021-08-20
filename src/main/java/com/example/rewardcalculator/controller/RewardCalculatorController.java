package com.example.rewardcalculator.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewardcalculator.model.Transaction;
import com.example.rewardcalculator.model.TransactionResponse;

/**
 *
 * This is the reward calculator controller.
 * 
 *
 */

@RestController
public class RewardCalculatorController {

	/**
	 * This method is used to calculate the reward points for 3 months and also give
	 * total points earned by customer.
	 * 
	 * @param customerId
	 * @param transactions
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/processRewardPoints/{customerId}/transactions")
	public TransactionResponse processRewardPoints(@PathVariable int customerId,
			@RequestBody List<Transaction> transactions) throws Exception {

		TransactionResponse response = new TransactionResponse();

		int total = 0;
		int lastMonths = 3;
		int months[] = new int[lastMonths];
		Date[] start = new Date[lastMonths];
		Date[] end = new Date[lastMonths];

		// getting the start and end dates of the 3 months w.r.t currentDate
		findStartandEndofMonths(lastMonths, start, end);

		for (int i = 0; i < lastMonths; i++) {

			int monthTotal = 0;

			for (Transaction transaction : transactions) {

				Date transactionDate = transaction.getTransactionDate();

				if (transactionDate.after(start[i]) && transactionDate.before(end[i])) {

					// calculate points
					monthTotal = monthTotal + calculatePoints(transaction.getTransactionAmount());
				}

			}

			months[i] = monthTotal;
			total = total + monthTotal;
		}

		// updating response.
		response.setMonth1Points(months[2]);
		response.setMonth2Points(months[1]);
		response.setMonth3Points(months[0]);
		response.setTotal(total);

		return response;
	}

	/**
	 * find the start and end date w.r.t current Date
	 * 
	 * @param lastMonths
	 * @param start
	 * @param end
	 * @throws Exception
	 */
	private void findStartandEndofMonths(int lastMonths, Date[] start, Date[] end) throws Exception {
		LocalDate currentDate = LocalDate.now();
		LocalDate prevDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < lastMonths; i++) {
			if (prevDate == null) {
				start[i] = simpleDateFormat.parse(currentDate.withDayOfMonth(1).toString());
				end[i] = simpleDateFormat.parse(currentDate.withDayOfMonth(currentDate.lengthOfMonth()).toString());
				prevDate = currentDate.minusMonths(1);
			} else {
				start[i] = simpleDateFormat.parse(prevDate.withDayOfMonth(1).toString());
				end[i] = simpleDateFormat.parse(prevDate.withDayOfMonth(prevDate.lengthOfMonth()).toString());
				prevDate = prevDate.minusMonths(1);
			}
			System.out.println(start[i] + " " + end[i]);
		}
	}

	/**
	 * calculate points.
	 * 
	 * 
	 * @param spendMoney
	 * @return
	 */
	private int calculatePoints(int spendMoney) {
		int points = 0;

		if (spendMoney > 100) {

			points = (spendMoney - 100) * 2 + 50;

		} else if (spendMoney <= 100 && spendMoney > 50) {

			points = (spendMoney - 50);

		}
		return points;
	}

}
