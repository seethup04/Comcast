package com.lcs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcs.contoller.LCSController;
import com.lcs.model.LCS;
import com.lcs.model.LcsDTO;
import com.lcs.model.ResponseDTO;
import com.lcs.service.LCSService;

@WebMvcTest(controllers = LCSController.class)
public class LCSControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	LCSService service;

	private String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void getLCSTest() throws Exception {
		LCS lcs = new LCS("comcast");
		LCS lcs1 = new LCS("comc");
		List<LCS> listOfStrings = new ArrayList<LCS>();
		listOfStrings.add(lcs);
		listOfStrings.add(lcs1);
		LcsDTO lcsDTO = new LcsDTO();
		lcsDTO.setListOfStrings(listOfStrings);

		String json = mapToJson(lcsDTO);

		MvcResult mvcRes = mockMvc.perform(post("/lcs").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();

		int status = mvcRes.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcRes.getResponse().getContentAsString();
		System.out.println(content);
	}

	@Test
	public void unformattedJSON() throws Exception {
		MvcResult mvc1 = mockMvc.perform(post("/lcs").contentType(MediaType.APPLICATION_XML)).andReturn();

		int status = mvc1.getResponse().getStatus();
		System.out.println(status);
		assertEquals(415, status);
		String content = mvc1.getResponse().getContentAsString();
		assertTrue(content.contains("The accepted format is JSON"));
	}

}
