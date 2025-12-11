package com.sena.crudbasic.repository;

import com.sena.crudbasic.model.DetailBuyProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailBuyProviderRepository extends JpaRepository<DetailBuyProvider, Integer> {
}
