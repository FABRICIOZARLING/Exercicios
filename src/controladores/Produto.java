package controladores;

import java.util.ArrayList;

public class Produto {
	private String nome;
	private double valor;
	private static ArrayList<Produto> p = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public ArrayList<Produto> getP() {
		return p;
	}
	public void setP(ArrayList<Produto> p) {
		this.p = p;
	}
}
