package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;

public class FormModelo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JComboBox comboBoxModelo;
	public static JComboBox comboBoxMarca;
	private JTextField txtPotencia;

	/**
	 * Create the dialog.
	 */
	public FormModelo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				controller.GestionModelosController.setDatosFormModelos();
				
				
			}
		});
			
		setTitle("Formulario Modelo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 313);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
		
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
			comboBoxModelo = new JComboBox();
			comboBoxModelo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			comboBoxModelo.setBounds(196, 74, 238, 20);
			contentPanel.add(comboBoxModelo);
		}
		
		JLabel lblMarca = new JLabel("* Marca:");
		lblMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMarca.setBounds(48, 29, 53, 25);
		contentPanel.add(lblMarca);
		
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxMarca.setBounds(196, 33, 238, 20);
		contentPanel.add(comboBoxMarca);
		{
			txtPotencia = new JTextField();
			txtPotencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtPotencia.setBounds(196, 120, 238, 20);
			contentPanel.add(txtPotencia);
			txtPotencia.setColumns(10);
		}
		{
			JLabel lblPotencia = new JLabel("* Potencia:");
			lblPotencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPotencia.setBounds(48, 126, 70, 14);
			contentPanel.add(lblPotencia);
		}
		{
			JLabel lblVisible = new JLabel("* Visible:");
			lblVisible.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblVisible.setBounds(48, 175, 70, 14);
			contentPanel.add(lblVisible);
		}
		{
			JToggleButton tgVisible = new JToggleButton("On");
			tgVisible.setBounds(196, 173, 79, 23);
			contentPanel.add(tgVisible);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
