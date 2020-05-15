package it.polito.tdp.crimes.model;

public class Adiacenze {

	private String reato1;
	private String reato2;
	private int peso;
	/**
	 * @param reato1
	 * @param reato2
	 */
	public Adiacenze(String reato1, String reato2, int peso) {
		super();
		this.reato1 = reato1;
		this.reato2 = reato2;
		this.peso = peso;
	}
	public String getReato1() {
		return reato1;
	}
	public void setReato1(String reato1) {
		this.reato1 = reato1;
	}
	public String getReato2() {
		return reato2;
	}
	public void setReato2(String reato2) {
		this.reato2 = reato2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	
	
}
