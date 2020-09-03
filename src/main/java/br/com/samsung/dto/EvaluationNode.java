package br.com.samsung.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.samsung.model.EvaluationCurrency;
import br.com.samsung.model.EvaluationDocs;
import br.com.samsung.model.EvaluationFront;
import br.com.samsung.model.EvaluationQuotation;

public class EvaluationNode extends SamsungEvaluationDto {

	public List<EvaluationFront> evlFront() throws JsonMappingException, JsonProcessingException {

		// Return json list from API/REST
		List<EvaluationCurrency> evaluationCurrency = super.evlCurrency();
		List<EvaluationDocs> evaluationDocs = super.evlDocs();
		List<EvaluationQuotation> evaluationQuotation = super.evlQuot();

		// Containing data from objects
		List<EvaluationFront> evaluationFront;

		// for to construct objects
		ArrayList<EvaluationFront> listFrontEvaluates = new ArrayList<EvaluationFront>();

		for (EvaluationDocs item : evaluationDocs) {

			/*
			 * Document Number Document Date Currency Code Currency Desc Document Value
			 * Value USD Value PEN Value BRL
			 */

			EvaluationFront evaluationFrontItem = new EvaluationFront();
			// int position = evaluationDocs.indexOf(item);

			evaluationFrontItem.setDocNumber(item.getDocumentNumber());
			evaluationFrontItem.setDocDate(item.getDocumentDate());
			evaluationFrontItem.setCurrencyCode(item.getCurrencyCode());
			evaluationFrontItem.setDocValue(item.getDocumentValue());

			for (EvaluationCurrency itemCurrency : evaluationCurrency) {

				if (item.getCurrencyCode().equals(itemCurrency.getCurrencyCode())) {
					evaluationFrontItem.setCurrencyDesc(itemCurrency.getCurrencyDesc());
				}
			}

			for (EvaluationQuotation itemQuot : evaluationQuotation) {

				if (item.getDocumentDate().equals(itemQuot.getDataHoraCotacao())) {

					if (item.getCurrencyCode().equals("USD")) {

						evaluationFrontItem.setValueUsd(String.valueOf(item.getDocumentValue()));
					}

					if (item.getCurrencyCode().equals("PEN")) {

						evaluationFrontItem.setValuePen(String.valueOf(item.getDocumentValue()));
					}

					if (item.getCurrencyCode().equals("BRL")) {

						evaluationFrontItem.setValueBrl(String.valueOf(item.getDocumentValue()));
					}
				}
			}

			listFrontEvaluates.add(evaluationFrontItem);

		} // Close FOR

		return listFrontEvaluates;
	}

	private String converQuote(String currencyCode, String value, String dateQuotation)
			throws JsonMappingException, JsonProcessingException {

		List<EvaluationQuotation> evaluationQuotation = super.evlQuot();

		return null;
	}

}
