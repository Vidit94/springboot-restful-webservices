package com.example.demo.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/static-filtering")
	public SomeBean reteriveSomeBean() {
		return new SomeBean("Value1","Value2","Value3","Value4","Value5","Value6","Value7");
	}
	
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue reteriveSomeBean1() {
		SomeBean someBean= new SomeBean("Value1","Value2","Value3","Value4","Value5","Value6","Value7");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanDynamicFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		return mapping;
	}
}
