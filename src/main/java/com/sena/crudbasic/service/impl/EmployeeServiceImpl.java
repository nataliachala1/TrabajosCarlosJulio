package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.EmployeeCreateDto;
import com.sena.crudbasic.dto.response.EmployeeResponseDto;
import com.sena.crudbasic.dto.response.BranchResponseDto;
import com.sena.crudbasic.model.Employee;
import com.sena.crudbasic.model.Branch;
import com.sena.crudbasic.repository.EmployeeRepository;
import com.sena.crudbasic.repository.BranchRepository;
import com.sena.crudbasic.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl
        extends GenericServiceImpl<Employee, EmployeeCreateDto, EmployeeResponseDto, Integer>
        implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BranchRepository branchRepository;

    @Override
    protected Employee mapToEntity(EmployeeCreateDto dto) {

        Branch branch = branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        return Employee.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .branch(branch)
                .build();
    }

    @Override
    protected void updateEntity(Employee entity, EmployeeCreateDto dto) {

        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());

        Branch branch = branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        entity.setBranch(branch);
    }

    @Override
    protected EmployeeResponseDto mapToResponse(Employee entity) {
        return EmployeeResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .branch(entity.getBranch() != null ?
                        BranchResponseDto.builder()
                                .id(entity.getBranch().getId())
                                .name(entity.getBranch().getName())
                                .build() : null)
                .build();
    }

    @Override
    protected JpaRepository<Employee, Integer> getRepository() {
        return employeeRepository;
    }

    @Override
    protected String getEntityName() {
        return "Empleado";
    }
}
