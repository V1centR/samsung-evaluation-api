package br.com.samsung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EvaluationCurrency {
	
	private Integer currencyId;
	private String currencyCode;
	private String currencyDesc;

}
