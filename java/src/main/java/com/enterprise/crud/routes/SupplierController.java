package com.enterprise.crud.routes;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.enterprise.crud.dtos.SupplierDTO;
import com.enterprise.crud.repository.SupplierRepository;

@RestController
@RequestMapping("/")
public class SupplierController {
	
	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	SupplierRepository supplierRepository;
	
	//CRUD DA ENTIDADE SUPPLIER
	@GetMapping("/newsupplier/all")
    public Iterable<SupplierDTO> getAll(){
        logger.info("Trazendo todas as Companys");
        return supplierRepository.findAll();
    }
	
	@PostMapping("/newsupplier")
    public SupplierDTO cadastroCompany(@RequestBody SupplierDTO supplierDTO){
        return supplierRepository.save(supplierDTO);
    }
	
	@PutMapping("/newsupplier/{id}")
    public ResponseEntity<SupplierDTO> updateCompany(@PathVariable(value = "id") Long id,
		@Validated @RequestBody SupplierDTO newData){
		SupplierDTO supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new ResourceAccessException("Empresa não encontrada de id :: "+ id));
		
		supplier.setName(newData.getName());
		supplier.setCep(newData.getCep());
		supplier.setCnpj_cpf(newData.getCnpj_cpf());
		final SupplierDTO updatedCompany = supplierRepository.save(supplier);
        return ResponseEntity.ok(updatedCompany);
    }
	
	@DeleteMapping("/newsupplier/{id}")
    public Map<String, Boolean> updateCompany(@PathVariable(value = "id") Long id) {
		
		SupplierDTO supplier = supplierRepository.findById(id)
				.orElseThrow(() -> new ResourceAccessException("Empresa não encontrada de id :: "+ id));
		
		supplierRepository.delete(supplier);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
        return response;
    }

}
