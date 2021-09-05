package com.lcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcs.model.LCS;

@Service
public class LCSService {

	public List<LCS> getLongestCommonSubstring(List<LCS> lcsString) {
		LCS lcs = new LCS();
		String lcsStr = findLongestCommonSubstring(lcsString);
		List<LCS> newList = new ArrayList<LCS>();
		if (lcsStr.isEmpty() || lcsStr == "") {
			lcs.setValue("No LCS Found for given string");
			newList.add(lcs);
		} else {
			lcs.setValue(lcsStr);
			newList.add(lcs);
		}

		return newList;
	}

	private String findLongestCommonSubstring(List<LCS> stringList) {
		int sizeOfList = stringList.size();

		// Take first word from list as reference
		String firstWord = stringList.get(0).getValue();
		int len = firstWord.length();

		String resultantLCS = "";

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {

				// generating all possible substrings
				// of our reference string arr[0] i.e s
				String stem = firstWord.substring(i, j);
				int k = 1;
				for (k = 1; k < sizeOfList; k++)

					// Check if the generated stem is
					// common to all words
					if (!stringList.get(k).getValue().contains(stem))
						break;

				// If current substring is present in
				// all strings and its length is greater
				// than current result
				if (k == sizeOfList && resultantLCS.length() < stem.length())
					resultantLCS = stem;
			}
		}

		return resultantLCS;
	}
}
