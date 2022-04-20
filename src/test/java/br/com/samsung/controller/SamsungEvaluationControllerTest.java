package br.com.samsung.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SamsungEvaluationController.class)
public class SamsungEvaluationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test     
	public void testResponseController() throws Exception {
		
		mockMvc.perform(get("/api/evaluation")
			    .contentType("application/json"))
			    .andExpect(status().isOk());
	}

}
