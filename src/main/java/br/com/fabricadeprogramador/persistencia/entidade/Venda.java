package br.com.fabricadeprogramador.persistencia.entidade;

import java.sql.Date;

//import java.util.Date;

public class Venda {
	
	private Integer id;
	private double valor;
	private Date data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date date) {
		this.data =  date;
	}
	
	

}
