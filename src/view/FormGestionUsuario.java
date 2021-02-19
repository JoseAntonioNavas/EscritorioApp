package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.GenericUsuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormGestionUsuario extends JDialog {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JPanel panel;
	private JLabel lblNewLabel;
	public static JTextField txtNombre;
	private JLabel lblApellido1;
	public static JTextField txtApellido1;
	public static JTextField txtApellido2;
	private JLabel lblSegundoApellido;
	public static JTextField txtNick;
	public static JTextField txtEmail;
	private JLabel lblNick;
	private JLabel lblEmail;
	public static JPasswordField passwordField;
	public static JButton btnEditar;
	public static JButton btnCrear;
	public static JButton btnBorrar;
	public static Hashtable<String, Integer> contenedorRoles;
	public static JComboBox comboBoxRoles;
	public static  JLabel lblError;
	private JLabel lblInfo;
	
	
	public static Integer Status = 0;
	public static GenericUsuario usuariogenerico;
	


	/**
	 * Create the frame.
	 */
	public FormGestionUsuario(Integer Status, GenericUsuario usuariogenerico) {
		
		this.usuariogenerico = usuariogenerico;
		this.Status = Status;
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				
				contenedorRoles = new Hashtable<String, Integer>();
				controller.FormGestionUsuarioController.setRolesComboBox();
				
				
				controller.FormGestionUsuarioController.visualStatusFrame();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(500, 500);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("FORMULARIO USUARIO");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("* Nombre:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 77, 120, 25);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNombre.setBounds(200, 76, 236, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido1 = new JLabel("* Primer Apellido:");
		lblApellido1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblApellido1.setBounds(52, 112, 120, 25);
		panel.add(lblApellido1);
		
		txtApellido1 = new JTextField();
		txtApellido1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtApellido1.setBounds(200, 111, 236, 25);
		panel.add(txtApellido1);
		txtApellido1.setColumns(10);
		
		txtApellido2 = new JTextField();
		txtApellido2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtApellido2.setColumns(10);
		txtApellido2.setBounds(200, 146, 236, 25);
		panel.add(txtApellido2);
		
		lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSegundoApellido.setBounds(52, 147, 120, 25);
		panel.add(lblSegundoApellido);
		
		txtNick = new JTextField();
		txtNick.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNick.setColumns(10);
		txtNick.setBounds(200, 181, 236, 25);
		panel.add(txtNick);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(200, 217, 236, 25);
		panel.add(txtEmail);
		
		lblNick = new JLabel("* Nick:");
		lblNick.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNick.setBounds(52, 182, 120, 25);
		panel.add(lblNick);
		
		lblEmail = new JLabel("* Email");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmail.setBounds(52, 217, 120, 25);
		panel.add(lblEmail);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordField.setBounds(200, 252, 236, 25);
		panel.add(passwordField);
		
		JLabel lblContrasea = new JLabel("* Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblContrasea.setBounds(52, 252, 120, 25);
		panel.add(lblContrasea);
		
		JLabel lblRol = new JLabel("* Rol:");
		lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblRol.setBounds(52, 287, 120, 25);
		panel.add(lblRol);
		
		 comboBoxRoles = new JComboBox();
		 comboBoxRoles.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxRoles.setBounds(200, 287, 236, 25);
		panel.add(comboBoxRoles);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controller.FormGestionUsuarioController.borrarModal()){
					dispose();
				}
			}
		});
		btnBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnBorrar.setBounds(33, 350, 120, 25);
		panel.add(btnBorrar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(controller.FormGestionUsuarioController.editar()) {
					dispose();
				};
				
			}
		});
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnEditar.setBounds(174, 350, 120, 25);
		panel.add(btnEditar);
		
		btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(controller.FormGestionUsuarioController.crearUsuario()) {
					dispose();
				};
				
			}
		});
		btnCrear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnCrear.setBounds(316, 350, 120, 25);
		panel.add(btnCrear);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblError.setBounds(43, 381, 384, 30);
		panel.add(lblError);
		
		lblInfo = new JLabel("Todos los campos (*) son obligatorios");
		lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblInfo.setBounds(52, 30, 384, 25);
		panel.add(lblInfo);
	}

	public static Integer getStatus() {
		return Status;
	}

	public static void setStatus(Integer status) {
		Status = status;
	}
	
	public static GenericUsuario getUsuariogenerico() {
		return usuariogenerico;
	}

	public static void setUsuariogenerico(GenericUsuario usuariogenerico) {
		FormGestionUsuario.usuariogenerico = usuariogenerico;
	}
}
