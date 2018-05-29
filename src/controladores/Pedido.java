package controladores;

import java.util.ArrayList;

public class Pedido {
	private String nome;
	private String data;
	private String hora;
	private ArrayList<Quantidade_Produtos> qp = new ArrayList<>();
	private static ArrayList<Pedido> p = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public ArrayList<Pedido> getP() {
		return p;
	}
	public void setP(ArrayList<Pedido> p) {
		this.p = p;
	}
	public ArrayList<Quantidade_Produtos> getQp() {
		return qp;
	}
	public void setQp(ArrayList<Quantidade_Produtos> qp) {
		this.qp = qp;
	}
	

	
}
