package com.comtrade.view.rezervacija;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

import com.comtrade.controlerKi.KontrolerKi;
import com.comtrade.transfer.TransferKlasa;

import domen.Let;
import domen.Rezervacija;
import domen.Termin;
import domen.User;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RezervacijaFroma extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<Termin>listaTermina;
	private JComboBox comboBox_1;
	private List<Let>listLetova;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private int id_leta, id_termin;
	private String datum, vreme;
	private int preostaliBrojKarata;
	private User user;

	
	/**
	 * Create the frame.
	 * @param user 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public RezervacijaFroma(User user) throws ClassNotFoundException, IOException {
		this.user =user;
		System.out.println("kreiran objekat");
		listaTermina = (List<Termin>) KontrolerKi.getInsatanca().vratiTermine().getServer_objekat_response();
		listLetova = (List<Let>) KontrolerKi.getInsatanca().vratiSveLetove().getServer_objekat_response();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(100, 181, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Rezervisi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(preostaliBrojKarata >= Integer.parseInt(textField.getText())) {
					Rezervacija rezervacija = new Rezervacija();
					rezervacija.setBroj_karata(Integer.parseInt(textField.getText()));
					rezervacija.setId_termin(id_termin);
					rezervacija.setId_usera(user.getIdUsera());
					try {
					String poruka=  KontrolerKi.getInsatanca().upisiRezervaciju(rezervacija).getPoruka_response();
					JOptionPane.showMessageDialog(null, poruka);
					postaviPodatkeUTabelu();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"Nema dovoljno karata !!");
				}
			}
		});
		btnNewButton.setBounds(100, 212, 166, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Ukupan br karata");
		lblNewLabel_1.setBounds(10, 184, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		String naziv = comboBox_1.getSelectedItem().toString();
		 		for(Let let: listLetova) {
		 			if((let.getPolazak()+"--"+let.getDolazak()).equals(naziv)){
			 		id_leta = let.getId_let();
			 		break;
		 			}
		 		}
		 		postaviPodatkeUTabelu();
		 	}
		 });
		comboBox_1.setBounds(100, 23, 166, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Let");
		lblNewLabel_2.setBounds(28, 26, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(44, 67, 366, 103);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int red = table.getSelectedRow();
				id_leta = Integer.parseInt(table.getModel().getValueAt(red, 1).toString());
				id_termin = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				datum = table.getModel().getValueAt(red, 2).toString();
				vreme = table.getModel().getValueAt(red, 3).toString();
				preostaliBrojKarata = Integer.parseInt(table.getModel().getValueAt(red, 4).toString());
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		popuniCombo();
		Object[]kolone=new Object[5];
		kolone[0]="id_termin";
		kolone[1]="id_let";
		
		kolone[2]="datum";kolone[3]="vreme";
		kolone[4]="preostali broj karata";
		//table.removeColumn(table.getColumnModel().getColumn(0));

		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		postaviPodatkeUTabelu();
		
		  //public void setColumnVisible(TableColumn column, boolean visible);
		
		
	}



	private void postaviPodatkeUTabelu() {
		dtm.setRowCount(0);
		Object[]redovi= new Object[5];
		if(id_leta != 0) {
			for(Termin termin: listaTermina) {
				if(termin.getId_leta()== id_leta) {
				
				postaviRedove(termin, redovi);
				
				
				}
			}
			
		}else {
			for(Termin termin: listaTermina) {
				postaviRedove(termin, redovi);
			}
		}	
	}
	public  void postaviRedove(Termin termin , Object[]redovi){
		redovi[0]=termin.getId_termina();
		redovi[1]=termin.getId_leta();
		redovi[2]=termin.getDatum();
		redovi[3]=termin.getVreme();
		redovi[4]=termin.getUkupanBrojKarata();
		dtm.addRow(redovi);
		
	} 



	private void popuniCombo() {
		
		for(Let let : listLetova) {
			comboBox_1.addItem(let.getPolazak()+"--"+let.getDolazak());
		}
		
	}
}
