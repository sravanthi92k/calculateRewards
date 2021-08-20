package com.example.rewardcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardCalculatorController {

	@GetMapping("/processRewardPoints/{spendMoney}")
	public String processRewardPoints(@PathVariable int spendMoney) {
		int points = 0;

		if (spendMoney > 100) {

			points = (spendMoney - 100) * 2 + 50;

		} else if (spendMoney <= 100 && spendMoney > 50) {

			points = (spendMoney - 50);

		}

		return "Number of Reward Points : "+points;
	}

}
