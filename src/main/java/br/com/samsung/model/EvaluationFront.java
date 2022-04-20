package br.com.samsung.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationFront {
	
	private String docNumber;
	private String docDate;
	private String currencyCode;
	private String currencyDesc;
	private String docValue;
	private String valueUsd;
	private String valuePen;
	private String valueBrl;
}
