package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField txtEmail;
	public static JPasswordField passwordField;
	public static JCheckBox chbxRecordar;
	public static JButton btnEntrar;
	public static JLabel lblError;
	
	private static App frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
								
				// Si el usuario le dio a recordar, rellenamos los campos con su valores 
				controller.LoginController.rellenarCamposLogin();
					
				// Controlar si los campos del formulario estan vacios
				controller.LoginController.lengthFieldLogin();
				
			}
		});
	
		setTitle("JoCars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icono = new ImageIcon("images/logo.jpg");
		this.setIconImage(icono.getImage());
		
		setSize(728, 450);
		setLocationRelativeTo(null);  // Para centrar el frame
		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("JoCars");
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(272, 41, 230, 63);
		contentPane.add(lblTitulo);
		
		JLabel lblLogin = new JLabel("Email: *");
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setBounds(209, 143, 90, 25);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a: *");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(209, 178, 90, 25);
		contentPane.add(lblPassword);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controller.LoginController.lengthFieldLogin();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				controller.LoginController.lengthFieldLogin();
			}
		});
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtEmail.setBounds(309, 143, 210, 25);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controller.LoginController.lengthFieldLogin();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				controller.LoginController.lengthFieldLogin();
			}
		});
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		passwordField.setBounds(309, 179, 210, 25);
		contentPane.add(passwordField);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(logic.LogicApp.pressKeyEnter(e)){
					
					// Logeamos
					controller.LoginController.login();
					
					// Si nos hemos logeado, ocultamos la pantalla del login ( Principal) 
					controller.LoginController.ocultarLogin(frame);
					
					controller.LoginController.abrirPantallaPrincipal();
					
				}
			}
		});

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Logeamos
				controller.LoginController.login();
				
				// Si nos hemos logeado, ocultamos la pantalla del login ( Principal) 
				controller.LoginController.ocultarLogin(frame);
			
				if(logic.globalVariables.usuarioLogged instanceof Usuario) {
					controller.LoginController.abrirPantallaPrincipal();
				}
				
				
			}
		});
		btnEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnEntrar.setBounds(209, 239, 314, 50);
	
		contentPane.add(btnEntrar);
		
		chbxRecordar = new JCheckBox("Recordar");
		chbxRecordar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(logic.LogicApp.pressKeyEnter(e)){
					controller.LoginController.selectedRecordar(chbxRecordar);
				}
			}
		});

		chbxRecordar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chbxRecordar.setBounds(209, 212, 90, 21);
		contentPane.add(chbxRecordar);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(209, 119, 310, 2);
		contentPane.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(209, 316, 310, 2);
		contentPane.add(separator2);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblError.setBounds(209, 363, 310, 25);
		contentPane.add(lblError);
		
	}
}
