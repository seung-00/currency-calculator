package com.youth.currencycalculator.adapter.web.dto;

import com.youth.currencycalculator.core.domain.Currency;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CurrencyDto {

	private String code;

	private String name;

	private double amount;

	private CurrencyDto(String code, String name, double amount) {
		this.code = code;
		this.name = name;
		this.amount = amount;
	}

	public static CurrencyDto of(Currency currency) {
		return new CurrencyDto(currency.getCode(), currency.getName(), currency.getAmount());
	}
}
