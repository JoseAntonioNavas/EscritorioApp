package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionColor extends JDialog {

	private JPanel contentPane;
	public static JTable table;
	public static JComboBox comboBoxColores;
	public static JLabel lblError ;


	/**
	 * Create the frame.
	 */
	public GestionColor() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
				// ComboBox
				controller.GestionColorController.setComboBoxColor();
				//Pintamos tabla
				controller.GestionColorController.pintarTablaLogic();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 413);
		setModal(true);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
		setTitle("Gestión Colores");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panelBuscador = new JPanel();
		contentPane.add(panelBuscador, BorderLayout.NORTH);
		panelBuscador.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel("Gesti\u00F3n Colores");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelBuscador.add(lblTitulo);
		
		JPanel panelBuscador1 = new JPanel();
		panelBuscador.add(panelBuscador1);
		panelBuscador1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelBuscador2 = new JPanel();
		panelBuscador1.add(panelBuscador2);
		panelBuscador2.setLayout(null);
		
		JLabel lblNColores = new JLabel("Color:");
		lblNColores.setBounds(50, 7, 42, 22);
		lblNColores.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelBuscador2.add(lblNColores);
		
		comboBoxColores = new JComboBox();
		comboBoxColores.setBounds(122, 5, 388, 28);
		comboBoxColores.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panelBuscador2.add(comboBoxColores);
		
		JLabel btnBuscar = new JLabel("");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Pintamos tabla
				controller.GestionColorController.pintarTablaLogic();
			}
		});
		btnBuscar.setBounds(538, 8, 25, 25);
		btnBuscar.setIcon(new ImageIcon("images/lupa.jpg"));
		panelBuscador2.add(btnBuscar);
		
		JPanel panelBotones = new JPanel();
		panelBuscador1.add(panelBotones);
		
		JButton btnAgregar = new JButton("A\u00F1adir");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new FormGestionColor().setVisible(true);
			}
		});
		btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panelBotones.add(btnAgregar);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panelBotones.add(lblError);
		
		JPanel panelTablaColores = new JPanel();
		contentPane.add(panelTablaColores, BorderLayout.CENTER);
		panelTablaColores.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panelTablaColores.add(table, BorderLayout.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una fila
        table.setFillsViewportHeight(true); 

		
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		panelTablaColores.add(js);
	}
}
