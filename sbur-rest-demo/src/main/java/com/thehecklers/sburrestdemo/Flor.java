package com.thehecklers.sburrestdemo;


import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class Flor {

	@Id
	private final String id;

	@NotBlank(message = "O nome da flor é obrigatório")
	private String nome;

	private String cor;

	@NotNull(message = "O preço é obrigatório")
	@PositiveOrZero(message = "O preço não pode ser negativo")
	private BigDecimal preco;

	@NotNull(message = "O estoque é obrigatório")
	@PositiveOrZero(message = "O estoque não pode ser negativo")
	private Integer estoque;

	public Flor(String id, String nome, String cor, BigDecimal preco, Integer estoque) {
		this.id = id;
		this.nome = nome;
		this.cor = cor;
		this.preco = preco;
		this.estoque = estoque;
	}

	public Flor(String nome, String cor, BigDecimal preco, Integer estoque) {
		this(UUID.randomUUID().toString(), nome, cor, preco, estoque);
	}

	// Construtor sem argumentos exigido pelo JPA/Hibernate
	protected Flor() {
		this.id = null;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
}
