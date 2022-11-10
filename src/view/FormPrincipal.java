
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class FormPrincipal  extends JFrame {
    
    private JMenuBar barraMenu;
	private JMenu menuCadastrar, menuListar, menuAjuda;
	private JMenuItem itemLutador, itemEmpresa, itemSobre;
	private JToolBar barraFerramenta;
	private JButton botaoCadastrar, botaoListar, botaoAjuda;
	
	public FormPrincipal() {
		super(" Aplicativo Lutador ");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		adicionarElementos();
		setVisible(true);
	}
	public void adicionarElementos() {
		barraMenu = new JMenuBar();
		barraFerramenta = new JToolBar();
		
		menuAjuda = new JMenu("Ajuda");
		menuCadastrar = new JMenu("Cadastrar");
		menuListar = new JMenu("Listar");
		
		itemLutador = new JMenuItem("Lutador");
		itemLutador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            try {
                                new FormLutador();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
			});
		itemEmpresa = new JMenuItem("Empresa");
		itemSobre = new JMenuItem("Sobre");
		menuCadastrar.add(itemLutador);
		menuCadastrar.add(itemEmpresa);
		menuAjuda.add(itemSobre);
		
		botaoAjuda = new JButton(new ImageIcon("imagens/16.png"));
		botaoCadastrar = new JButton(new ImageIcon("imagens/7.png"));
		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            try {
                                new FormLutador();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
			});
		botaoListar = new JButton(new ImageIcon("imagens/1.png"));
		JLabel labelImagem = new JLabel(new ImageIcon("imagens/ufc.png"));
		add(labelImagem,BorderLayout.CENTER);
		
		barraMenu.add(menuCadastrar);
		barraMenu.add(menuListar);
		barraMenu.add(menuAjuda);
		
		barraFerramenta.add(botaoCadastrar);
		barraFerramenta.add(botaoListar);
		barraFerramenta.add(botaoAjuda);
		
		add(barraFerramenta,BorderLayout.NORTH);
		setJMenuBar(barraMenu);
	}

    public static void main(String[] args) {
       new FormPrincipal();
    }
    
}
