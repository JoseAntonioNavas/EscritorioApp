package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class GestionModelos extends JFrame {

	private JPanel contentPane;
	public static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionModelos frame = new GestionModelos();
					frame.setVisible(true);
					controller.GestionModelosController.pintarTableModelo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionModelos() {
		setTitle("Gestión Modelos");
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
		
		JPanel panel = new JPanel();
		panelBuscador.add(panel);
		
		JLabel lblTitutlo = new JLabel("Gesti\u00F3n Modelo");
		lblTitutlo.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		panel.add(lblTitutlo);
		
		JPanel panel_1 = new JPanel();
		panelBuscador.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panelBuscador.add(panel_2);
		
		JPanel paneltable = new JPanel();
		contentPane.add(paneltable, BorderLayout.CENTER);
		
		
		
		table = new JTable();
		paneltable.add(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				
				
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una fila
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		contentPane.add(js);
	}

}
