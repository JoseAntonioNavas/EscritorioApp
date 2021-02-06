package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BusquedaVehiculo;
import model.Vehiculo;
import service.VehiculoService;

import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


public class GestionVehiculo extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblTitulo;

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
				BusquedaVehiculo b = new BusquedaVehiculo("");
				try {
					List<Vehiculo> v = VehiculoService.getAllVehiculos(b);
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		lblTitulo = new JLabel("Gesti\u00F3n Veh\u00EDculos");
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		panel.add(lblTitulo);
		
		panel_1 = new JPanel();
		panelBuscador.add(panel_1);
		
		panel_2 = new JPanel();
		panelBuscador.add(panel_2);
		
		JPanel panelTabla = new JPanel();
		contentPane.add(panelTabla, BorderLayout.CENTER);
		
		table = new JTable();
		panelTabla.add(table);
		
		
	}
	

}
