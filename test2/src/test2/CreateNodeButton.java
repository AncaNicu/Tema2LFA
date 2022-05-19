package test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateNodeButton implements ActionListener {

	private Graph graph;
	private JLabel success;
	private JTextField createNewNodeValText;
	private JTextField createNewNodeKeyText;
	

	public CreateNodeButton(Graph graph, JLabel success, JTextField createNewNodeValText,
			JTextField createNewNodeKeyText) {
		super();
		this.graph = graph;
		this.success = success;
		this.createNewNodeValText = createNewNodeValText;
		this.createNewNodeKeyText = createNewNodeKeyText;
	}


public void actionPerformed(ActionEvent e) {
		
		success.setText("");
		
		String key = createNewNodeKeyText.getText();
		String val = createNewNodeValText.getText();
		
		StringOperation op1 = new StringOperation(key);
		StringOperation op2 = new StringOperation(val);
		
		
		int keyNr = op1.sAsNumber();
		int valNr = op2.sAsNumber();
		if(keyNr <= -1 || valNr <= -1)
		{
			success.setText("Cheia si valoarea trebuie sa fie numere intregi pozitive");
		}
		else
		{
			if(graph.checkIfNode(keyNr) == true)
			{
				success.setText("Nodul cu cheia " + 
			createNewNodeKeyText.getText() + " deja exista");
			}
			else
			{
				graph.addNode(keyNr, valNr);
				success.setText("Nodul cu cheia " + 
						createNewNodeKeyText.getText() + " si valoarea " +
						createNewNodeValText.getText() + " a fost adaugate cu succes");
				
				graph.printNodes();
			}
		}
	}

}
