package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class FrmCliente extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtDireccion;
	private JLabel lblFUEGO;

	public FrmCliente() {
		setResizable(false);
		addFrmCliente();
		try {
			Modelo.Edificio ed = Controlador.crtEdificio.readEdificio();

			txtID.setText(""+ed.getID_EDIFICIO());
			txtNombre.setText( ed.getNOMBRE_EDIFICIO().toString());
			txtCiudad.setText(ed.getCIUDAD().toString());
			txtDireccion.setText(ed.getDIRECCION());
			lblFUEGO.setText(ed.getMensaje().toString());
			setVisible(true);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void addFrmCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 305);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Edificio");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("A\u00F1adir Edificio");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new FrmAddEdificio();

			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Borrar Edificio");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmBorrarEdificio();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id_Edificio:");
		lblNewLabel.setBounds(21, 46, 62, 14);
		contentPane.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(159, 44, 168, 17);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(159, 77, 168, 16);
		contentPane.add(txtNombre);

		JLabel lblNombreedificio = new JLabel("Nombre_Edificio:");
		lblNombreedificio.setBounds(21, 79, 88, 14);
		contentPane.add(lblNombreedificio);

		JLabel lblNewLabel_1 = new JLabel("Ciudad:");
		lblNewLabel_1.setBounds(21, 114, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtCiudad = new JTextField();
		txtCiudad.setBounds(159, 111, 168, 17);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(159, 142, 168, 17);
		contentPane.add(txtDireccion);

		JLabel lblNewLabel_1_1 = new JLabel("Direccion:");
		lblNewLabel_1_1.setBounds(21, 145, 62, 14);
		contentPane.add(lblNewLabel_1_1);

		lblFUEGO = new JLabel("");
		lblFUEGO.setForeground(Color.RED);
		lblFUEGO.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblFUEGO.setBounds(21, 176, 306, 53);
		contentPane.add(lblFUEGO);
	}
}
