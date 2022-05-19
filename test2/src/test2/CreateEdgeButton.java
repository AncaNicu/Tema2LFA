package test2;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateEdgeButton implements Button {

	private Graph graph;
	//cheia si valoarea muchiei
		private JTextField createNewEdgeValText;
		private JTextField createNewEdgeKeyText;
		//pt nodul de start
		private JTextField startNodeKeyText;
		private JTextField stopNodeKeyText;
		private JLabel success;
		
	
	public CreateEdgeButton(Graph graph, JTextField createNewEdgeValText, JTextField createNewEdgeKeyText,
				JTextField startNodeKeyText, JTextField stopNodeKeyText, JLabel success) {
			super();
			this.graph = graph;
			this.createNewEdgeValText = createNewEdgeValText;
			this.createNewEdgeKeyText = createNewEdgeKeyText;
			this.startNodeKeyText = startNodeKeyText;
			this.stopNodeKeyText = stopNodeKeyText;
			this.success = success;
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		success.setText("");
		
		String edgekey = createNewEdgeKeyText.getText();
		String edgeval = createNewEdgeValText.getText();
		String node1 = startNodeKeyText.getText();
		String node2 = stopNodeKeyText.getText();
		
		StringOperation op1 = new StringOperation(edgekey);
		StringOperation op2 = new StringOperation(edgeval);
		StringOperation op3 = new StringOperation(node1);
		StringOperation op4 = new StringOperation(node2);
		
		
		int keyNr = op1.sAsNumber();
		int valNr = op2.sAsNumber();
		int node1Nr = op3.sAsNumber();
		int node2Nr = op4.sAsNumber();
		if(keyNr <= -1 || valNr <= -1 || node1Nr <= -1 || node2Nr <= -1)
		{
			success.setText("Valorile introduse trebuie sa fie numere intregi pozitive");
		}
		else
		{
			if(graph.checkIfValidAddEdge(node1Nr, node2Nr) == true && graph.existsEdgeWithKey(keyNr) == false)
			{
				graph.addEdge(keyNr, valNr, node1Nr, node2Nr);
				success.setText("Muchia a fost creata cu succes");
			}
			else
			{
				success.setText("Muchia nu a putut fi creata");
			}
		}
	}

}
