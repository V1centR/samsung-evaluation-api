package br.com.samsung.dto;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.samsung.model.EvaluationCurrency;
import br.com.samsung.model.EvaluationDocs;
import br.com.samsung.model.EvaluationQuotation;

public class SamsungEvaluationDto {

	private String endPoint = "https://cellolatam.cellologistics.com.br/sds-devs-evaluation/evaluation";
	
	public List<EvaluationDocs> evlDocs() throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(endPoint+"/docs", String.class);

		List<EvaluationDocs> evlDocs = objectMapper.readValue(result, new TypeReference<List<EvaluationDocs>>() {
		});

		//System.out.println("DATA API Received::: " + evlDocs.toString());

		return evlDocs;
	}
	
	public List<EvaluationCurrency> evlCurrency() throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(endPoint+"/currency", String.class);

		List<EvaluationCurrency> evlCurrency = objectMapper.readValue(result, new TypeReference<List<EvaluationCurrency>>() {
		});

		//System.out.println("DATA API::: " + evlCurrency.toString());

		return evlCurrency;
	}
	
	public List<EvaluationQuotation> evlQuot() throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(endPoint+"/quotation", String.class);

		List<EvaluationQuotation> evlQuotation = objectMapper.readValue(result, new TypeReference<List<EvaluationQuotation>>() {
		});

		//System.out.println("DATA API::: " + evlQuotation.toString());

		return evlQuotation;
	}

}
