package com.apps.org.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

import com.apps.org.entity.Address;
import com.apps.org.entity.City;
import com.apps.org.entity.Country;
import com.apps.org.entity.Employee;
import com.apps.org.entity.State;
import com.apps.org.model.AddressModel;
import com.apps.org.model.EmployeeIOModel;
import com.apps.org.model.Errors;
import com.apps.org.model.response.EmployeeResponse;
import com.apps.org.model.response.ErrorResponse;
import com.apps.org.model.response.PageResponse;

public class EmployeeUtils {

	public static Employee populateEmployeeEntityFromEmployeeRequest(EmployeeIOModel employeeRequest) {
		
		Employee employee = new  Employee();
		employee.setEmpName(employeeRequest.getEmpName());
		employee.setBirthDate(DateUtils.convertStringToUtilDate(employeeRequest.getBirthDate()));
		employee.setHireDate(DateUtils.convertStringToUtilDate(employeeRequest.getHireDate()));
		employee.setGender(employeeRequest.getGender());
		employee.setDesignation(employeeRequest.getDesignation());
		employee.setIsActive((employeeRequest.getIsActive().equals(AppConstants.Y.value)));
		employee.setCreatedBy(employeeRequest.getCreatedBy());
		employee.setCreatedOn(DateUtils.convertStringToUtilDate(employeeRequest.getCretedOn()));
		employee.setUpdatedBy(employeeRequest.getUpdatedBy());
		employee.setUpdatedOn(DateUtils.convertStringToUtilDate(employeeRequest.getUpdatedOn()));
		employee.setAddressList(populateAddressEntityFromEmployeeRequest(employeeRequest));
		return employee;
	}
	
	public static Set<Address> populateAddressEntityFromEmployeeRequest(EmployeeIOModel employeeRequest) {
		Set<Address> addressList = new HashSet<Address>();
		employeeRequest.getAddress().forEach(addressReq -> {
			Address address = new Address();
			address.setAddressLine(addressReq.getAddressLine());
			address.setHouseNumber(addressReq.getHouseNumber());
			address.setStreetName(addressReq.getStreetName());
			address.setLat(addressReq.getLat());
			address.setLon(addressReq.getLon());
			address.setMobile(addressReq.getMobbile());
			address.setCountry(populateCountryEntityFromAddressModel(addressReq));
			address.setState(populateStateEntityFromAddressModel(addressReq));
			address.setCity(populateCityEntityFromAddressModel(addressReq));
			addressList.add(address);
			
		});
		return addressList;
	}
	
	public static Country populateCountryEntityFromAddressModel(AddressModel addressReq) {
		Country country = new Country();
		country.setCountryName(addressReq.getCountry());
		country.setCountryCode(addressReq.getCountryCode());
		return country;
	}
	
	public static State populateStateEntityFromAddressModel(AddressModel addressReq) {
		State state = new State();
		state.setStateName(addressReq.getState());
		return state;
	}
	
	public static City populateCityEntityFromAddressModel(AddressModel addressReq) {
		City city = new City();
		city.setCityName(addressReq.getCity());
		city.setZipCode(addressReq.getZipCode());
		return city;
	}
	
	/*
	 * public static Country
	 * populateCountryEntityListFromEmployeeRequest(AddressModel addressReq) {
	 * Country country = new Country();
	 * country.setCountryName(addressReq.getCountry());
	 * country.setCountryCode(addressReq.getCountryCode()); return country; }
	 * 
	 * public static Set<State>
	 * populateStateEntityListFromEmployeeRequest(EmployeeIOModel employeeRequest) {
	 * Set<State> stateList = new HashSet<State>(); State state = new State();
	 * stateList.add(state); return stateList; }
	 * 
	 * public static Set<City>
	 * populateCityEntityListFromEmployeeRequest(EmployeeIOModel employeeRequest) {
	 * Set<City> cityList = new HashSet<City>(); City city = new City();
	 * cityList.add(city); return cityList; }
	 */

	public static PageResponse populateResponse(List<Employee> employees) {
		PageResponse pageResponse = new PageResponse();
		EmployeeResponse employeeResponse = new EmployeeResponse();
		for (Employee employee : employees) {
			EmployeeIOModel employeeIOModel = new EmployeeIOModel(true);
			employeeIOModel.setEmpId(employee.getEmpId());
			employeeIOModel.setEmpName(employee.getEmpName());
			employeeIOModel.setDesignation(employee.getDesignation());
			employeeIOModel.setGender(employee.getGender());
			employeeResponse.add(employeeIOModel);
		}
		pageResponse.setEmployeeResponse(employeeResponse);
		return pageResponse;
	}

