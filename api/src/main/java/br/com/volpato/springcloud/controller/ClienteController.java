package br.com.volpato.springcloud.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.volpato.springcloud.domain.Cliente;
import br.com.volpato.springcloud.dto.ClienteDTO;
import br.com.volpato.springcloud.exception.MainframeDataNotFoundException;
import br.com.volpato.springcloud.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteRepository clienteRepository;
	private final String CLIENTE_URI = "clientes/";

	
	
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void salvar(@RequestBody @Valid ClienteDTO clienteDTO) throws Exception{
		Cliente cliente = new Cliente();
		cliente.setNome(clienteDTO.getNome());
		cliente.setEndereco(clienteDTO.getEndereco());
		clienteRepository.save(cliente);
		
		if(cliente.getId() %2 == 0){
			throw new MainframeDataNotFoundException("Erro mod de 2 para o usuario" + cliente.getNome(), "Erro salvar cliente");
		}
		
		
	}

	@GetMapping()
	public Iterable<Cliente> list( HttpServletResponse response) {
		
		Iterable<Cliente> clientes = this.clienteRepository.findAll();
		
		return clientes;
		
	}
	
	

	@GetMapping("/{id}")
	public Cliente view(@PathVariable("id") Long id) {
		return this.clienteRepository.findOne(id);
	}
	

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Cliente cliente,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(CLIENTE_URI + "form","formErrors",result.getAllErrors()); }
		cliente = this.clienteRepository.save(cliente);
		redirect.addFlashAttribute("globalMessage","Cliente gravado com sucesso");
		return new ModelAndView("redirect:/" + CLIENTE_URI + "{cliente.id}","cliente.id",cliente.getId());
	}

	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
		this.clienteRepository.delete(id);
		Iterable<Cliente> clientes = this.clienteRepository.findAll();
		
		ModelAndView mv = new ModelAndView(CLIENTE_URI + "list","clientes",clientes);
		mv.addObject("globalMessage","Cliente removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Cliente cliente) {
		return new ModelAndView(CLIENTE_URI + "form","cliente",cliente);
	}

}