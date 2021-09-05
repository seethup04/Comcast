package com.lcs.model;

import java.util.List;

import org.springframework.stereotype.Component;

public class ResponseDTO {

	public List<LCS> lcs;

	public List<LCS> getLcs() {
		return lcs;
	}

	public void setLcs(List<LCS> lcs) {
		this.lcs = lcs;
	}
	
	
}
