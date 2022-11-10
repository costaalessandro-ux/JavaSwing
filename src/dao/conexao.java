/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private Connection conexao;// permite a conexão com o banco de dados. 
    private final String HOST = "localhost";// constante.
    private final int PORTA = 3306; // porta do mysql.
    private final String USUARIO = "root"; // ususario do mysql.
    private final String SENHA = "";// senha do mysql.
    private final String BD = "mma";

    // driver para o java comunicar com o mysql. 
    private final String DRIVER = "com.mysql.jdbc.Driver";
    // url para o conexão.
    private final String URL = "jdbc:mysql://" + HOST + "/" + BD;

    //metodo que estabelece a conexao com o banco de dados. 
    public Connection getConexao() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }

}
