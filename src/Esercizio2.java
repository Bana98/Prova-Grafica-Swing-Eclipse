import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;

import javax.swing.*;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

//cc.xyw(7, 13, 1)  primo parametro--> colonna, secondo parametro--> riga, terzo parametro -->quante colonne prendere per la larghezza

public class Esercizio2 extends JFrame {

	public Esercizio2()
	{
		super("Esercizio2");
		setSize(500, 700);  //setto le dimensioni della finestra
		setLocation(300, 300);  //la posizione nella quale deve apparire la finestra
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //serve per chiudere la finestra cliccando sulla X
		
		//prima le COLONNE (X), poi le RIGHE (Y)
		setLayout(new FormLayout("pref, 15px, 80px, 15px, 110px, 15px, 80px, 15px, min", "pref, 15px, pref, 15px, pref, 15px, pref, 15px, pref, 15px, pref, 15px, pref, 15px, pref, 15px, pref, 15px, pref, 15px"));
		
		CellConstraints cc = new CellConstraints();
		
		JLabel label1 = new JLabel("CIAO");
		add(label1, cc.xy(1, 1));
		
		JLabel label2 = new JLabel("Come stai?");
		add(label2, cc.xy(1, 3));
		
		JLabel label3 = new JLabel("In quale paese vivi?");
		add(label3, cc.xy(1, 5));
		
		final JTextField textField1 = new JTextField();
		add(textField1, cc.xyw(3, 1, 2));
		
		final JTextField textField2 = new JTextField();
		add(textField2, cc.xyw(3, 3, 2));	
		
		String[] stringhe = new String[] {"Italia", "Francia", "Germania", "Svizzera", "Spagna", "Brasile"}; //stringa che serve per la comboBox, le parole che appariranno nella tendina
		final JComboBox<String> comboBox = new JComboBox<>(stringhe);  //creo la comboBox, e in essa ci metto la stringa creata sopra con le parole (ovviamente)
		add(comboBox, cc.xyw(3, 5, 2));  //aggiungo la comboBox al frame come tutti gli altri componenti
		
		JLabel label4 = new JLabel("Cibo preferito");
		add(label4, cc.xy(1, 7));
		
		final JRadioButton radioButton1 = new JRadioButton("Pizza");  //creo i radioButton con i rispettivi nomi
		final JRadioButton radioButton2 = new JRadioButton("Pasta al sugo");
		final JRadioButton radioButton3 = new JRadioButton("Lasagne");
		ButtonGroup grouppoRadioButton = new ButtonGroup();  //buttonGroup per raggruppare i radioButton in un unico gruppo
		grouppoRadioButton.add(radioButton1);  //inserisco i tre radioButton dentro al groupBox
		grouppoRadioButton.add(radioButton2);
		grouppoRadioButton.add(radioButton3);
		add(radioButton1, cc.xy(3, 7));  //aggiungo i radioButton al frame
		add(radioButton2, cc.xy(5, 7));
		add(radioButton3, cc.xy(7, 7));
		
		JLabel label5 = new JLabel("Cosa manca in frigo");
		add(label5, cc.xy(1, 9));
		
		final JCheckBox checkBox1 = new JCheckBox("Latte");  //creo i checkBox  JCheckBox checkBox1 = new JCheckBox("Latte", true); se si vuole già selezionato uno dei checkBox
		add(checkBox1, cc.xy(3, 9));   //aggiungo i checkBox
		
		final JCheckBox checkBox2 = new JCheckBox("Cetrioli");  //creo i checkBox
		add(checkBox2, cc.xy(5, 9));   //aggiungo i checkBox
		
		final JCheckBox checkBox3 = new JCheckBox("Yogurt");  //creo i checkBox
		add(checkBox3, cc.xy(7, 9));   //aggiungo i checkBox
		
		
		JEditorPane editorPane = new JEditorPane();  //creo il pannello
		editorPane.setEditable(false);	//editable settato a false significa che non posso cambiare quello che c'è già scritto. Se lo setto a true posso cambiare il testo	
		//contenuto dell'editorPanel, è una stringa
		editorPane.setText("The JGoodies Forms framework helps you lay out and implement elegant Swing panels consistently and quickly. It aims to make simple things easy and the hard stuff possible, "
				+ "the good design easy and the bad difficult. This document introduces the Forms framework, analyzes weaknesses of existing layout systems, presents design goals, explains how these have "
				+ "been addressed, aquaints you with the Forms layout model and API, and compares Forms with other layout systems. Forms focuses on form-oriented panels much like the ‘Segment’ panel "
				+ "in the example below. Nevertheless, it is a general purpose layout system that can be used for the vast majority of rectangular layouts");
		
		JScrollPane editorScrollPane = new JScrollPane(editorPane);  //creo lo scrollPane e lo metto nel pannello 
		editorScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setPreferredSize(new Dimension(250, 145));
		editorScrollPane.setMinimumSize(new Dimension(10, 10));
		add(editorScrollPane, cc.xyw(1, 11, 9)); //aggiungo il tutto al frame

		JButton bottone = new JButton("SALVA");
		add(bottone, cc.xyw(7, 13, 1));
		//evento quando si preme il bottone
		bottone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//				JFrame frame = new JFrame();
				//			    frame.setVisible(true);
				//			    frame.setSize(100, 100);
				String nome = "C:\\prova.txt";
				FileWriter scrittore = null;
				try 
				{

					File file = new File(nome);
					if (!file.exists())
					{

						file.createNewFile();
					}

					scrittore = new FileWriter(file);  //per scrivere sul file di testo
					scrittore.write(textField1.getText());
					scrittore.write("   " + textField2.getText()); //scrittore.append(textField2.getText());
					scrittore.write("   " + comboBox.getSelectedItem().toString());  //scrivere ciò che è stato selezionato
					
					if(radioButton1.isSelected())  //controllo quale redioButton è stato selezionato, e lo scrivo sul file 
					{
						scrittore.write("   " + radioButton1.getText());
					}
					else if(radioButton2.isSelected())
					{
						scrittore.write("   " + radioButton2.getText());
					}
					else if(radioButton3.isSelected())
					{
						scrittore.write("   " + radioButton3.getText());
					}
					
					//controllo quale dei checkBox è selezionato e scrivo quelli selezionati
					if(checkBox1.isSelected())
					{
						scrittore.write("   " + checkBox1.getText());
					}
					
					if(checkBox2.isSelected())
					{
						scrittore.write("   " + checkBox2.getText());
					}
					
					if(checkBox3.isSelected())
					{
						scrittore.write("   " + checkBox3.getText());
					}
					
					
					
					scrittore.flush();

				}catch(Exception ep) {

				}finally{
					try {
						scrittore.close();  //chiudo lo scrittore
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			});
		


		setVisible(true);
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Esercizio2();
	}

}
