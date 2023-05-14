package com.youth.currencycalculator.adapter.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.youth.currencycalculator.adapter.web.dto.CurrencyDto;
import com.youth.currencycalculator.core.service.CurrencyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CurrencyController {

	private final CurrencyService currencyService;

	@GetMapping("/currency-calculator")
	public String currencyCalculator(Model model) {
		List<CurrencyDto> currencyList = currencyService.getCurrencyList();

		model.addAttribute("currencies", currencyList);

		return "currency-calculator.html";
	}
}
