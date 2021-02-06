package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Modelo;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;


import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class FormModelo extends JDialog {

	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	public static JComboBox<String> comboBoxModelo;
	public static JComboBox<String> comboBoxMarca;
	public static Hashtable<String, Integer> id_modelo;
	public static Hashtable<String, Integer> id_marca;
	public static JLabel lblError;
	public static JFormattedTextField formattedTextFieldPotencia;
	public static JToggleButton tgVisible;
	public static String status;
	public static JButton okButton;
	public static Modelo modelo;
	private JLabel lblPrecio;
	/**
	 * Create the dialog.
	 */
	public FormModelo(String status,Modelo modelo) {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				view.FormModelo.modelo = modelo;
				view.FormModelo.status = status;
				id_modelo = new Hashtable<String, Integer>();
				id_marca = new Hashtable<String, Integer>();
				
				
				controller.GestionModelosController.statusMode(status,modelo);
				
				controller.GestionModelosController.offCargando();
			
				
			}
		});
			
		setTitle("Formulario Modelo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 313);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
		setModal(true);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("* Modelo:");
			lblModelo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblModelo.setBounds(48, 72, 101, 25);
			contentPanel.add(lblModelo);
		}
		{
			comboBoxModelo = new JComboBox<String>();
			comboBoxModelo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			comboBoxModelo.setBounds(196, 74, 238, 20);
			contentPanel.add(comboBoxModelo);
		}
		
		JLabel lblMarca = new JLabel("* Marca:");
		lblMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMarca.setBounds(48, 29, 53, 25);
		contentPanel.add(lblMarca);
		
		comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controller.GestionModelosController.onCargando();
				controller.GestionModelosController.setModeloFormModelos();
				
				controller.GestionModelosController.offCargando();
			}
		});
		comboBoxMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxMarca.setBounds(196, 33, 238, 20);
		contentPanel.add(comboBoxMarca);
		{
			JLabel lblPotencia = new JLabel("* Potencia:");
			lblPotencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPotencia.setBounds(48, 126, 70, 14);
			contentPanel.add(lblPotencia);
		}
		{
			JLabel lblVisible = new JLabel("* Visible:");
			lblVisible.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblVisible.setBounds(48, 168, 70, 14);
			contentPanel.add(lblVisible);
		}
		{
			tgVisible = new JToggleButton("S\u00ED");
			tgVisible.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			tgVisible.setBounds(196, 164, 79, 23);
			contentPanel.add(tgVisible);
		}
		

		formattedTextFieldPotencia = new JFormattedTextField(new Integer(0));
		formattedTextFieldPotencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		formattedTextFieldPotencia.setText("0");
		formattedTextFieldPotencia.setBounds(196, 126, 238, 20);
		contentPanel.add(formattedTextFieldPotencia);
		{
			lblPrecio = new JLabel("* Precio:");
			lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPrecio.setBounds(48, 197, 79, 25);
			contentPanel.add(lblPrecio);
		}
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(196, 202, 238, 20);
		contentPanel.add(formattedTextField);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if(status.equals("Añadir")) {
							
							// Añadir
							boolean response = controller.GestionModelosController.addModelo();
							if(response) {
								dispose();
							}
							
						}else {
							
							//Editar 
							boolean response = controller.GestionModelosController.editModelo();
							if(response) {
								dispose();
							}
						}
						
						
					}
				});
				
				lblError = new JLabel("Cargando...");
				buttonPane.add(lblError);
				lblError.setHorizontalAlignment(SwingConstants.CENTER);
				lblError.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
