package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	public static JPanel panelGrafica1;

	/**
	 * Create the frame.
	 */
	public Principal() {
		setBackground(new Color(0, 128, 128));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
		
					
			}

			@Override
			public void windowClosing(WindowEvent e) {
				int seleccion = JOptionPane.showOptionDialog(
						   null,
						   "¿Estás Seguro de borrar el usuario? \n Recuerda que se borraran todos los datos asociados a este usuario", 
						   "Selector de opciones",
						   JOptionPane.YES_NO_CANCEL_OPTION,
						   JOptionPane.WARNING_MESSAGE,
						   null,    // null para icono por defecto.
						   new Object[] { "Aceptar", "Cancelar" },   // null para YES, NO y CANCEL
						   "Aceptar");
				
					if(seleccion == 0) {
						System.exit(0);
					}
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 

		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(true);
		
		ImageIcon icono = new ImageIcon("images/logo.jpg");
		this.setIconImage(icono.getImage());
		
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
		
		JMenuItem mngGestionVehiculos = new JMenuItem("Gesti\u00F3n Veh\u00EDculos");
		mngGestionVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new GestionVehiculo().setVisible(true);
				
			}
		});
		mngGestionVehiculos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(mngGestionVehiculos);
		
		JSeparator separator = new JSeparator();
		mnUsuario.add(separator);
		
		JMenuItem mnSalir = new JMenuItem("Salir");
		mnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = JOptionPane.showOptionDialog(
						   null,
						   "¿Estás Seguro de borrar el usuario? \n Recuerda que se borraran todos los datos asociados a este usuario", 
						   "Selector de opciones",
						   JOptionPane.YES_NO_CANCEL_OPTION,
						   JOptionPane.WARNING_MESSAGE,
						   null,    
						   new Object[] { "Aceptar", "Cancelar" },   // null para YES, NO y CANCEL
						   "Aceptar");
				
					if(seleccion == 0) {
						System.exit(0);
					}
			}
		});
		mnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(mnSalir);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.WEST);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelGrafica1 = new JPanel();
		panelGrafica1.setBackground(new Color(0, 128, 128));
		panelPrincipal.add(panelGrafica1);
		panelGrafica1.add(controller.PrincipalController.grafica1());
		
		JPanel panelGrafica2 = new JPanel();
		panelGrafica2.setBackground(new Color(0, 128, 128));
		panelPrincipal.add(panelGrafica2, BorderLayout.EAST);
		panelGrafica2.add(controller.PrincipalController.grafica2());
	}
}
