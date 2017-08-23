package br.com.volpato.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.volpato.springcloud.domain.Item;

@Repository
//@RepositoryRestResource(collectionResourceRel = "itens",path = "itens")
public interface ItemRepository extends JpaRepository<Item, Long> {
 
}