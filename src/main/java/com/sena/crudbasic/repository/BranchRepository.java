package com.sena.crudbasic.repository;

import com.sena.crudbasic.model.Branch;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
    
}