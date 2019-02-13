package br.com.beblue.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CashBack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String genero;

	private int diaDaSemana;

	private int porcentagem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(int diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public int getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}

}
