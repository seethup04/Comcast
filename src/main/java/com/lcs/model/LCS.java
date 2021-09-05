package com.lcs.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LCS {
	
	public LCS() {
		
	}
	
	public LCS(String value) {
		this.value=value;
	}
	public String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
