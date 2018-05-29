package controladores;

import java.util.ArrayList;

public class Quantidade_Produtos {
	private int quantidade;
	private int produto;
	private static ArrayList<Quantidade_Produtos> qp = new ArrayList<>();

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}
	public static ArrayList<Quantidade_Produtos> getQp() {
		return qp;
	}
	public static void setQp(ArrayList<Quantidade_Produtos> qp) {
		Quantidade_Produtos.qp = qp;
	}
	
}
