package com.sena.crudbasic.service;

import com.sena.crudbasic.dto.request.CustomerCreateDto;
import com.sena.crudbasic.dto.response.CustomerResponseDto;

public interface CustomerService extends GenericService<CustomerCreateDto, CustomerResponseDto, Integer> {
}
