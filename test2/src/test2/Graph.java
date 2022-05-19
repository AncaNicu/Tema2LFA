package test2;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	//lista de noduri
	List<Node> nodeList;
	
	//matricea de adiacenta
	private Edge adj[][];
	public Graph()
	{
		nodeList = new ArrayList<Node>();
		
		adj = new Edge[100][100];
		int i, j;
		for(i = 0; i <100; i++)
		{
			for(j = 0; j <100; j++)
			{
				adj[i][j] = new Edge();
				adj[i][j].setKey(-1);
			}
		}
	}
	
	//pt a vedea daca un nod cu o anumita cheie deja exista in graf
	public boolean checkIfNode(int key)
	{
		for(Node node: nodeList)
		{
			if(node.getKey() == key)
			{
				return true;
			}
		}
		return false;
	}
	
	//pt a adauga un nou nod in lista fde noduri a grafului
	public void addNode(int key, int val)
	{
		Node node = new Node(key, val);
		nodeList.add(node);
	}
	
	//pt a vedea daca exista deja muchie intre 2 noduri
	//folosita pt fct de adaugare muchie
	public boolean isEdgeWithNodes(int node1, int node2)
	{
		if(adj[node1][node2].getKey() != -1)
		{
			return true;
		}
		return false;
	}
	
	//pt a vedea daca exista o muchie cu o anumita cheie
	//folosita pt functia de stergere a unei muchii
	public boolean existsEdgeWithKey(int key)
	{
		int i, j;
		for(i=0 ; i<=99 ; i++)
		{
			for(j=0 ; j<=99; j++)
			{
				if(adj[i][j].getKey() == key)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	//creeaza muchie intre 2 noduri
	public void addEdge(int key, int val, int lin, int col)
	{
		adj[lin][col].setKey(key);
		adj[lin][col].setVal(val);
		
		adj[col][lin].setKey(key);
		adj[col][lin].setVal(val);
	}
	
	//pt a actualiza un nod
	public void updateNode(int key, int newKey, int newVal)
	{
		for(Node node: nodeList)
		{
			if(node.getKey() == key)
			{
				node.setKey(newKey);
				node.setVal(newVal);
			}
		}
	}
	
	//pt a actualiza cheia si valoarea unei muchii cu o anumita cheie
	public void updateEdge(int key, int newKey, int newVal)
	{
		int i, j;
		for(i=0 ; i<=99 ; i++)
		{
			for(j=0 ; j<=99; j++)
			{
				if(adj[i][j].getKey() == key)
				{
					adj[i][j].setKey(newKey);
					adj[i][j].setVal(newVal);
				}
			}
		}
	}
	
	//pt a sterge un nod la lista de noduri
	public void deleteNode(int key)
	{
		for(Node node: nodeList)
		{
			if(node.getKey() == key)
			{
				nodeList.remove(node);
			}
		}
	}
	
	//pt a sterge o muchie
	//stergerea inseamna a pune in matr de adiacenta -1
	//drept cheie
	public void deleteEdge(int key)
	{
		int i, j;
		for(i=0 ; i<=99 ; i++)
		{
			for(j=0 ; j<=99; j++)
			{
				if(adj[i][j].getKey() == key)
				{
					adj[i][j].setKey(-1);
				}
			}
		}
	}
	
	//pt a verifica daca exista nod1 si nod2 
	//pt a putea adauga o muchie
	public boolean checkIfValidAddEdge(int node1, int node2)
	{
		//pt a verif daca nodul 1 exista in lista
		boolean foundNode1 = false;
		
		//pt a verif daca nodul 2 exista in lista
		boolean foundNode2 = false;
		
		for(Node node: nodeList)
		{
			if(node.getKey() == node1)
			{
				foundNode1 = true;
			}
			if(node.getKey() == node2)
			{
				foundNode2 = true;
			}
		}
		
		if(foundNode1 == true && foundNode2 == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//pt a afisa lista de noduri
	public void printNodes()
	{
		System.out.println("Nodurile: ");
		for(Node node: nodeList)
		{
			System.out.println("cheie: " + node.getKey() + "; valoare: " + node.getVal());
		}
	}
	
	//pt a afisa muchiile
	public void printEdges()
	{
		int i, j;
		System.out.println("Muchiile: ");
		for(i=0 ; i<=99 ; i++)
		{
			for(j=0 ; j<=99; j++)
			{
				if(adj[i][j].getKey() != -1 && i<j)
				{
					System.out.println("cheie: " + adj[i][j].getKey()
							+ "; valoare: " + adj[i][j].getVal()
							+ "; nod1: " + i + "; nod2: " + j);
				}
			}
		}
	}
}
