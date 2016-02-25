package model.domain;

import java.io.Serializable;

public class Cliente implements Serializable {
	/**
	 * Desenvolvedor - Marco Antonio Fortunato 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String nome;
	private String email;
	
	public Cliente(Integer codigo, String nome, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
