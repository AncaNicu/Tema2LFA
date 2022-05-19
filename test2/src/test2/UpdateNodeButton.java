package test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateNodeButton implements ActionListener {

	//valorile vechi
		private JTextField updateNodeOldKeyText;
		//valorile noi
		private JTextField updateNodeNewValText;
		private JTextField updateNodeNewKeyText;
		private Graph graph;
		private JLabel success;
		
	
	public UpdateNodeButton(JTextField updateNodeOldKeyText, JTextField updateNodeNewValText,
				JTextField updateNodeNewKeyText, Graph graph, JLabel success) {
			super();
			this.updateNodeOldKeyText = updateNodeOldKeyText;
			this.updateNodeNewValText = updateNodeNewValText;
			this.updateNodeNewKeyText = updateNodeNewKeyText;
			this.graph = graph;
			this.success = success;
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		success.setText("");
		
		String oldKey = updateNodeOldKeyText.getText();
		String newKey = updateNodeNewValText.getText();
		String newVal = updateNodeNewKeyText.getText();
		
		StringOperation op1 = new StringOperation(oldKey);
		StringOperation op2 = new StringOperation(newKey);
		StringOperation op3 = new StringOperation(newVal);
		
		
		int oldKeyNr = op1.sAsNumber();
		int newKeyNr = op2.sAsNumber();
		int newValNr = op3.sAsNumber();
		if(oldKeyNr <= -1 || newKeyNr <= -1 || newValNr <= -1)
		{
			success.setText("Datele introduse trebuie sa fie numere intregi pozitive");
		}
		else
		{
			if(graph.checkIfNode(oldKeyNr) == false)
			{
				success.setText("Nodul cu cheia " + 
						updateNodeOldKeyText.getText() + " nu exista in graf");
			}
			else
			{
				graph.updateNode(oldKeyNr, newKeyNr, newValNr);
				success.setText("Nodul a fost actualizat cu succes");
			}
		}
	}

}
