package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFormattedTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FormVehiculosCatalogo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JComboBox<String> comboBoxMarca;
	public static JComboBox<String> comboBoxModelo;
	public static JFormattedTextField txtMatricula;
	public static JComboBox<String> comboBoxColor;
	public static JLabel lblColorMuestra;
	
	public FormVehiculosCatalogo(String status) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				controller.GestionVehiculoController.setValores(status);
			}
		});
		
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 374, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMarca = new JLabel("* Marca:");
			lblMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblMarca.setBounds(36, 27, 79, 25);
			contentPanel.add(lblMarca);
		}
		
		comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controller.GestionVehiculoController.changeModelo();
			}
		});
		comboBoxMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxMarca.setBounds(141, 29, 165, 21);
		contentPanel.add(comboBoxMarca);
		
		comboBoxModelo = new JComboBox<String>();
		comboBoxModelo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxModelo.setBounds(141, 78, 165, 21);
		contentPanel.add(comboBoxModelo);
		
		JLabel lblModelo = new JLabel("* Modelo:");
		lblModelo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblModelo.setBounds(36, 74, 79, 25);
		contentPanel.add(lblModelo);
		{
			JLabel lblMatricula = new JLabel("* Matricula:");
			lblMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblMatricula.setBounds(36, 121, 79, 25);
			contentPanel.add(lblMatricula);
		}
		
		 txtMatricula = new JFormattedTextField();
		txtMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMatricula.setBounds(141, 126, 162, 21);
		contentPanel.add(txtMatricula);
		
		JButton btnSubirImagen = new JButton("Cargar Imagen");
		btnSubirImagen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSubirImagen.setBounds(109, 323, 127, 25);
		contentPanel.add(btnSubirImagen);
		
		comboBoxColor = new JComboBox<String>();
		comboBoxColor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controller.GestionVehiculoController.changeColor();
			}
			
		});
		comboBoxColor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxColor.setBounds(143, 174, 163, 21);
		contentPanel.add(comboBoxColor);
		
		JLabel lblColor = new JLabel("* Color:");
		lblColor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblColor.setBounds(37, 172, 78, 21);
		contentPanel.add(lblColor);
		
		lblColorMuestra = new JLabel("");
		lblColorMuestra.setBounds(141, 221, 165, 44);
		contentPanel.add(lblColorMuestra);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(status);
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
