package com.lcs.model;

import java.util.List;
import javax.validation.constraints.NotEmpty;

public class LcsDTO {


	public List<LCS> setOfStrings;

	public List<LCS> getListOfStrings() {
		return setOfStrings;
	}

	public void setListOfStrings(List<LCS> setOfStrings) {
		this.setOfStrings = setOfStrings;
	}
	
	
}
