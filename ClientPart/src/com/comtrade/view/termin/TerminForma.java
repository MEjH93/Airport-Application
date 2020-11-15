package com.comtrade.view.termin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import com.comtrade.controlerKi.KontrolerKi;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

import domen.Aviokompanija;
import domen.Let;
import domen.Termin;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class TerminForma extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<Let>listLetovi;
private JComboBox comboBox;
private List<Aviokompanija>listAvio;
private JComboBox comboBox_1;
private JSpinner casovi, minuti;
private int idLeta;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public TerminForma() throws ClassNotFoundException, IOException {
		listLetovi = (List<Let>) KontrolerKi.getInsatanca().vratiSveLetove().getServer_objekat_response();
		listAvio = (List<Aviokompanija>)KontrolerKi.getInsatanca().vratiSveAviokompanije().getServer_objekat_response();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(64, 109, 134, 20);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String datum = dateFormat.format(dateChooser.getDate());
				int ukupanBrojKarata =Integer.parseInt(textField.getText());
				int satI = Integer.parseInt(casovi.getModel().getValue().toString());
				int minut = Integer.parseInt(minuti.getValue().toString());
				if(satI >= 0 && satI<= 23 && minut >= 0 && minut <= 59) {
					Termin termin = new Termin();
					termin.setDatum(LocalDate.parse(datum));
					termin.setVreme(LocalTime.of(satI, minut));
					termin.setId_leta(idLeta);
					termin.setUkupanBrojKarata(ukupanBrojKarata);
					try {
						KontrolerKi.getInsatanca().upisiTermin(termin);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
					JOptionPane.showMessageDialog(null, "Niste uneli dobro podatke !!");
				}
				
			}
		});
		btnNewButton.setBounds(64, 179, 89, 23);
		contentPane.add(btnNewButton);
		
		 casovi = new JSpinner();
		casovi.setBounds(258, 109, 29, 20);
		contentPane.add(casovi);
		
		 minuti = new JSpinner();
		 minuti.setBounds(352, 109, 29, 20);
		contentPane.add(minuti);
		
		JLabel lblNewLabel = new JLabel("H");
		lblNewLabel.setBounds(228, 109, 20, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M");
		lblNewLabel_1.setBounds(322, 115, 20, 14);
		contentPane.add(lblNewLabel_1);
		
		 comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		String naziv = comboBox.getSelectedItem().toString();
		 		StringBuilder builder = new StringBuilder();
		 		for(Let l : listLetovi) {
		 			builder.append(l.getPolazak()+"--"+l.getDolazak());
		 			if(naziv.equals(builder.toString())) {
		 				idLeta = l.getId_let();
		 			}
		 			builder.setLength(0);
		 		}
		 		
		 	}
		 });
		comboBox.setBounds(96, 55, 167, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(67, 140, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setBounds(96, 8, 167, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Avio kompanija");
		lblNewLabel_2.setBounds(0, 11, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Let");
		lblNewLabel_3.setBounds(10, 58, 46, 14);
		contentPane.add(lblNewLabel_3);
		popuniComboBox();
	}

	private void popuniComboBox() {
		for(Let let : listLetovi) {
			comboBox.addItem(let.getPolazak()+"--"+let.getDolazak());
		}
		for(Aviokompanija aviokompanija : listAvio) {
			comboBox_1.addItem(aviokompanija.getNaziv());
		}
		
	}
}
