package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.SaleCreateDto;
import com.sena.crudbasic.dto.response.SaleResponseDto;
import com.sena.crudbasic.dto.response.CustomerResponseDto;
import com.sena.crudbasic.dto.response.EmployeeResponseDto;
import com.sena.crudbasic.model.Customer;
import com.sena.crudbasic.model.Employee;
import com.sena.crudbasic.model.Sale;
import com.sena.crudbasic.repository.CustomerRepository;
import com.sena.crudbasic.repository.EmployeeRepository;
import com.sena.crudbasic.repository.SaleRepository;
import com.sena.crudbasic.service.SaleService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SaleServiceImpl
        extends GenericServiceImpl<Sale, SaleCreateDto, SaleResponseDto, Integer>
        implements SaleService {

    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    protected Sale mapToEntity(SaleCreateDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        return Sale.builder()
                .name(dto.getName())
                .customer(customer)
                .employee(employee)
                .build();
    }

    @Override
    protected void updateEntity(Sale entity, SaleCreateDto dto) {
        entity.setName(dto.getName());

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        entity.setCustomer(customer);
        entity.setEmployee(employee);
    }

    @Override
    protected SaleResponseDto mapToResponse(Sale entity) {
        return SaleResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .customer(entity.getCustomer() != null ?
                        CustomerResponseDto.builder()
                                .id(entity.getCustomer().getId())
                                .name(entity.getCustomer().getName())
                                .lastName(entity.getCustomer().getLastName())
                                .build()
                        : null)
                .employee(entity.getEmployee() != null ?
                        EmployeeResponseDto.builder()
                                .id(entity.getEmployee().getId())
                                .name(entity.getEmployee().getName())
                                .lastName(entity.getEmployee().getLastName())
                                .build()
                        : null)
                .build();
    }

    @Override
    protected JpaRepository<Sale, Integer> getRepository() {
        return saleRepository;
    }

    @Override
    protected String getEntityName() {
        return "Venta";
    }
}
