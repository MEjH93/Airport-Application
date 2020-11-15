package com.comtrade.view.aviokomanija;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerKi.KontrolerKi;
import com.comtrade.transfer.TransferKlasa;

import domen.Aerodrom;
import domen.Aviokompanija;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class AvioKompanijaForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfNaziv;
	private JTable table;
	private JComboBox cbAerodrom;
	private int id_aerodroma;
	private List<Aerodrom> listAerodrom = null;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<Aviokompanija>listAviokompanija;
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public AvioKompanijaForma() throws ClassNotFoundException, IOException {
		
		listAerodrom=(List<Aerodrom>) KontrolerKi.getInsatanca().vratiSvePodatke().getServer_objekat_response();
		listAviokompanija= (List<Aviokompanija>) KontrolerKi.getInsatanca().vratiSveAviokompanije().getServer_objekat_response();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aerodrom");
		lblNewLabel.setBounds(10, 66, 80, 14);
		contentPane.add(lblNewLabel);
		
		 cbAerodrom = new JComboBox();
		 cbAerodrom.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		String naziv = cbAerodrom.getSelectedItem().toString();
		 		for(Aerodrom aerodrom : listAerodrom) {
		 			if(aerodrom.getNaziv().equals(naziv)) {
		 				id_aerodroma = aerodrom.getId_aerodrom();
		 			}
		 		}
		 		postaviSveAviokompanije();
		 		
		 	}
		 });
		cbAerodrom.setBounds(124, 63, 191, 20);
		contentPane.add(cbAerodrom);
		
		JLabel lblNewLabel_1 = new JLabel("Avio komanija");
		lblNewLabel_1.setBounds(10, 150, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNaziv = new JTextField();
		tfNaziv.setBounds(124, 147, 86, 20);
		contentPane.add(tfNaziv);
		tfNaziv.setColumns(10);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Aviokompanija aviokomanija = new Aviokompanija();
				aviokomanija.setNaziv(tfNaziv.getText());
				aviokomanija.setId_aerodrom(id_aerodroma);
				try {
					aviokomanija = (Aviokompanija) KontrolerKi.getInsatanca().upisiAviokompaniju(aviokomanija).getServer_objekat_response();
					System.out.println(aviokomanija);
					listAviokompanija.add(aviokomanija);
					postaviSveAviokompanije();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUnesi.setBounds(44, 216, 89, 23);
		contentPane.add(btnUnesi);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(186, 216, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(307, 216, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(44, 303, 352, 131);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		postaviPodatkeUcombo();
		
		Object[]kolone= new Object[2];
		kolone[0]="ID";
		kolone[1]="Naziv";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		postaviSveAviokompanije();
	}


	private void postaviSveAviokompanije() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		Object[]red = new Object[2];
		
			if(id_aerodroma != 0 ) {
				for(Aviokompanija aviokompanija : listAviokompanija) {
					if(aviokompanija.getId_aerodrom() == id_aerodroma) {
						setRed(aviokompanija, red);
					}
				}
			}else {
				for(Aviokompanija aviokompanija : listAviokompanija) {
					setRed(aviokompanija, red);
				}
				
			
			
		}
		
	}
		public void setRed(Aviokompanija aviokompanija , Object[]red) {
			int id = aviokompanija.getId_aviokompanije();
			String naziv = aviokompanija.getNaziv();
			red[0]=id;
			red[1]=naziv;
			dtm.addRow(red);
		}
	private void postaviPodatkeUcombo() {
		cbAerodrom.addItem("--Izaberi aerodrom--");
			for(Aerodrom aerodrom : listAerodrom) {
				cbAerodrom.addItem(aerodrom.getNaziv());
			}
		} 
		
		
	
}
