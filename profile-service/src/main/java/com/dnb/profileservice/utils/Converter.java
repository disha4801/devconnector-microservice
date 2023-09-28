package com.dnb.profileservice.utils;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Convert;


public class Converter {
	public List<String> stringToArray(String commaSeparated) {
		String [] arrayStr = commaSeparated.split("\\s*,\\s*");
		List<String>ans=Arrays.asList(arrayStr);
		return ans;
	}
	
//	public String arrayToString(String[] array) {
//		String str = String.join(",", array);
//		return str;
//	}
}
