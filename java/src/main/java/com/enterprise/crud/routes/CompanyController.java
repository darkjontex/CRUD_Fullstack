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

import com.enterprise.crud.dtos.CompanyDTO;
import com.enterprise.crud.repository.CompanyRepository;

@RestController
@RequestMapping("/")
public class CompanyController {
		
		Logger logger = LoggerFactory.getLogger(CompanyController.class);

		@Autowired
		CompanyRepository companyRepository;
		
		//CRUD DA ENTIDADE COMPANY
		@GetMapping("/newcompany/all")
	    public Iterable<CompanyDTO> getAll(){
	        logger.info("Trazendo todas as Companys");
	        return companyRepository.findAll();
	    }
		
		@PostMapping("/newcompany")
	    public CompanyDTO cadastroCompany(@RequestBody CompanyDTO companyDTO){
	        return companyRepository.save(companyDTO);
	    }
		
		@PutMapping("/newcompany/{id}")
	    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable(value = "id") Long id,
			@Validated @RequestBody CompanyDTO newData){
			CompanyDTO company = companyRepository.findById(id)
					.orElseThrow(() -> new ResourceAccessException("Empresa não encontrada de id :: "+ id));
			
			company.setName(newData.getName());
			company.setCep(newData.getCep());
			company.setCnpj(newData.getCnpj());
			final CompanyDTO updatedCompany = companyRepository.save(company);
	        return ResponseEntity.ok(updatedCompany);
	    }
		
		@DeleteMapping("/newcompany/{id}")
	    public Map<String, Boolean> updateCompany(@PathVariable(value = "id") Long id) {
			
			CompanyDTO company = companyRepository.findById(id)
					.orElseThrow(() -> new ResourceAccessException("Empresa não encontrada de id :: "+ id));
			
			companyRepository.delete(company);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
	        return response;
	    }
		
		//CRUD DA ENTIDADE SUPPLIER
		
		@GetMapping
	    public String teste(){
	        var teste = "Eu sou um teste";
	        logger.info("Isso é um teste de log INFO");
	        return teste;
	    }
		
		 @GetMapping("/teste2")
		 public String teste2(){
		        var teste = "Eu sou um teste2";
		        logger.warn("Isso é um teste de log WARN");
		        return teste;
		    }

	
}
