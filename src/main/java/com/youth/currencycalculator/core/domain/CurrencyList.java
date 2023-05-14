package com.youth.currencycalculator.core.domain;

import java.util.List;
import java.util.stream.Collectors;

import com.youth.currencycalculator.adapter.web.dto.CurrencyDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CurrencyList {

	private List<Currency> currencyList;

	private CurrencyList(List<Currency> currencies) {
		this.currencyList = currencies;
	}

	public static CurrencyList from (List<Currency> currencies) {
		return new CurrencyList(currencies);
	}

	public static CurrencyList of(Currency ...currencies) {
		return new CurrencyList(List.of(currencies));
	}

	public List<CurrencyDto> toCurrencyDtoList() {
		return currencyList.stream()
			.map(CurrencyDto::of)
			.collect(Collectors.toList());
	}
}
