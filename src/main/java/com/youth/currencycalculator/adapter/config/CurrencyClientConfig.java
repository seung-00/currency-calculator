package com.youth.currencycalculator.adapter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.youth.currencycalculator.port.out.GetCurrencyPort;


@Configuration
public class CurrencyClientConfig {

	@Value("${spring.profiles.currency-api.url}")
	private String URL;

	@Bean
	public GetCurrencyPort currencyPort() {
		WebClient webClient = WebClient.create(URL);

		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
			.builder(WebClientAdapter.forClient(webClient))
			.build();

		return httpServiceProxyFactory.createClient(GetCurrencyPort.class);
	}
}
