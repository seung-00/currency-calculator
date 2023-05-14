package com.youth.currencycalculator.port.in;

import java.util.List;

import com.youth.currencycalculator.adapter.web.dto.CurrencyDto;

public interface CurrencyUseCase {
	public List<CurrencyDto> getCurrencyList();
}
