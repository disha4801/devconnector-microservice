package com.dnb.profileservice.utils;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SkillsConverter implements AttributeConverter<List<String>, String>  {

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {

		return String.join(",", attribute);
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		return Arrays.asList(dbData.split(","));
	}

}
