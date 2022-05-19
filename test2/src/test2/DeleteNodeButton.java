package test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteNodeButton implements ActionListener {

	private Graph graph;
	private JTextField deleteNodeKeyText;
	private JButton deleteNodeButton;
	private static JLabel success;
	
	
	public DeleteNodeButton(Graph graph, JTextField deleteNodeKeyText, JButton deleteNodeButton, JLabel success) {
		super();
		this.graph = graph;
		this.deleteNodeKeyText = deleteNodeKeyText;
		this.deleteNodeButton = deleteNodeButton;
		this.success = success;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		success.setText("");
		
		String key = deleteNodeKeyText.getText();
		
		StringOperation op1 = new StringOperation(key);

		
		int keyNr = op1.sAsNumber();
		
		if(keyNr <= -1)
		{
			success.setText("Cheia trebuie sa fie numar intreg pozitiv");
		}
		else
		{
			if(graph.checkIfNode(keyNr) == false)
			{
				success.setText("Nodul cu cheia " + 
						deleteNodeKeyText.getText() + " nu este nod al grafului");
			}
			else
			{
				graph.deleteNode(keyNr);
				success.setText("Nodul cu cheia " + 
						deleteNodeKeyText.getText() + " a fost sters cu succes");
				
				graph.printNodes();
			}
		}
	}

}
