package br.com.rogerbleggi.k2.avaliacao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotNull
	@Column(name = "cpf", nullable = false)
	private String cpf;

	@NotNull
	@Column(name = "idade", nullable = false)
	private Integer idade;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", nullable = false)
	private EnumSexo sexo;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil", nullable = false)
	private EnumEstadoCivil estadoCivil;

	@NotNull
	@Column(name = "estado", nullable = false)
	private String estado;

	@NotNull
	@Column(name = "qtd_Dependentes", nullable = false)
	private Integer dependentes;

	@NotNull
	@Column(name = "renda", nullable = false)
	private Double renda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public EnumEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EnumEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

}
