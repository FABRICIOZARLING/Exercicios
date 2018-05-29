package controladores;

import java.util.ArrayList;
import javax.swing.*;

import javax.swing.JOptionPane;

public class Funcoes {
	public void cadastrar(String nome, String v) {
		try {
			double valor = Double.parseDouble(v);
			Produto p = new Produto();
			p.setNome(nome);
			p.setValor(valor);
			ArrayList<Produto> produto =p.getP();
			produto.add(p);
			p.setP(produto);
		} catch (Exception e) {
			alert("valor: "+v);
		}
	}
	public String[] listarProdutos() {	
		Produto p = new Produto();
		ArrayList<Produto> produto =p.getP();
		String[] lista = new String[produto.size()]; 
		
		for(int x = 0; x<produto.size(); x++) {
			lista[x]=produto.get(x).getNome();
		}
		return lista;
		
	}
	
	public void registraProdutoPedido(int index, String q) {
		try {
			int quantidade = Integer.parseInt(q);

			Quantidade_Produtos qp = new Quantidade_Produtos();
			qp.setProduto(index);
			qp.setQuantidade(quantidade);
			ArrayList<Quantidade_Produtos> q_p = qp.getQp();
			q_p.add(qp);
			qp.setQp(q_p);
			System.out.println(q_p.size());
		} catch (Exception e) {
			alert("Quantidade: "+q);
		}
	}
	public String[] listarPedido(int row) {
		String[] lista = new String[3];
		Produto p = new Produto();
		Quantidade_Produtos qp = new Quantidade_Produtos();
		//System.out.println(qp.getQp().get(0).getProduto());
		for(int x = row; x<qp.getQp().size();x++) {
			int index = qp.getQp().get(x).getProduto();
			lista[0]= p.getP().get(index).getNome();
			lista[1]= String.format("%.2f", p.getP().get(index).getValor());
			lista[2]= ""+qp.getQp().get(x).getQuantidade();
		}
		
		return lista;
	}
	public void alert(String erro) {
		JOptionPane.showMessageDialog(null, "Revise o dado "+erro);
	}
	
}


