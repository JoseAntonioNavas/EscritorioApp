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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.GridLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	public static JPanel panelGrafica1;

	/**
	 * Create the frame.
	 */
	public Principal() {
		
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
					}else {
						
				      
					}
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 

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
		mnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnUsuario.add(mnSalir);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(1, 2, 0, 0));
		
		panelGrafica1 = new JPanel();
		panelPrincipal.add(panelGrafica1);
		panelGrafica1.add(controller.PrincipalController.grafica1());
		
		JPanel panelGrafica2 = new JPanel();
		panelPrincipal.add(panelGrafica2);
		panelGrafica2.add(controller.PrincipalController.grafica2());
	}
}
