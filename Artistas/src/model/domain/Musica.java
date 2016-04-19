package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tb_musicas")
public class Musica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codMusica")
	private Integer codMusica;

	@Column(name = "nome")
	private String nome;

	@Column(name = "duracao")
	private Integer duracao;

	@ManyToOne
	@JoinColumn(name = "album", referencedColumnName = "codAlbum")
	private Album album;

	public Musica() {
	}

	/**
	 * @return the codMusica
	 */
	public Integer getCodMusica() {
		return codMusica;
	}

	/**
	 * @param codMusica
	 *            the codMusica to set
	 */
	public void setCodMusica(Integer codMusica) {
		this.codMusica = codMusica;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the duracao
	 */
	public Integer getDuracao() {
		return duracao;
	}

	/**
	 * @param duracao
	 *            the duracao to set
	 */
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((codMusica == null) ? 0 : codMusica.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Musica other = (Musica) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (codMusica == null) {
			if (other.codMusica != null)
				return false;
		} else if (!codMusica.equals(other.codMusica))
			return false;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
