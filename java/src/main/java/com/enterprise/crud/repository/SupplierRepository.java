package com.enterprise.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.crud.dtos.SupplierDTO;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierDTO, Long> {

}
