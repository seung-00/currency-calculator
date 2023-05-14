package com.youth.currencycalculator.port.out;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;

import com.youth.currencycalculator.adapter.web.dto.ExternalCurrencyResponseDto;

public interface GetCurrencyPort {
	@GetExchange("/currency_data/live?source=USD&currencies=KRW,JPY,PHP")
	ExternalCurrencyResponseDto getCurrency(@RequestHeader(name = "apikey") String apikey);
}
