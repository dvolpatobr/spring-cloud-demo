package br.com.volpato.springcloud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Card {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
    @Length(min=6, max=30,message="O tamanho do embossingName deve ser entre {min} e {max} caracteres")
	private String embossingName;

    @NotNull
    @Length(min=15, max=16,message="O tamanho do cardNumber deve ser entre {min} e {max} caracteres")
	private String cardNumber;
	
    
	@ManyToOne(optional = true)
	private Customer customer;
    
    
	public Card(Long id,String embossingName,String cardNumber) {
		super();
		this.id = id;
		this.embossingName = embossingName;
		this.cardNumber = cardNumber;
	}

	public Card() {}
	
		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	

	public String getEmbossingName() {
		return embossingName;
	}

	public void setEmbossingName(String embossingName) {
		this.embossingName = embossingName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cardNumber=" + cardNumber + ", embossingName=" + embossingName + "]";
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
		Card other = (Card) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}