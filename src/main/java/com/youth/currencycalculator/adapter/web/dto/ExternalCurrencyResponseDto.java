package com.youth.currencycalculator.adapter.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.youth.currencycalculator.core.domain.Currency;
import com.youth.currencycalculator.core.domain.CurrencyList;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalCurrencyResponseDto {

	private boolean success;

	private long timestamp;

	private String source;

	private Quotes quotes;

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Quotes {

		@JsonProperty("USDKRW")
		private double krw;

		@JsonProperty("USDJPY")
		private double jpy;

		@JsonProperty("USDPHP")
		private double php;
	}



	public CurrencyList toCurrencyList() {

		return CurrencyList.of(
			Currency.of("KRW", "한국", quotes.getKrw()),
			Currency.of("JPY", "일본", quotes.getJpy()),
			Currency.of("PHP", "필리핀", quotes.getPhp())
		);
	}
}
