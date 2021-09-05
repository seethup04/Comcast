package com.lcs.contoller;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lcs.exception.ListCannotbeEmptyException;
import com.lcs.exception.NotUniqueException;
import com.lcs.model.LCS;
import com.lcs.model.LcsDTO;
import com.lcs.model.ResponseDTO;
import com.lcs.service.LCSService;

@RestController
public class LCSController {

	@Autowired
	LCSService service;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path = "/lcs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> getLongestCommonSubstring(@RequestBody LcsDTO enteredValues)
			throws ListCannotbeEmptyException, NotUniqueException {
		ResponseDTO dto = new ResponseDTO();
		if (enteredValues.getListOfStrings().isEmpty()) {
			throw new ListCannotbeEmptyException();
		}

		if (!uniqueOrNot(enteredValues.getListOfStrings())) {
			throw new NotUniqueException();
		}
		if (service.getLongestCommonSubstring(enteredValues.getListOfStrings()).isEmpty()) {
			dto.setLcs(service.getLongestCommonSubstring(enteredValues.getListOfStrings()));
		}
		dto.setLcs(service.getLongestCommonSubstring(enteredValues.getListOfStrings()));
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	private Boolean uniqueOrNot(List<LCS> inputList) {

		LinkedHashSet<String> uniqueSet = new LinkedHashSet<>();
		for (LCS lcs : inputList) {
			if(lcs.getValue()==null) {
				lcs.setValue("");
			}
			uniqueSet.add(lcs.getValue());
		}
		if (uniqueSet.size() != inputList.size()) {
			return false;
		} else {
			return true;
		}

	}

}
