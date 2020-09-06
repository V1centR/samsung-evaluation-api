package br.com.samsung.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.samsung.model.EvaluationCurrency;
import br.com.samsung.model.EvaluationDocs;
import br.com.samsung.model.EvaluationFront;
import br.com.samsung.model.EvaluationQuotation;

public class EvaluationNodeDto extends SamsungEvaluationApi {

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

						Double calcPen = convertQuote(itemQuot.getDataHoraCotacao(), item.getCurrencyCode(), "PEN")
								* Double.parseDouble(item.getDocumentValue());
						Double calcBrl = convertQuote(itemQuot.getDataHoraCotacao(), item.getCurrencyCode(), "BRL")
								* Double.parseDouble(item.getDocumentValue());

						evaluationFrontItem.setValueUsd(String.valueOf(item.getDocumentValue()));
						evaluationFrontItem.setValuePen(strValue(calcPen));
						evaluationFrontItem.setValueBrl(strValue(calcBrl));
					}

					if (item.getCurrencyCode().equals("PEN")) {

						Double calcUsd = convertQuote(itemQuot.getDataHoraCotacao(), item.getCurrencyCode(), "USD")
								* Double.parseDouble(item.getDocumentValue());
						Double calcBrl = convertQuote(itemQuot.getDataHoraCotacao(), item.getCurrencyCode(), "BRL")
								* Double.parseDouble(item.getDocumentValue());

						evaluationFrontItem.setValuePen(String.valueOf(item.getDocumentValue()));
						evaluationFrontItem.setValueUsd(strValue(calcUsd));
						evaluationFrontItem.setValueBrl(strValue(calcBrl));
					}

					if (item.getCurrencyCode().equals("BRL")) {

						Double calcUsd = convertQuote(itemQuot.getDataHoraCotacao(), item.getCurrencyCode(), "USD")
								* Double.parseDouble(item.getDocumentValue());
						Double calcPen = convertQuote(itemQuot.getDataHoraCotacao(), item.getCurrencyCode(), "PEN")
								* Double.parseDouble(item.getDocumentValue());

						evaluationFrontItem.setValueBrl(String.valueOf(item.getDocumentValue()));
						evaluationFrontItem.setValuePen(strValue(calcPen));
						evaluationFrontItem.setValueUsd(strValue(calcUsd));
					}
				}
			}

			listFrontEvaluates.add(evaluationFrontItem);

		} // Close FOR

		// System.out.println("Quotation" + convertQuote("2020-01-01", "BRL","USD"));
		convertQuote("2020-01-01", "BRL", "USD");

		return listFrontEvaluates;
	}

	// This function get quotation by date and return value
	private Double convertQuote(String dateQuotation, String currencyCodeFrom, String currencyCodeTo)
			throws JsonMappingException, JsonProcessingException {

		List<EvaluationQuotation> evaluationQuotation = super.evlQuot();
		String quotation = null;

		for (EvaluationQuotation evlQuote : evaluationQuotation) {

			if (evlQuote.getDataHoraCotacao().equals(dateQuotation)) {

				if (evlQuote.getDataHoraCotacao().equals(dateQuotation)
						&& evlQuote.getFromCurrencyCode().equals(currencyCodeFrom)
						&& evlQuote.getToCurrencyCode().equals(currencyCodeTo)) {

					// Set quotation available in date
					quotation = evlQuote.getCotacao();

					System.out.println("Convert OK " + evlQuote.getCotacao());

				} else {

					System.out.println("No convert available on this date!!");
				}

			}

		}

		return Double.parseDouble(quotation);
	}

	private String strValue(Double value) {

		return String.format("%.2f", value);
	}

}
