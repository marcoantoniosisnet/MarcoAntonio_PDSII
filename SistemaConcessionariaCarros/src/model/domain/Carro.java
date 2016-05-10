package model.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="tb_carro")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_CARRO")
	private Integer codCarro;
	
	@Column(name = "NM_CARRO")
	private String nome;
	
	@Column(name = "DT_ANO")
	private Integer ano;
	
	@Column(name = "PRECO_BASICO")
	private BigDecimal precoBasico;
	
	@ManyToOne
	@JoinColumn(name = "marca", referencedColumnName = "CD_MARCA")
	private Marca marca;
	
	@OneToMany(mappedBy="carro", fetch = FetchType.EAGER)
	private List<Acessorio> acessorios;
	
	public Carro(){
		
	}

	public Integer getCodCarro() {
		return codCarro;
	}

	public void setCodCarro(Integer codCarro) {
		this.codCarro = codCarro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getPrecoBasico() {
		return precoBasico;
	}

	public void setPrecoBasico(BigDecimal precoBasico) {
		this.precoBasico = precoBasico;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@XmlTransient
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCarro == null) ? 0 : codCarro.hashCode());
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
		Carro other = (Carro) obj;
		if (codCarro == null) {
			if (other.codCarro != null)
				return false;
		} else if (!codCarro.equals(other.codCarro))
			return false;
		return true;
	}
	
	
	
	
}
