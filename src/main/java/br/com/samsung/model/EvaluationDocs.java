package br.com.samsung.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDocs {
	
	private String documentId;
	private String documentNumber;
	private String notaFiscal;
	private String documentDate;
	private String documentValue;
	private String currencyCode;

}
