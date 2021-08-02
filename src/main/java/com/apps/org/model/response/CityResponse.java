package com.apps.org.model.response;

import java.util.ArrayList;

import com.apps.org.model.AddressModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class CityResponse extends ArrayList<AddressModel> {

	private static final long serialVersionUID = -5147823672448069479L;
	
}
