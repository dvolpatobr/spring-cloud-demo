package br.com.volpato.springcloud.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.volpato.springcloud.domain.Card;


public class CustomerDTO {

	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String cpf;
	
	private String address;
	
	private List<Card> cards;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	

	
}
