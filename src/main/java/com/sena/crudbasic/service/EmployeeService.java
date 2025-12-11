package com.sena.crudbasic.service;

import com.sena.crudbasic.dto.request.EmployeeCreateDto;
import com.sena.crudbasic.dto.response.EmployeeResponseDto;

public interface EmployeeService extends GenericService<EmployeeCreateDto, EmployeeResponseDto, Integer> {
}
