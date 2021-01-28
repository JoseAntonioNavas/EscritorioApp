package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestionUsuarioController;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
	private JLabel lblPassword;
	public static  JTextField txtPassword;
	private JButton btnNewButton_2;
	private JSeparator separator;
	private JPanel panel;
	private JButton btnAddUsuario;
	private JLabel lblNewLabel;
	private JScrollBar scrollBar;



	/**
	 * Create the frame.
	 */
	public GestionUsuario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
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
		panelBuscadorElement.setLayout(new GridLayout(3, 2, 5,10));
		
		panelEmail = new JPanel();
		panelBuscadorElement.add(panelEmail);
		panelEmail.setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(34, 5, 46, 20);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panelEmail.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(90, 5, 250, 25);
		panelEmail.add(txtEmail);
		txtEmail.setColumns(10);
		
		panelPassword = new JPanel();
		panelBuscadorElement.add(panelPassword);
		panelPassword.setLayout(null);
		
		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(0, 5, 74, 20);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panelPassword.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(90, 5, 250, 25);
		panelPassword.add(txtPassword);
		txtPassword.setColumns(10);
		
		panelButtons = new JPanel();
		panelBuscadorElement.add(panelButtons);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_2 = new JButton("New button");
		panelButtons.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Busqueda");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				controller.GestionUsuarioController.pintarTableUsuario();
				
			}
		});
		panelButtons.add(lblNewLabel);
		
		panel = new JPanel();
		panelBuscadorElement.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAddUsuario = new JButton("A\u00F1adir Usuario");
		btnAddUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel.add(btnAddUsuario);
		
		panelTable = new JPanel();
		contentPane.add(panelTable, BorderLayout.CENTER);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		
	
		
		/*tblResult = new JTable();
		panelDat.setViewportView(tblResult);
*/
		table = new JTable();
		panelTable.add(table, BorderLayout.CENTER);
		table.setEnabled(false);
		
	
		
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		add(js);
		
		
		
		separator = new JSeparator();
		panelTable.add(separator, BorderLayout.NORTH);
	}
}
