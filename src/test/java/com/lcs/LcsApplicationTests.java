package com.lcs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcs.model.LCS;
import com.lcs.service.LCSService;

@SpringBootTest
public class LcsApplicationTests {
	
	@InjectMocks
	LCSService lcsService;

	@Test
	public void testServiceClassPositiveScenario() {
		
		LCS str1 = new LCS("comcast");
		LCS str2 = new LCS("comcas");
		LCS str3 = new LCS("broadcast");
		
		List<LCS> strList= new ArrayList<LCS>();
		strList.add(str1);
		strList.add(str2);
		strList.add(str3);
		
		List<LCS>lcsList=lcsService.getLongestCommonSubstring(strList);
		
		assertEquals("cas", lcsList.get(0).getValue());
		
	}
	@Test
	public void testServiceClassNegativeScenario() {
		LCS str1 = new LCS("c");
		LCS str2 = new LCS("o");
		LCS str3 = new LCS("a");
		
		List<LCS> strList= new ArrayList<LCS>();
		strList.add(str1);
		strList.add(str2);
		strList.add(str3);
		
		List<LCS>lcsList=lcsService.getLongestCommonSubstring(strList);
		assertEquals("No LCS Found for given string", lcsList.get(0).getValue());
		
	}
	
	

}
