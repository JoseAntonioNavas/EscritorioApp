package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JSeparator;

public class Principal extends JFrame {

	private JPanel contentPane;
	


	/**
	 * Create the frame.
	 */
	public Principal() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
					System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(804, 613);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Gesti\u00F3n");
		mnUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnUsuario);
		
		JMenuItem gUsuarios = new JMenuItem("Gesti\u00F3n Usuarios");
		gUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionUsuario().setVisible(true);
			}
		});
		gUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(gUsuarios);
		
		JMenuItem gColor = new JMenuItem("Gesti\u00F3n Color");
		gColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionColor().setVisible(true);
			}
		});
		gColor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(gColor);
		
		JMenuItem gMarcas = new JMenuItem("Gesti\u00F3n Marcas");
		gMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionMarcas().setVisible(true);
			}
		});
		gMarcas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(gMarcas);
		
		JMenuItem gModelo = new JMenuItem("Gesti\u00F3n Modelos");
		gModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionModelos().setVisible(true);
			}
		});
		gModelo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(gModelo);
		
		JSeparator separator = new JSeparator();
		mnUsuario.add(separator);
		
		JMenuItem mnSalir = new JMenuItem("Salir");
		mnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(mnSalir);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
