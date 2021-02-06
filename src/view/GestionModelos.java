package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionModelos extends JDialog {

	private JPanel contentPane;
	public static JTable table;
	public static JTextField textFieldMarcaorModelo;
	public static JLabel lblBusqueda;
	public static JComboBox comboBoxVisible;
	public static JLabel lblError;
	public static JButton btnEditar;


	/**
	 * Create the frame.
	 */
	public GestionModelos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				controller.GestionModelosController.btnEditarEnabled();
				controller.GestionModelosController.getComboboxVisible();
				controller.GestionModelosController.pintarTableModelo();
			}
		});
		setTitle("Gestión Modelos");
		setModal(true);
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
		panel_1.setLayout(null);
		
		textFieldMarcaorModelo = new JTextField();
		textFieldMarcaorModelo.setBounds(75, 11, 217, 20);
		PromptSupport.setPrompt("Búsqueda por Marca o Nombre", textFieldMarcaorModelo);
		panel_1.add(textFieldMarcaorModelo);
		textFieldMarcaorModelo.setColumns(10);
		
		comboBoxVisible = new JComboBox();
		comboBoxVisible.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxVisible.setBounds(302, 11, 122, 20);
		panel_1.add(comboBoxVisible);
		
		lblBusqueda = new JLabel("");
		lblBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.GestionModelosController.pintarTableModelo();
			}
		});
		lblBusqueda.setBounds(449, 9, 25, 25);
		lblBusqueda.setIcon(new ImageIcon("images/lupa.jpg"));
		panel_1.add(lblBusqueda);
		
		JPanel panel_2 = new JPanel();
		panelBuscador.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new FormModelo("Editar",controller.GestionModelosController.getSelectedRow()).setVisible(true);
			}
		});
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(btnEditar);
		
		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FormModelo m = new FormModelo("Añadir",null);
				m.setVisible(true);
				
				
			}
		});
		btnAnadir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(btnAnadir);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_2.add(lblError);
		
		JPanel paneltable = new JPanel();
		contentPane.add(paneltable, BorderLayout.CENTER);
		
		
		
		table = new JTable();
		paneltable.add(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				controller.GestionModelosController.btnEditarEnabled();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar una fila
		
		
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		contentPane.add(js);
	}
}