	public static PageResponse populateHeaders(PageResponse pageResponse, Page<Employee> employeePage ) {
		if (null == pageResponse) pageResponse = new PageResponse();
		pageResponse.setCurrentPage(String.valueOf(employeePage.getNumber()));
		pageResponse.setTotalElements(String.valueOf(employeePage.getTotalElements()));
		pageResponse.setTotalElements(String.valueOf(employeePage.getTotalPages()));
		return pageResponse;

	}

	public static EmployeeIOModel populateEmployeeResponseModel(EmployeeIOModel employeeRequest) {
		EmployeeIOModel employeeIOModel = new EmployeeIOModel(true);
		employeeIOModel.setEmpId(employeeRequest.getEmpId());
		employeeIOModel.setEmpName(employeeRequest.getEmpName());
		employeeIOModel.setBirthDate(employeeRequest.getBirthDate());
		employeeIOModel.setGender(employeeRequest.getGender());
		return employeeIOModel;
	}

	public static EmployeeResponse populateEmployeeResponse(List<Employee> employees) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employees.forEach(employee -> {
			EmployeeIOModel employeeIOModel = new EmployeeIOModel();
			employeeIOModel.setEmpId(employee.getEmpId());
			employeeIOModel.setEmpName(employee.getEmpName());
			employeeIOModel.setBirthDate(DateUtils.convertUtilDateToString(employee.getBirthDate()));
			employeeIOModel.setGender(employee.getGender());
			employeeResponse.add(employeeIOModel);
		});
		return employeeResponse;
	}

	public static Errors populateErrorResponse(
			EmployeeIOModel employeeresponse, Integer errorCode,
			String errorMessage, Exception ex) {

		Errors errors = new Errors();
		StringBuffer buffer = new StringBuffer(errorMessage);

		if (null != employeeresponse) {
			EmployeeIOModel modelResponse = populateEmployeeResponseModel(employeeresponse);
			errors.setEmployeeResponse(modelResponse);
		}
		if (null != ex) {
			buffer.append(ex.getMessage());
			errors.setCause(ex.getCause());
		}
		errors.setErrorCode(errorCode);
		errors.setMessage(buffer.toString());
		
		return errors;
	}

	public static HttpHeaders populateHttpHeaders(PageResponse response) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Current-Page", response.getCurrentPage());
		headers.add("X-Total-Elements", response.getTotalElements());
		headers.add("X-Total-Pages", response.getTotalPages());
		return headers;
	}

	public static boolean validateAddEmployeeRequest(EmployeeIOModel requestObj, ErrorResponse errorResponse) {
		
		StringBuffer errorData = new StringBuffer();

		if (StringUtils.isBlank(requestObj.getEmpName())) {
			errorData.append("Employee Name, ");
		}
		if (StringUtils.isBlank(requestObj.getBirthDate())) {
			errorData.append("Birth Date, ");
		}
		if (StringUtils.isBlank(requestObj.getGender())) {
			errorData.append("Gender, ");
		}
		if (StringUtils.isBlank(requestObj.getDesignation())) {
			errorData.append("Designation, ");
		}
		if (StringUtils.isBlank(requestObj.getHireDate())) {
			errorData.append("Hire Date, ");
		}
		if (CollectionUtils.isEmpty(requestObj.getAddress())) {
			errorData.append("Address, ");
		}
		requestObj.getAddress().forEach(address -> {
			if (StringUtils.isBlank(address.getAddressLine())) {
				errorData.append("Address Line, ");
			}
			if (StringUtils.isBlank(address.getHouseNumber())) {
				errorData.append("HouseNumber, ");
			}
			if (StringUtils.isBlank(address.getStreetName())) {
				errorData.append("StreetName, ");
			}
			if (StringUtils.isBlank(address.getCountry())) {
				errorData.append("Country, ");
			}
			if (StringUtils.isBlank(address.getState())) {
				errorData.append("State, ");
			}
			if (StringUtils.isBlank(address.getCity())) {
				errorData.append("City, ");
			}
			if (null ==address.getCountryCode()) {
				errorData.append("CountryCode, ");
			}
			if (address.getCountryCode() < 0) {
				errorData.append("CountryCode<0, ");
			}
			if (null == address.getMobbile()) {
				errorData.append("MobileNumber, ");
			}
			if (address.getMobbile() < 0) {
				errorData.append("MobileNumber<0, ");
			}
			if (null == address.getZipCode()) {
				errorData.append("ZipCode, ");
			}
			if (address.getZipCode() < 0) {
				errorData.append("ZipCode<0, ");
			}
		});
		
		if(StringUtils.isNotBlank(errorData)) {
			Errors errors = new Errors();
			errors.setErrorCode(AppElements.MISSING_DATA_EXCEPTION.code);
			errors.setMessage(AppElements.MISSING_DATA_EXCEPTION.message + cleanUpCommas(errorData.toString()));
			errorResponse.add(errors);
			return false;
		}
		
		return true;
	}
	
	public static String cleanUpCommas(String string) {
		
        return string.replaceAll(", $", ".");
    }

}
