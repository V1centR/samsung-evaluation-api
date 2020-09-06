package br.com.samsung.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.samsung.dto.EvaluationNodeDto;
import br.com.samsung.model.EvaluationFront;

@RestController
@RequestMapping(value = "/api/evaluation")
public class SamsungEvaluationController {

	// List<SamsungEvaluationDto>
	@CrossOrigin
	@GetMapping
	public List<EvaluationFront> evaluation() throws JsonMappingException, JsonProcessingException {

		List<EvaluationFront> evlCurrency = new EvaluationNodeDto().evlFront();

		return evlCurrency;
	}

}
