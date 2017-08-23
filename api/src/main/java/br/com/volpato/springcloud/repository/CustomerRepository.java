package br.com.volpato.springcloud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.volpato.springcloud.domain.Customer;

 

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Iterable<Customer> findByName(String name);
	
	Iterable<Customer> findByCpf(String cpf);

	Page<Customer> findByNameContainingAllIgnoringCase(@Param("name") String name,Pageable pageable);

	Customer findByNameAllIgnoringCase(@Param("name") String name);

}