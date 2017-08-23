package br.com.volpato.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.volpato.springcloud.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
 
	 
}