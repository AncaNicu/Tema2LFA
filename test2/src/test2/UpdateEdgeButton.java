package test2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateEdgeButton implements ActionListener {
	
	//valorile vechi
		private JTextField updateEdgeOldKeyText;
		//valorile noi
		private JTextField updateEdgeNewValText;
		private JTextField updateEdgeNewKeyText;
		private Graph graph;
		
		private JLabel success;
		
	
	public UpdateEdgeButton(JTextField updateEdgeOldKeyText, JTextField updateEdgeNewValText,
				JTextField updateEdgeNewKeyText, Graph graph, JLabel success) {
			super();
			this.updateEdgeOldKeyText = updateEdgeOldKeyText;
			this.updateEdgeNewValText = updateEdgeNewValText;
			this.updateEdgeNewKeyText = updateEdgeNewKeyText;
			this.graph = graph;
			this.success = success;
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		success.setText("");
		
		String oldKey = updateEdgeOldKeyText.getText();
		String newKey = updateEdgeNewKeyText.getText();
		String newVal = updateEdgeNewValText.getText();
		
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
			if(graph.existsEdgeWithKey(oldKeyNr) == false)
			{
				success.setText("Muchia cu cheia " + 
						updateEdgeOldKeyText.getText() + " nu exista in graf");
			}
			else
			{
				graph.updateEdge(oldKeyNr, newKeyNr, newValNr);
				success.setText("Muchia a fost actualizata cu succes");
			}
		}
	}

}
