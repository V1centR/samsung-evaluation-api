package br.com.samsung.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationQuotation {
	
	private String fromCurrencyCode;
	private String toCurrencyCode;
	private String cotacao;
	private String dataHoraCotacao;
}
