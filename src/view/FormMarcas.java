package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import controller.GestionMarcasController.MarcasAPI;
import model.Marca;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMarcas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JComboBox comboBoxMarcas;
	public static Hashtable<String, Integer> idMarca;
	public static JCheckBox chBoxVisible ;
	public static JLabel lblError;
	
	public FormMarcas(String status) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				List<MarcasAPI> marcasAPI = controller.GestionMarcasController.getAllMarcasAPI();
				idMarca = new Hashtable<String, Integer>();
				
				for (MarcasAPI m : marcasAPI) {
					idMarca.put(m.getMake_Name(), m.getMake_ID());
					comboBoxMarcas.addItem(m.getMake_Name());
				}
				
				if(status.equals("Editar")) {
					
					// Marca seleccionada
					Marca marca = controller.GestionMarcasController.getSelectedRow();
					controller.GestionMarcasController.setValoresFormMarca(marca);
					
				}
				
			}
		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setSize(500, 250);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
		setTitle("Gestión Marcas");
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 1, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblMarca = new JLabel("Marca *:");
				lblMarca.setBounds(33, 31, 52, 20);
				lblMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				panel.add(lblMarca);
			}
			{
				comboBoxMarcas = new JComboBox();
				comboBoxMarcas.setBounds(108, 34, 337, 19);
				AutoCompleteDecorator.decorate(comboBoxMarcas);
				
				comboBoxMarcas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel.add(comboBoxMarcas);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblVisible = new JLabel("Visible: *");
				lblVisible.setBounds(31, 13, 64, 20);
				lblVisible.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				panel.add(lblVisible);
			}
			
			chBoxVisible = new JCheckBox("Visible");
			chBoxVisible.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			chBoxVisible.setBounds(104, 12, 341, 21);
			panel.add(chBoxVisible);
			
			lblError = new JLabel("");
			lblError.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblError.setBounds(243, 49, 233, 25);
			panel.add(lblError);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(status);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(status == "Añadir") {
							if(controller.GestionMarcasController.formGuardarMarca()) {
								dispose();
							};
						}
						if(status == "Editar") {
							if(controller.GestionMarcasController.formEditarMarca()) {
								dispose();

							};
						}
						
					}
				});
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setActionCommand(status);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
