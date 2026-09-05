package com.thehecklers.sburrestdemo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlorRepository extends CrudRepository<Flor, String> {

	// Consulta derivada automaticamente pelo Spring Data,
	// sem precisar escrever SQL: busca flores por cor.
	List<Flor> findByCorIgnoreCase(String cor);

	// Busca flores pelo nome (contendo o texto, ignorando maiúsculas/minúsculas)
	List<Flor> findByNomeContainingIgnoreCase(String nome);
}
