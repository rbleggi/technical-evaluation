package br.com.rogerbleggi.calcard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotBlank
	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "idade")
	private Integer idade;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo")
	private EnumSexo sexo;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	private EnumEstadoCivil estadoCivil;

	@Column(name = "estado")
	private String estado;

	@NotNull
	@Column(name = "qtd_Dependentes", nullable = false)
	private Integer dependentes;

	@NotNull
	@Column(name = "renda", nullable = false)
	private Integer renda;

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

	public Integer getRenda() {
		return renda;
	}

	public void setRenda(Integer renda) {
		this.renda = renda;
	}

}
