package br.com.samsung.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	public String getDocDate() {
		return docDate;
	}
	public void setDocDate(String docDate) {
		this.docDate = docDate;
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
	public String getDocValue() {
		return docValue;
	}
	public void setDocValue(String docValue) {
		this.docValue = docValue;
	}
	public String getValueUsd() {
		return valueUsd;
	}
	public void setValueUsd(String valueUsd) {
		this.valueUsd = valueUsd;
	}
	public String getValuePen() {
		return valuePen;
	}
	public void setValuePen(String valuePen) {
		this.valuePen = valuePen;
	}
	public String getValueBrl() {
		return valueBrl;
	}
	public void setValueBrl(String valueBrl) {
		this.valueBrl = valueBrl;
	}

}
