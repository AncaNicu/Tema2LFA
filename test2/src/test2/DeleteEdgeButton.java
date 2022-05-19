package test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteEdgeButton implements ActionListener {

	private JLabel success;
	private JTextField deleteEdgeKeyText;
	private Graph graph;
	
	
	
	public DeleteEdgeButton(JLabel success, JTextField deleteEdgeKeyText, Graph graph) {
		super();
		this.success = success;
		this.deleteEdgeKeyText = deleteEdgeKeyText;
		this.graph = graph;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		success.setText("");
		
		String key = deleteEdgeKeyText.getText();
		
		StringOperation op1 = new StringOperation(key);

		
		int keyNr = op1.sAsNumber();
		
		if(keyNr <= -1)
		{
			success.setText("Cheia trebuie sa fie numar intreg pozitiv");
		}
		else
		{
			if(graph.existsEdgeWithKey(keyNr) == false)
			{
				success.setText("Muchia cu cheia " + 
						deleteEdgeKeyText.getText() + " nu este muchie a grafului");
			}
			else
			{
				graph.deleteEdge(keyNr);
				success.setText("Muchia cu cheia " + 
						deleteEdgeKeyText.getText() + " a fost stearsa cu succes");
			}
		}
	}

}
