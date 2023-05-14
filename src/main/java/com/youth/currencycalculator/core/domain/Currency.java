package com.youth.currencycalculator.core.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Currency {

	public static final int DECIMAL_ROUND_SCALE = 2;

	private String code;

	private String name;

	private double amount;

	private Currency(String code, String name, double amount) {
		this.code = code;
		this.name = name;
		this.amount = amount;
	}

	private static BigDecimal roundDecimal(double value, int scale) {
		BigDecimal decimalValue = new BigDecimal(Double.toString(value));

		decimalValue = decimalValue.setScale(scale, RoundingMode.HALF_UP);

		return decimalValue;
	}

	public static Currency of(String code, String name, double amount) {
		return new Currency(code, name, roundDecimal(amount, DECIMAL_ROUND_SCALE).doubleValue());
	}
}
