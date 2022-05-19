package test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Main implementeaza ActionListener
//pt a putea realiza actiuni atunci cand este apasat butonul
public class Main
{

	private static Graph graph = new Graph();
	
	private static JFrame commandFrame;
	private static JPanel panel;
	
	
//DATE PT CREAREA UNUI NOD NOU
	private static JLabel createNewNodeKey;
	private static JTextField createNewNodeValText;
	private static JLabel createNewNodeVal;
	private static JTextField createNewNodeKeyText;
	private static JButton createNewNodeButton;
	
//DATE PT STERGEREA UNUI NOD
	private static JLabel deleteNodeKey;
	private static JTextField deleteNodeKeyText;
	private static JButton deleteNodeButton;
	
//DATE PT EDITAREA UNUI NOD
	//valorile vechi
	private static JLabel updateNodeOldKey;
	private static JTextField updateNodeOldKeyText;
	//valorile noi
	private static JLabel updateNodeNewKey;
	private static JTextField updateNodeNewValText;
	private static JLabel updateNodeNewVal;
	private static JTextField updateNodeNewKeyText;
	
	private static JButton updateNodeButton;
	
	
//DATE PT CREAREA UNEI MUCHII NOI
	//cheia si valoarea muchiei
	private static JLabel createNewEdgeKey;
	private static JTextField createNewEdgeValText;
	private static JLabel createNewEdgeVal;
	private static JTextField createNewEdgeKeyText;
	//pt nodul de start
	private static JLabel startNodeKey;
	private static JTextField startNodeKeyText;
	private static JLabel stopNodeKey;
	private static JTextField stopNodeKeyText;
	
	private static JButton createNewEdgeButton;
		
//DATE PT STERGEREA UNEI MUCHII		
	private static JLabel deleteEdgeKey;
	private static JTextField deleteEdgeKeyText;
	private static JButton deleteEdgeButton;		
	
//DATE PT EDITAREA UNEI MUCHII	

	//valorile vechi
	private static JLabel updateEdgeOldKey;
	private static JTextField updateEdgeOldKeyText;
	//valorile noi
	private static JLabel updateEdgeNewKey;
	private static JTextField updateEdgeNewValText;
	private static JLabel updateEdgeNewVal;
	private static JTextField updateEdgeNewKeyText;
		
	private static JButton updateEdgeButton;
	
	private static JLabel success;
	
