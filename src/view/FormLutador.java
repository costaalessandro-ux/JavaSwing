
package view;

import dao.LutadorDao;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Lutador;

public class FormLutador extends JFrame {

    public FormLutador() throws ClassNotFoundException, SQLException {
        // Janela.
		super("Formulario de Lutador");
		setSize(400, 300);
		setLocation(450,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Quando não configura o layout é usado o border layout por padrão. 
		//setLayout(new FlowLayout());// layout flutuante.
		//setLayout(new GridLayout(4,2));// layout grade.
		//setResizable(false);
		setLayout(null);
		adicionarElementos();
		setVisible(true);
    }
    
    public void adicionarElementos() throws ClassNotFoundException, SQLException {
		// elementos da Janela.
		JTable viewTabela = new JTable(new LutadorDao().listarLutador());
		viewTabela.setBounds(10,230,450,200);
		
		
		
		JLabel label = new JLabel("Nome do Lutador:");
		label.setBounds(10,30,100,30);
		JTextField editNome = new JTextField(20);
		editNome.setBounds(120, 30, 200, 30);
		
		JLabel label1 = new JLabel("Peso do Lutador:");
		label1.setBounds(10, 70, 100, 30);
		JTextField editNome1 = new JTextField(20);
		editNome1.setBounds(120, 70, 200, 30);
		
		
		JLabel label2 = new JLabel("Altura:");
		label2.setBounds(10, 110, 100, 30);
		JTextField editNome2 = new JTextField(20);
		editNome2.setBounds(120, 110, 200, 30);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 150, 100, 30);
		JComboBox<String> cbxCategoria = new JComboBox<String>();
		cbxCategoria.addItem("Peso palha");
		cbxCategoria.addItem("Peso Mosca");
		cbxCategoria.addItem("Peso Leve");
		cbxCategoria.addItem("Peso Pena");
		cbxCategoria.addItem("Peso Pesado");
		cbxCategoria.addItem("Peso Medio");
		cbxCategoria.setBounds(120, 150, 200, 30);
		
		JButton botao = new JButton("Cadastrar");
		botao.setBounds(10, 190, 100, 30);
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lutador lutador = new Lutador();
				lutador.setNome(editNome.getText());
				lutador.setPeso(Double.parseDouble(editNome1.getText()));
				lutador.setAltura(Double.parseDouble(editNome2.getText()));
				lutador.setCategoria(cbxCategoria.getSelectedItem().toString());
				
				try {
					LutadorDao dao = new LutadorDao();
					dao.inserir(lutador);
					JOptionPane.showMessageDialog(null, "Gravado com sucesso");
					viewTabela.setModel(dao.listarLutador());  
					} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null,"Erro na conexão");
					e1.printStackTrace();
					}
			}
			});
		
			  
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(230,190,100,30);
		btnExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 int linha,id;
				 
				 linha = viewTabela.getSelectedRow();
				 id = Integer.parseInt(viewTabela.getValueAt(linha,0).toString());
				 JOptionPane.showMessageDialog(null, id);
				 
				 Lutador lutador = new Lutador(id);
				 try {
					 LutadorDao dao = new LutadorDao();
					 dao.excluir(lutador);
					 JOptionPane.showMessageDialog(null,"Excluido");
					 viewTabela.setModel(dao.listarLutador());
				 } catch (ClassNotFoundException | SQLException e1) {
					 e1.printStackTrace();
				 } 
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(10, 190, 100, 30);
		btnAtualizar.setVisible(false);
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int linha = viewTabela.getSelectedRow();
				int id = Integer.parseInt(viewTabela.getValueAt(linha, 0).toString());
				Lutador lutador = new Lutador();
				lutador.setId(id);
				lutador.setNome(editNome.getText());
				lutador.setPeso(Double.parseDouble(editNome1.getText()));
				lutador.setAltura(Double.parseDouble(editNome2.getText()));
				lutador.setCategoria(cbxCategoria.getSelectedItem().toString());
				
				try {
					LutadorDao dao = new LutadorDao();
					dao.alterar(lutador);
					JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
					viewTabela.setModel(dao.listarLutador());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(340,190,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 int linha,id;
				 String nome, categoria;
				 double peso, altura;
				 
				 linha = viewTabela.getSelectedRow();
				 id = Integer.parseInt(viewTabela.getValueAt(linha,0).toString());
				 nome = viewTabela.getValueAt(linha,1).toString();
				 peso = Double.parseDouble(viewTabela.getValueAt(linha, 2).toString());
				 
				 altura = Double.parseDouble(viewTabela.getValueAt(linha, 3).toString());
				 categoria = viewTabela.getValueAt(linha, 4).toString();
				 
				 editNome.setText(nome);
				 editNome1.setText(""+peso);
				 editNome2.setText(""+altura);
				 cbxCategoria.setSelectedItem(categoria);
				 botao.setVisible(false); // botão cadastrar.
				 btnAtualizar.setVisible(true);
			}
		});
		
		JButton botao1 = new JButton("Limpar");
		botao1.setBounds(120, 190, 100, 30);
		botao1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				editNome.setText(null);
				editNome1.setText(null);
				editNome2.setText(null);
				editNome.requestFocus();
				botao.setVisible(true);
				btnAtualizar.setVisible(false);
			}
		});
		
		
		add(label);add(editNome);
		add(label1);add(editNome1);
		add(label2);add(editNome2);
		add(lblCategoria);add(cbxCategoria);
		System.out.print("");
		add(btnAtualizar);add(botao);add(botao1);add(btnExcluir);add(btnEditar);
		add(viewTabela);
	}
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new FormLutador();
	}
    
}
