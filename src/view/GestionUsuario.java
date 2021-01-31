package view;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.prompt.PromptSupport;

import model.DetallesUsuario;
import model.GenericUsuario;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GestionUsuario extends JFrame {

	private JPanel contentPane;
	private JPanel panelBuscador;
	private JPanel panelTable;
	public static JTable table;
	private JPanel panelTitulo;
	private JPanel panelBuscadorElement;
	private JLabel lblGestUsuario;
	private JPanel panelEmail;
	private JPanel panelPassword;
	private JPanel panelButtons;
	private JLabel lblEmail;
	public static JTextField txtBusqueda;
	private JLabel lblAdministrador;
	public static JButton btBorrar;
	private JSeparator separator;
	private JPanel panel;
	private JButton btnAddUsuario;
	private JLabel lblBusqueda;
	private JScrollBar scrollBar;
	public static JLabel lblError;
	public static JComboBox comboBoxRoles;
	public static Hashtable<String, Integer> contenedorRoles;
	private static JButton btnEditar;
	
	/**
	 * Create the frame.
	 */
	public GestionUsuario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				// INICIALIZAMOS EL HASTABLEY EL COMBOBOX
				view.GestionUsuario.contenedorRoles = new Hashtable<String, Integer>();
				controller.GestionUsuarioController.setRolesComboBox();
				
				
				//controller.GestionUsuarioController.btnBorrarEnabled();
				controller.GestionUsuarioController.pintarTableUsuario();
				
				// BOTONES
				if(controller.GestionUsuarioController.getSelectedRow(table)) {
					view.GestionUsuario.btBorrar.setEnabled(true);
					view.GestionUsuario.btnEditar.setEnabled(true);

				}else{
					view.GestionUsuario.btBorrar.setEnabled(false);
					view.GestionUsuario.btnEditar.setEnabled(false);
				};
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setSize(804, 613);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelBuscador = new JPanel();
		contentPane.add(panelBuscador, BorderLayout.NORTH);
		panelBuscador.setLayout(new GridLayout(2, 1, 0, 0));
		
		panelTitulo = new JPanel();
		panelBuscador.add(panelTitulo);
		
		lblGestUsuario = new JLabel("Gesti\u00F3n Usuarios");
		lblGestUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		panelTitulo.add(lblGestUsuario);
		
		panelBuscadorElement = new JPanel();
		panelBuscador.add(panelBuscadorElement);
		panelBuscadorElement.setLayout(new GridLayout(2, 2, 5,10));
		
		panelEmail = new JPanel();
		panelBuscadorElement.add(panelEmail);
		panelEmail.setLayout(null);
		
		lblEmail = new JLabel("B\u00FAsqueda:");
		lblEmail.setBounds(10, 5, 70, 20);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panelEmail.add(lblEmail);
		
		txtBusqueda = new JTextField();
		PromptSupport.setPrompt("Búsqueda por Email, Nombre o Nick", txtBusqueda);
		txtBusqueda.setBounds(90, 5, 250, 25);
		panelEmail.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		panelPassword = new JPanel();
		panelBuscadorElement.add(panelPassword);
		panelPassword.setLayout(null);
		
		lblAdministrador = new JLabel("Rol:");
		lblAdministrador.setBounds(10, 5, 58, 20);
		lblAdministrador.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panelPassword.add(lblAdministrador);
		
		lblBusqueda = new JLabel("");
		lblBusqueda.setBounds(350, 5, 32, 25);
		
		lblBusqueda.setIcon(new ImageIcon("images/lupa.jpg"));
		
		panelPassword.add(lblBusqueda);
		
		comboBoxRoles = new JComboBox();
		comboBoxRoles.setBounds(59, 7, 268, 20);
		panelPassword.add(comboBoxRoles);
		lblBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				controller.GestionUsuarioController.pintarTableUsuario();
				
			}
		});
		
		panelButtons = new JPanel();
		panelBuscadorElement.add(panelButtons);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btBorrar = new JButton("Borrar Usuario");
		btBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GenericUsuario g =  controller.GestionUsuarioController.getDatosTableSelectedRow(table);
				FormGestionUsuario frame = new FormGestionUsuario(2,g);
				frame.setVisible(true);
			
			}
		});
		panelButtons.add(btBorrar);
		btBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnEditar = new JButton("Editar Usuario");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GenericUsuario g =  controller.GestionUsuarioController.getDatosTableSelectedRow(table);
				FormGestionUsuario frame = new FormGestionUsuario(1,g);
				frame.setVisible(true);
			}
		});
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panelButtons.add(btnEditar);
		
		btnAddUsuario = new JButton("A\u00F1adir Usuario");
		panelButtons.add(btnAddUsuario);
		btnAddUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GenericUsuario g = null;
				FormGestionUsuario frame = new FormGestionUsuario(0,g);
				frame.setVisible(true);
			
			}
		});
		btnAddUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		panel = new JPanel();
		panelBuscadorElement.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblError);
		
		panelTable = new JPanel();
		contentPane.add(panelTable, BorderLayout.CENTER);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		
		// TABLA
		table = new JTable();
		panelTable.add(table, BorderLayout.CENTER);
		//table.setCellSelectionEnabled(true);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// 
				if(controller.GestionUsuarioController.getSelectedRow(table)) {
					view.GestionUsuario.btBorrar.setEnabled(true);
					view.GestionUsuario.btnEditar.setEnabled(true);

				}else{
					view.GestionUsuario.btBorrar.setEnabled(false);
					view.GestionUsuario.btnEditar.setEnabled(false);
				};
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una fila

		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		getContentPane().add(js);
		
		
		separator = new JSeparator();
		panelTable.add(separator, BorderLayout.NORTH);
	}
}
