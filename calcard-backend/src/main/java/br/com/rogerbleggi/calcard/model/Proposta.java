package br.com.rogerbleggi.calcard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "proposta")
public class Proposta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
    @JoinColumn(name = "clienteId")
	private Cliente cliente;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "analise", nullable = false)
	private EnumAnalise analise;

	@NotBlank
	@Column(name = "limite", nullable = false)
	private String limite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EnumAnalise getAnalise() {
		return analise;
	}

	public void setAnalise(EnumAnalise analise) {
		this.analise = analise;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

}
