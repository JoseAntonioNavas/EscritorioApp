package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.prompt.PromptSupport;

import controller.GestionMarcasController.MarcasAPI;
import controller.GestionUsuarioController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionMarcas extends JFrame {

	private JPanel contentPane;
	public static JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblTitulo;
	public static  JLabel lblMarca;
	public static JTextField txtFieldMarca;
	private JLabel lblNewLabel_1;
	public static JComboBox comboBoxVisible;
	private JLabel lblBusqueda;
	private JButton btnEditar;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionMarcas frame = new GestionMarcas();
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
	public GestionMarcas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				// ComboBox
				controller.GestionMarcasController.getComboboxVisible();
				controller.GestionMarcasController.pintarTableMarcas();
				
			}
		});
		setTitle("Gestión Marcas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 413);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel = new JPanel();
		panelTitulo.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblTitulo = new JLabel("Gesti\u00F3n Marcas");
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		panel.add(lblTitulo);
		
		panel_1 = new JPanel();
		panelTitulo.add(panel_1);
		panel_1.setLayout(null);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(32, 12, 42, 20);
		lblMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblMarca);
		
		txtFieldMarca = new JTextField();
		PromptSupport.setPrompt("Búsqueda Nombre Marca", txtFieldMarca);
		txtFieldMarca.setBounds(84, 12, 214, 25);
		panel_1.add(txtFieldMarca);
		txtFieldMarca.setColumns(25);
		
		lblNewLabel_1 = new JLabel("Visible:");
		lblNewLabel_1.setBounds(329, 12, 44, 20);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1);
		
		comboBoxVisible = new JComboBox();
		comboBoxVisible.setBounds(383, 8, 117, 28);
		comboBoxVisible.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(comboBoxVisible);
		
		lblBusqueda = new JLabel("");
		lblBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GestionMarcasController.pintarTableMarcas();
			}
		});
		lblBusqueda.setIcon(new ImageIcon("images/lupa.jpg"));
		lblBusqueda.setBounds(521, 8, 25, 25);
		panel_1.add(lblBusqueda);
		
		panel_2 = new JPanel();
		panelTitulo.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(btnEditar);
		
		btnAgregar = new JButton("A\u00F1adir");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.GestionMarcasController.abrirFormMarcas("Añadir");
				
			}
		});
		btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(btnAgregar);
		
		JPanel panelTabla = new JPanel();
		contentPane.add(panelTabla, BorderLayout.CENTER);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panelTabla.add(table, BorderLayout.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una fila
        table.setFillsViewportHeight(true); 

		
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		panelTabla.add(js);
	}
	
	
	


}
