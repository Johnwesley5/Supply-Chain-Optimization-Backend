package com.SupplyChainOptimization.supplier_collaboration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SupplyChainOptimization.supplier_collaboration.model.Supplier;
import com.SupplyChainOptimization.supplier_collaboration.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public Optional<Supplier> updateSupplier(Long id, Supplier supplierDetails) {
        return supplierRepository.findById(id).map(supplier -> {
            supplier.setName(supplierDetails.getName());
            supplier.setContact(supplierDetails.getContact());
            supplier.setEmail(supplierDetails.getEmail());
            supplier.setAddress(supplierDetails.getAddress());
            return supplierRepository.save(supplier);
        });
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
