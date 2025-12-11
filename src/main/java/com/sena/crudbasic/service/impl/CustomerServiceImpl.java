package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.CustomerCreateDto;
import com.sena.crudbasic.dto.response.CustomerResponseDto;
import com.sena.crudbasic.model.Customer;
import com.sena.crudbasic.repository.CustomerRepository;
import com.sena.crudbasic.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl
        extends GenericServiceImpl<Customer, CustomerCreateDto, CustomerResponseDto, Integer>
        implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    protected Customer mapToEntity(CustomerCreateDto dto) {
        return Customer.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .build();
    }

    @Override
    protected void updateEntity(Customer entity, CustomerCreateDto dto) {
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
    }

    @Override
    protected CustomerResponseDto mapToResponse(Customer entity) {
        return CustomerResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .build();
    }

    @Override
    protected JpaRepository<Customer, Integer> getRepository() {
        return customerRepository;
    }

    @Override
    protected String getEntityName() {
        return "Cliente";
    }
}
