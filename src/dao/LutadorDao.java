/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import model.Lutador;
public class LutadorDao {
    
	private Connection conexao; //conexao.
	private PreparedStatement preparar; // preparar o SQL.
	private String sql;
	private ResultSet rs; // guarda o resultado do select.
	
	public LutadorDao() throws ClassNotFoundException, SQLException {
		conexao = new conexao().getConexao();
	}
	
	public void inserir(Lutador lutador) throws SQLException {
		sql = "insert into lutador(nome,peso,altura,categoria) values(?,?,?,?)";
		preparar = conexao.prepareStatement(sql);
		preparar.setString(1, lutador.getNome());
		preparar.setDouble(2, lutador.getPeso());
		preparar.setDouble(3, lutador.getAltura());
		preparar.setString(4, lutador.getCategoria());
		preparar.execute();
		preparar.close();
	}
	
	public void excluir(Lutador lutador) throws SQLException {
		sql = "delete from lutador where id=?";
		preparar = conexao.prepareStatement(sql);
		preparar.setInt(1, lutador.getId());
		preparar.execute();
		preparar.close();
	}
	
	public void alterar(Lutador lutador) throws SQLException {
		sql = "update Lutador lutador set nome=?, peso=?, altura=?, categoria=? where id=?";
		preparar = conexao.prepareStatement(sql);
		preparar.setString(1, lutador.getNome());
		preparar.setDouble(2, lutador.getPeso());
		preparar.setDouble(3, lutador.getAltura());
		preparar.setString(4, lutador.getCategoria());
		preparar.setInt(5, lutador.getId());
		preparar.execute();
		preparar.close();
	}
	
	public DefaultTableModel listarLutador() throws SQLException{
		sql = "select * from lutador order by nome";
		preparar = conexao.prepareStatement(sql);
		
		rs = preparar.executeQuery();
		
		DefaultTableModel tabelaLutador = new DefaultTableModel();
		tabelaLutador.addColumn("ID");
		tabelaLutador.addColumn("Nome");
		tabelaLutador.addColumn("Peso");
		tabelaLutador.addColumn("Altura");
		tabelaLutador.addColumn("Categoria");
		String tituloColuna[] = {"ID","Nome","Peso","Altura","Categoria"};
		
		tabelaLutador.addRow(tituloColuna);
		while(rs.next()) {
			String rowData[] = {
					rs.getString("id"),
					rs.getString("nome"),
					rs.getString("peso"),
					rs.getString("altura"),
					rs.getString("categoria")
			};
			tabelaLutador.addRow(rowData);
		}
		return tabelaLutador;
	}
}
