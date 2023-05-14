package com.youth.currencycalculator.domain;


import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.youth.currencycalculator.core.domain.Currency;

public class CurrencyTest {
	@Test
	public void 환율_금액은_소수점_둘째_자리에서_반올림() {
		double amount = 123.456789;
		BigDecimal decimalValue = new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
		double expected = decimalValue.doubleValue();

		Currency currency = Currency.of("USD", "미국 달러", amount);
		double actual = currency.getAmount();

		assertThat(actual).isEqualTo(expected);
	}
}
