package com.enterprise.crud.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierDTO {
	
	private long id;
	private String name;
	private String email;
	private String cnpj_cpf;
	private String cep;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "cnpj_cpf")
	public String getCnpj_cpf() {
		return cnpj_cpf;
	}
	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}
	
	@Column(name = "cep")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String ToString() {
		return  "id: "+id+ '\'' +
				"name: "+name +'\'' +
				"email: "+email +'\'' +
				"cnpj: "+cnpj_cpf+ '\'' +
				"cep: "+cep;		
	}

}
