package view;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
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
	public static JTextField txtEmail;
	private JLabel lblAdministrador;
	public static JButton btBorrar;
	private JSeparator separator;
	private JPanel panel;
	private JButton btnAddUsuario;
	private JLabel lblBusqueda;
	private JScrollBar scrollBar;
	public static JLabel lblError;
	public static JComboBox comboBoxRoles;
	public static Hashtable<String, Integer> rolesHastable;

	/**
	 * Create the frame.
	 */
	public GestionUsuario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				rolesHastable = controller.GestionUsuarioController.setRolesComboBox();
				
				System.out.println(rolesHastable);
				controller.GestionUsuarioController.btnBorrarEnabled();
				controller.GestionUsuarioController.pintarTableUsuario();
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
		
		txtEmail = new JTextField();
		PromptSupport.setPrompt("Búsqueda por Email, Nombre o Nick", txtEmail);
		txtEmail.setBounds(90, 5, 250, 25);
		panelEmail.add(txtEmail);
		txtEmail.setColumns(10);
		
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
		comboBoxRoles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				//System.out.println(rolesHastable.get(comboBoxRoles.getSelectedItem()));
			}
		});
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
				
				controller.GestionUsuarioController.modalBorrar();
				//System.out.println(service.UsuarioService.deleteUsuario("20"));
			}
		});
		panelButtons.add(btBorrar);
		btBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		btnAddUsuario = new JButton("A\u00F1adir Usuario");
		panelButtons.add(btnAddUsuario);
		btnAddUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.GestionUsuarioController.insertarUsuario();
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
		
		
	
		
		/*tblResult = new JTable();
		panelDat.setViewportView(tblResult);
*/
		table = new JTable();
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				controller.GestionUsuarioController.btnBorrarEnabled();
				System.out.println(table.getValueAt(table.getSelectedRow(), 0));
			}
			@Override
			public void focusLost(FocusEvent e) {
				controller.GestionUsuarioController.btnBorrarEnabled();
				System.out.println(table.getValueAt(table.getSelectedRow(), 0));		}
		});
		panelTable.add(table, BorderLayout.CENTER);
		table.setCellSelectionEnabled(true);
		
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		getContentPane().add(js);
		
		
		
		separator = new JSeparator();
		panelTable.add(separator, BorderLayout.NORTH);
	}
}
