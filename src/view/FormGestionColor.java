package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormGestionColor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JColorChooser tcc = new JColorChooser();
	public static JLabel lblError;
	/**
	 * Create the dialog.
	 */
	public FormGestionColor() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(600, 450);
		setLocationRelativeTo(null);  // Para centrar el frame
		setResizable(false);
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		
			contentPanel.add(tcc);
			{
				 lblError = new JLabel("New label");
				contentPanel.add(lblError);
			}
			
			tcc.removeChooserPanel(tcc.getChooserPanels()[0]);
			tcc.removeChooserPanel(tcc.getChooserPanels()[1]);
			tcc.removeChooserPanel(tcc.getChooserPanels()[2]);
			tcc.removeChooserPanel(tcc.getChooserPanels()[0]);
			
		
				//System.out.println(tcc.getColor().getRGB());
				
				tcc.getSelectionModel().addChangeListener(
					    new ChangeListener() {
						public void stateChanged(ChangeEvent e) {
						    //Color newColor = tcc.getColor();
						    //banner.setForeground(newColor);
						    
						}
						
					    }
					    
					);
				
		{
			final JLabel banner = new JLabel("",
	                JLabel.CENTER);
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.GestionColorController.guardarColor();
					}
				});
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setActionCommand("Guardar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
