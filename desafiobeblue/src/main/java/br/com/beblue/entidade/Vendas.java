package br.com.beblue.entidade;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataVenda;

	@ManyToMany
	private List<Discos> discos;

	private BigDecimal valorTotal;

	private BigDecimal totalCashBack;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Discos> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Discos> discos) {
		this.discos = discos;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getTotalCashBack() {
		return totalCashBack;
	}

	public void setTotalCashBack(BigDecimal totalCashBack) {
		this.totalCashBack = totalCashBack;
	}

}
