package br.com.samsung.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EvaluationQuotation {
	
	private String fromCurrencyCode;
	private String toCurrencyCode;
	private String cotacao;
	private String dataHoraCotacao;	
	
	public String getCotacao() {
		return cotacao;
	}
	public void setCotacao(String cotacao) {
		this.cotacao = cotacao;
	}
	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}
	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}
	public String getToCurrencyCode() {
		return toCurrencyCode;
	}
	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}
	
	public String getDataHoraCotacao() {
		return dataHoraCotacao;
	}
	public void setDataHoraCotacao(String dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}
	
	
}