	//fct pt a contrui panoul cu butoanele
	public static void buildController()
	{
		//CONFIGURAREA SPATIULUI DE LUCRU
		
				commandFrame = new JFrame();
				//seteaza dimens ferestrei
				commandFrame.setSize(1200, 400);
				//pt ca fereastra sa se inchida cand se apasa pe X
				commandFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//pt a face vizibila fereastra
				commandFrame.setVisible(true);
				
				//panel-ul este portiunea din fereastra unde se va pune continurul ferestrei
				panel = new JPanel();
				
				//adaugam panel-ul la fereastra
				commandFrame.add(panel);
				
				panel.setLayout(null);
				
				
		//PT ADAUGAREA UNUI NOD
				
				//setam eticheta pt cheia noului nod
				createNewNodeKey = new JLabel("Cheie nod nou");
				//setam limitele pt eticheta
				createNewNodeKey.setBounds(10, 20, 100, 25);
				//adaugam eticheta la panel
				panel.add(createNewNodeKey);
				
				//pt caseta unde se introduce cheia noului nod
				createNewNodeKeyText = new JTextField(100);
				//se adauga limite pt caseta
				createNewNodeKeyText.setBounds(130, 20, 50, 25);
				//adaugam caseta la panel
				panel.add(createNewNodeKeyText);
				
				//setam eticheta pt valoarea noului nod
				createNewNodeVal = new JLabel("Valoare nod nou");
				//setam limitele pt eticheta
				createNewNodeVal.setBounds(10, 50, 100, 25);
				//adaugam eticheta la panel
				panel.add(createNewNodeVal);
				
				//pt caseta text asociata valorii noului nod
				createNewNodeValText = new JTextField(100);
				createNewNodeValText.setBounds(130, 50, 50, 25);
				panel.add(createNewNodeValText);
				
				//butonul care declanseaza actiunea de creare a nodului
				createNewNodeButton = new JButton("Creeaza nod nou");
				createNewNodeButton.setBounds(10, 80, 150, 25);
				panel.add(createNewNodeButton);
				
				
				
		//PT STERGEREA UNUI NOD
				
				//setam eticheta pt cheia nodului de sters
				deleteNodeKey = new JLabel("Cheie nod");
				//setam limitele pt eticheta
				deleteNodeKey.setBounds(250, 20, 100, 25);
				//adaugam eticheta la panel
				panel.add(deleteNodeKey);
						
				//pt caseta unde se introduce cheia nodului de sters
				deleteNodeKeyText = new JTextField(5);
				//se adauga limite pt caseta
				deleteNodeKeyText.setBounds(370, 20, 50, 25);
				//adaugam caseta la panel
				panel.add(deleteNodeKeyText);
						
				
				//butonul care declanseaza actiunea de creare a nodului
				deleteNodeButton = new JButton("Sterge nod");
				deleteNodeButton.setBounds(250, 80, 150, 25);
				panel.add(deleteNodeButton);
				
				
		//PT EDITAREA UNUI NOD
				
				//nodul vechi
				
				//setam eticheta pt cheia veche a nodului de editat
				updateNodeOldKey = new JLabel("Cheie veche nod");
				//setam limitele pt eticheta
				updateNodeOldKey.setBounds(490, 20, 100, 25);
				//adaugam eticheta la panel
				panel.add(updateNodeOldKey);
								
				//pt caseta unde se introduce cheia nodului de editat
				updateNodeOldKeyText = new JTextField(5);
				//se adauga limite pt caseta
				updateNodeOldKeyText.setBounds(610, 20, 50, 25);
				//adaugam caseta la panel
				panel.add(updateNodeOldKeyText);
								
				//nodul nou
				
				updateNodeNewKey = new JLabel("Cheie noua nod");

				updateNodeNewKey.setBounds(730, 20, 100, 25);

				panel.add(updateNodeNewKey);
						
				updateNodeNewKeyText = new JTextField(5);

				updateNodeNewKeyText.setBounds(850, 20, 50, 25);

				panel.add(updateNodeNewKeyText);
						
				updateNodeNewVal = new JLabel("Valoare noua nod");

				updateNodeNewVal.setBounds(730, 50, 120, 25);

				panel.add(updateNodeNewVal);
						
				//pt caseta text asociata valorii noului nod
				updateNodeNewValText = new JTextField(100);
				updateNodeNewValText.setBounds(850, 50, 50, 25);
				panel.add(updateNodeNewValText);
						
				
				//butonul care declanseaza actiunea de editare a nodului
				updateNodeButton = new JButton("Editeaza nod");
				updateNodeButton.setBounds(600, 80, 150, 25);
				panel.add(updateNodeButton);
				
				
				
		//PT CREAREA UNEI MUCHII
				
				//cheia si valoarea muchiei
				
				//setam eticheta pt cheia noului nod
				createNewEdgeKey = new JLabel("Cheie muchie");
				//setam limitele pt eticheta
				createNewEdgeKey.setBounds(10, 150, 100, 25);
				//adaugam eticheta la panel
				panel.add(createNewEdgeKey);
						
				//pt caseta unde se introduce cheia noului nod
				createNewNodeKeyText = new JTextField(5);
				//se adauga limite pt caseta
				createNewNodeKeyText.setBounds(130, 150, 50, 25);
				//adaugam caseta la panel
				panel.add(createNewNodeKeyText);
						
				//setam eticheta pt valoarea noului nod
				createNewEdgeVal = new JLabel("Valoare muchie");
				//setam limitele pt eticheta
				createNewEdgeVal.setBounds(10, 180, 100, 25);
				//adaugam eticheta la panel
				panel.add(createNewEdgeVal);
						
				//pt caseta text asociata valorii noului nod
				createNewEdgeValText = new JTextField(100);
				createNewEdgeValText.setBounds(130, 180, 50, 25);
				panel.add(createNewEdgeValText);
				
				
				//pt cheia nodului de start
				
				//setam eticheta pt cheia nodului de sters
				startNodeKey = new JLabel("Cheie nod 1");
				//setam limitele pt eticheta
				startNodeKey.setBounds(250, 150, 100, 25);
				//adaugam eticheta la panel
				panel.add(startNodeKey);
								
				//pt caseta unde se introduce cheia nodului de sters
				startNodeKeyText = new JTextField(5);
				//se adauga limite pt caseta
				startNodeKeyText.setBounds(370, 150, 50, 25);
				//adaugam caseta la panel
				panel.add(startNodeKeyText);
				
				//pt nodul de stop
				
				//setam eticheta pt valoarea noului nod
				stopNodeKey = new JLabel("Cheie nod 2");
				//setam limitele pt eticheta
				stopNodeKey.setBounds(250, 180, 100, 25);
				//adaugam eticheta la panel
				panel.add(stopNodeKey);
								
				//pt caseta text asociata valorii noului nod
				stopNodeKeyText = new JTextField(100);
				stopNodeKeyText.setBounds(370, 180, 50, 25);
				panel.add(stopNodeKeyText);
						
				//butonul care declanseaza actiunea de creare a nodului
				createNewEdgeButton = new JButton("Creeaza muchie");
				createNewEdgeButton.setBounds(120, 210, 150, 25);
				panel.add(createNewEdgeButton);
				
				
		//PT STERGEREA UNEI MUCHII
				//setam eticheta pt cheia veche a nodului de editat
				deleteEdgeKey = new JLabel("Cheie muchie");
				//setam limitele pt eticheta
				deleteEdgeKey.setBounds(490, 150, 100, 25);
				//adaugam eticheta la panel
				panel.add(deleteEdgeKey);
										
				//pt caseta unde se introduce cheia nodului de editat
				deleteEdgeKeyText = new JTextField(5);
				//se adauga limite pt caseta
				deleteEdgeKeyText.setBounds(610, 150, 50, 25);
				//adaugam caseta la panel
				panel.add(deleteEdgeKeyText);
				
				//butonul care declanseaza actiunea de editare a nodului
				deleteEdgeButton = new JButton("Sterge muchie");
				deleteEdgeButton.setBounds(490, 210, 150, 25);
				panel.add(deleteEdgeButton);
				
				
		//PT EDITAREA UNEI MUCHII
				
				//muchie veche
				
				//setam eticheta pt cheia veche a nodului de editat
				updateEdgeOldKey = new JLabel("Cheie veche");
				//setam limitele pt eticheta
				updateEdgeOldKey.setBounds(730, 150, 100, 25);
				//adaugam eticheta la panel
				panel.add(updateEdgeOldKey);
										
				//pt caseta unde se introduce cheia nodului de editat
				updateEdgeOldKeyText = new JTextField(5);
				//se adauga limite pt caseta
				updateEdgeOldKeyText.setBounds(850, 150, 50, 25);
				//adaugam caseta la panel
				panel.add(updateEdgeOldKeyText);
				
				//muchie noua
				
				//setam eticheta pt cheia nodului de sters
				updateEdgeNewKey = new JLabel("Cheie noua");
				//setam limitele pt eticheta
				updateEdgeNewKey.setBounds(970, 150, 100, 25);
				//adaugam eticheta la panel
				panel.add(updateEdgeNewKey);
										
				//pt caseta unde se introduce cheia nodului de sters
				updateEdgeNewKeyText = new JTextField(5);
				//se adauga limite pt caseta
				updateEdgeNewKeyText.setBounds(1090, 150, 50, 25);
				//adaugam caseta la panel
				panel.add(updateEdgeNewKeyText);
						
						
				//setam eticheta pt valoarea noului nod
				updateEdgeNewVal = new JLabel("Valoare noua");
				//setam limitele pt eticheta
				updateEdgeNewVal.setBounds(970, 180, 100, 25);
				//adaugam eticheta la panel
				panel.add(updateEdgeNewVal);
										
				//pt caseta text asociata valorii noului nod
				updateEdgeNewValText = new JTextField(100);
				updateEdgeNewValText.setBounds(1090, 180, 50, 25);
				panel.add(updateEdgeNewValText);
				
				//butonul care declanseaza actiunea de editare a nodului
				updateEdgeButton = new JButton("Editeaza muchie");
				updateEdgeButton.setBounds(850, 210, 150, 25);
				panel.add(updateEdgeButton);
				
				//eticheta pt rezultat
				success = new JLabel("");
				success.setBounds(450, 300, 500, 25);
				panel.add(success);
	}
	
	public static void buttonActions()
	{
		createNewNodeButton.addActionListener(new CreateNodeButton(graph, success, createNewNodeValText,
				createNewNodeKeyText));
		
		
		deleteNodeButton.addActionListener(new DeleteNodeButton(graph,  deleteNodeKeyText, deleteNodeButton, success));
		
		updateNodeButton.addActionListener(new UpdateNodeButton(updateNodeOldKeyText, updateNodeNewValText,
				updateNodeNewKeyText, graph, success));
		
		createNewEdgeButton.addActionListener(new CreateEdgeButton(graph, createNewEdgeValText, createNewEdgeKeyText,
				startNodeKeyText, stopNodeKeyText, success));
		
		deleteEdgeButton.addActionListener(new DeleteEdgeButton(success, deleteEdgeKeyText, graph));
		
		updateEdgeButton.addActionListener(new UpdateEdgeButton(updateNodeOldKeyText, updateNodeNewValText,
				updateNodeNewKeyText, graph, success));
	}
	
	public static void main(String[] args) {

		buildController();
		buttonActions();
	}
}

