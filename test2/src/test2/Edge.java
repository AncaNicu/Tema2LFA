package test2;

public class Edge {
	private int key;
	private int val;
	public Edge()
	{
		key = 0;
		val = 0;
	}
	public Edge(int key, int val)
	{
		this.key = key;
		this.val = val;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
}
