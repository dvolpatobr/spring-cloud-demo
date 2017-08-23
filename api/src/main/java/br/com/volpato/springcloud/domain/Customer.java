package br.com.volpato.springcloud.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
    @Length(min=2, max=30,message="O tamanho do nome deve ser entre {min} e {max} caracteres")
	private String name;

    @NotNull
    @Length(min=2, max=300,message="O tamanho do endereço deve ser entre {min} e {max} caracteres")
	private String address;

    
    @NotNull
    @Length(min=11, max=11,message="O tamanho do CPF deve ser de {max} caracteres")
	private String cpf;
    
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<Card> cards;

	public Customer(Long id,String name,String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Customer() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void addCard(Card card) {
		if (this.cards==null) cards = new ArrayList<Card>();
		cards.add(card);
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	

	public List<Card> getCards() {
		return cards;
	}
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
		

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( (id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}