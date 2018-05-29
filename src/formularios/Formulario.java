package formularios;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Externalizable;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controladores.Funcoes;
import controladores.Produto;


public class Formulario {
	public Formulario() {
		Funcoes f = new Funcoes();
		Produto p =new Produto();
		// JFrame
		JFrame formulario = new JFrame("Mini Sistema");
		formulario.setSize(680, 480);
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setLocationRelativeTo(null);
		formulario.setLayout(null);
		
		JButton cadastrar = new JButton("Cadastrar Produto");
		cadastrar.setBounds(40, 20, 150, 20);
		JButton pedidos = new JButton("Registrar Pedido");
		pedidos.setBounds(170, 20, 150, 20);
		JButton historico = new JButton("Ver Histórico");
		historico.setBounds(320, 20, 150, 20);
		JButton estatisticas = new JButton("Ver Estatísticas");
		estatisticas.setBounds(470, 20, 150, 20);
		
		ButtonGroup botoes = new ButtonGroup();
		botoes.add(cadastrar);
		botoes.add(pedidos);
		botoes.add(historico);
		botoes.add(estatisticas);

		
		JPanel jpCadastro = new JPanel();
		JPanel jpPedido = new JPanel();
		JPanel jpHistorico = new JPanel();
		JPanel jpEstatistica = new JPanel();
		jpHistorico.setBounds(40, 40, 600, 400);
		jpEstatistica.setBounds(40, 40, 600, 400);
		jpPedido.setBounds(40, 40, 600, 400);
		jpCadastro.setBounds(40, 40, 600, 400);


		
		//painel cadastro
		
		JLabel produto = new JLabel("Produto");
		produto.setBounds(60, 60, 100, 30);
		
		JLabel valor = new JLabel("Valor");
		valor.setBounds(60, 100, 100, 30);

		
		JTextField c_produto = new JTextField();
		c_produto.setBounds(200, 60, 200, 30);
		
		JTextField c_valor = new JTextField();
		c_valor.setBounds(200, 100, 200, 30);
		
		JButton cadastro = new JButton("Salvar");
		cadastro.setBounds(60, 150, 340, 30);
		
		jpCadastro.add(produto);
		jpCadastro.add(c_produto);
		jpCadastro.add(valor);
		jpCadastro.add(c_valor);
		jpCadastro.add(cadastro);
		
		cadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.cadastrar(c_produto.getText(), c_valor.getText());
				
			}
		});
		
		//painel pedido
		JLabel nome_cliente = new JLabel("Cliente");
		nome_cliente.setBounds(60, 60, 100, 30);

		JComboBox<String> combo = new JComboBox<>();
		combo.setBounds(60, 100, 250, 30);
		
		JTextField c_nome = new JTextField();
		c_nome .setBounds(200, 60, 400, 30);
		
		JLabel quantidade = new JLabel("Quantidade");
		quantidade.setBounds(350, 100, 120, 30);
		
		JTextField c_quantidade = new JTextField();
		c_quantidade .setBounds(440, 100, 50, 30);
		
		JButton adicionar = new JButton("Adicionar");
		adicionar.setBounds(500, 100, 100, 30);
		
		JButton salvar = new JButton("Salvar");
		salvar.setBounds(60, 400, 540, 30);
		
		jpPedido.add(nome_cliente);
		jpPedido.add(combo);
		jpPedido.add(c_nome);
		jpPedido.add(quantidade);
		jpPedido.add(c_quantidade);
		jpPedido.add(adicionar);
		jpPedido.add(salvar);
		
		//DefaultTableModel - Serve para agrupar os dados
				DefaultTableModel exibirDados = new DefaultTableModel();
				
				//Criar colunas
				exibirDados.addColumn("Produto");
				exibirDados.addColumn("Valor");
				exibirDados.addColumn("Quantidade");
				
			
				JTable tabela = new JTable(exibirDados);
				
				// JScrollPane - Barra de rolagem englobando o JTable
				JScrollPane barraRolagem = new JScrollPane(tabela);
				barraRolagem.setBounds(60, 140, 540, 250);
				jpPedido.add(barraRolagem);
		
		adicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!c_nome.getText().equals("")&&!c_quantidade.getText().equals("")&&combo.getSelectedItem()!=null) {
					String nome_cliente = c_nome.getText();
					c_nome.setEnabled(false);
					f.registraProdutoPedido(combo.getSelectedIndex(), c_quantidade.getText());
					exibirDados.addRow(f.listarPedido(exibirDados.getRowCount()));
					
				}
				
			}
		});
		
		
		

		Component[]  comp_cadastro = jpCadastro.getComponents(); 
		Component[]  comp_pedido = jpPedido.getComponents(); 
		Component[]  comp_historico = jpHistorico.getComponents(); 
		Component[]  comp_estatistica = jpEstatistica.getComponents();	
		
		trocaPainel(comp_cadastro, false, jpCadastro);
		trocaPainel(comp_pedido, false, jpPedido);
		trocaPainel(comp_historico, false, jpHistorico);
		trocaPainel(comp_estatistica, false, jpEstatistica);
		
		cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trocaPainel(comp_cadastro, true, jpCadastro);
				trocaPainel(comp_pedido, false, jpPedido);
				trocaPainel(comp_historico, false, jpHistorico);
				trocaPainel(comp_estatistica, false, jpEstatistica);
				
				
				
			}
		});
		pedidos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trocaPainel(comp_cadastro, false, jpCadastro);
				trocaPainel(comp_pedido, true, jpPedido);
				trocaPainel(comp_historico, false, jpHistorico);
				trocaPainel(comp_estatistica, false, jpEstatistica);
				String[] lista = f.listarProdutos();
				for(int x=combo.getItemCount(); x<lista.length; x++) {
					combo.addItem(lista[x]);
				}

			}
		});
		
		historico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trocaPainel(comp_cadastro, false, jpCadastro);
				trocaPainel(comp_pedido, false, jpPedido);
				trocaPainel(comp_historico, true, jpHistorico);
				trocaPainel(comp_estatistica, false,jpEstatistica);
				
			}
		});
		
		estatisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trocaPainel(comp_cadastro, false, jpCadastro);
				trocaPainel(comp_pedido, false, jpPedido);
				trocaPainel(comp_historico, false, jpHistorico);
				trocaPainel(comp_estatistica, true,jpEstatistica);
				
			}
		});	
		// Adicionar elementos ao formulário
		
		formulario.add(cadastrar);
		formulario.add(pedidos);
		formulario.add(historico);
		formulario.add(estatisticas);
		formulario.add(produto);
		formulario.add(valor);
		formulario.add(c_produto);
		formulario.add(c_valor);
		formulario.add(cadastro);
		formulario.add(jpCadastro);
		formulario.add(nome_cliente);
		formulario.add(combo);
		formulario.add(c_nome);
		formulario.add(quantidade);
		formulario.add(c_quantidade);
		formulario.add(adicionar);
		formulario.add(salvar);
		formulario.add(barraRolagem);
		formulario.add(jpPedido);

		
		// Exibir formulário
		formulario.setVisible(true);
	
		
	}
	private void trocaPainel(Component[] c, boolean acao, JPanel j) {
		j.setVisible(acao);	
		for (Component component : c) {
			component.setVisible(acao);
		}
		
	}
}
