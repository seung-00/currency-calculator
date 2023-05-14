package com.youth.currencycalculator.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.youth.currencycalculator.adapter.web.dto.CurrencyDto;
import com.youth.currencycalculator.core.domain.CurrencyList;
import com.youth.currencycalculator.port.in.CurrencyUseCase;
import com.youth.currencycalculator.port.out.GetCurrencyPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CurrencyService implements CurrencyUseCase {

	@Value("${spring.profiles.currency-api.key}")
	private String API_KEY;

	private final GetCurrencyPort getCurrencyPort;

	public List<CurrencyDto> getCurrencyList() {
		CurrencyList currencyList = getCurrencyPort
			.getCurrency(API_KEY)
			.toCurrencyList();

		return currencyList.toCurrencyDtoList();
	}
}
