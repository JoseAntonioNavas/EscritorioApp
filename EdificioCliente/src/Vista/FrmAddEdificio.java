package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddEdificio extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCiudad;

	public FrmAddEdificio() {
		
		AddEdificio();
		
		setVisible(true);
	}
	

	/**
	 * Create the dialog.
	 */
	public void AddEdificio() {
		setTitle("A\u00F1adir Edificio");
		setBounds(100, 100, 448, 196);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(22, 23, 46, 14);
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(98, 20, 307, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(98, 56, 307, 20);
		contentPanel.add(txtDireccion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(22, 59, 66, 14);
		contentPanel.add(lblDireccion);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(22, 90, 66, 14);
		contentPanel.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(98, 87, 307, 20);
		contentPanel.add(txtCiudad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Controlador.crtEdificio.addEdificio(txtNombre,txtCiudad,txtDireccion);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
