package br.com.samsung.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EvaluationCurrency {
	
	private Integer currencyId;
	private String currencyCode;
	private String currencyDesc;
	
	public Integer getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
	
	

}
