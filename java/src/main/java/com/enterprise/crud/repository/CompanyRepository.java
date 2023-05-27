package com.enterprise.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.crud.dtos.CompanyDTO;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDTO, Long>{

	

}
