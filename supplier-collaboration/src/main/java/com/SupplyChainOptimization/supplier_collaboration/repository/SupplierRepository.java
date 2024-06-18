package com.SupplyChainOptimization.supplier_collaboration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SupplyChainOptimization.supplier_collaboration.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
