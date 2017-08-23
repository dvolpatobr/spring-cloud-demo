package br.com.volpato.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.volpato.springcloud.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
 
	 
}