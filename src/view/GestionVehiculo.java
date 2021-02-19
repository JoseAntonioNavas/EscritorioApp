package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GestionVehiculo extends JFrame {
	private JPanel contentPane;
	public static JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblTitulo;
	public static JTextField txtBusqueda;
	public static JButton btnEditar;
	public static JButton btnAgregar;
	public static JButton btnBorrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionVehiculo frame = new GestionVehiculo();
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
	public GestionVehiculo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				controller.GestionVehiculoController.pintarTableVehiculos();
				
			}
		});
		
		setTitle("Gestión Vehiculos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 413);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
			
		
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscador = new JPanel();
		contentPane.add(panelBuscador, BorderLayout.NORTH);
		panelBuscador.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel = new JPanel();
		panelBuscador.add(panel);
		
		lblTitulo = new JLabel("Gesti\u00F3n Veh\u00EDculos en Cat\u00E1logo");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		panel.add(lblTitulo);
		
		panel_1 = new JPanel();
		panelBuscador.add(panel_1);
		panel_1.setLayout(null);
		
		txtBusqueda = new JTextField();
		PromptSupport.setPrompt("Búsqueda por Marca, Modelo, Matricula, Potencia o Precio", txtBusqueda);
		txtBusqueda.setBounds(64, 15, 390, 25);
		txtBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		JLabel lblBusqueda = new JLabel("");
		lblBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GestionVehiculoController.pintarTableVehiculos();
			}
		});
		lblBusqueda.setIcon(new ImageIcon("images/lupa.jpg"));
		lblBusqueda.setBounds(478, 15, 25, 25);
		panel_1.add(lblBusqueda);
		
		panel_2 = new JPanel();
		panelBuscador.add(panel_2);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormVehiculosCatalogo("Borrar").setVisible(true);
			}
		});
		btnBorrar.setEnabled(false);
		btnBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(btnBorrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormVehiculosCatalogo("Editar").setVisible(true);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(btnEditar);
		
		btnAgregar = new JButton("A\u00F1adir");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new FormVehiculosCatalogo("Añadir").setVisible(true);
			}
		});
		btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(btnAgregar);
		
		JPanel panelTabla = new JPanel();
		contentPane.add(panelTabla, BorderLayout.CENTER);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panelTabla.add(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				controller.GestionVehiculoController.changeBtn();
			
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una fila
		
		
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		contentPane.add(js);
		
		
	}
}
