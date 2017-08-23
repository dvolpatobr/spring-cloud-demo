package br.com.volpato.springcloud.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.volpato.springcloud.domain.Customer;
import br.com.volpato.springcloud.dto.CustomerDTO;
import br.com.volpato.springcloud.repository.CustomerRepository;

@RestController
@RequestMapping("/customerService")
public class CustomerController {

	private final CustomerRepository customerRepository;

	
	
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	//throw new MainframeDataNotFoundException("Erro mod de 2 para o usuario" + cliente.getNome(), "Erro salvar cliente");
			
			
	@GetMapping()
	public ResponseEntity<Iterable<Customer>> list( HttpServletResponse response) {
		Iterable<Customer> clientes = this.customerRepository.findAll();
		return new ResponseEntity<> (clientes,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> list( HttpServletResponse response, @PathVariable("id") Long id) {
		
		Customer customer = this.customerRepository.findOne(id);
		
		if(customer ==null){
			return new ResponseEntity<> (customer,HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<> (customer,HttpStatus.OK);
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Iterable<Customer>> list( HttpServletResponse response, @PathVariable("cpf") String cpf) {
		Iterable<Customer> customers = this.customerRepository.findByCpf(cpf);
		return new ResponseEntity<> (customers,HttpStatus.OK);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Void> addCutomer(HttpServletRequest req, @RequestBody  @Valid CustomerDTO customerDTO)
	{
		
		Customer customer = new Customer();
		customer.setAddress(customerDTO.getAddress());
		customer.setCpf(customerDTO.getCpf());
		customer.setName(customerDTO.getName());
		customer.setCards(customerDTO.getCards());
		
		customerRepository.save(customer);
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                ServletUriComponentsBuilder
                .fromContextPath(req)
                .path("customerService/{id}")
                .buildAndExpand(customer.getId()).toUri()
        );

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}
	
	
	
	
	
}