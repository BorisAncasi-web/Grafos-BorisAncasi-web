
public class Edge<T> {
	protected Vertex<T> refFinal;
	protected int weight;
	protected int label;
	public Edge(Vertex<T> refFinal) {
		this(refFinal,-1);
	}
	public Edge(Vertex<T> refFinal,int weight) {
		this.refFinal = refFinal;
		this.weight = weight;
	}
	public boolean equals(Object a) {
		if( a instanceof Edge<?>) {
			Edge<T> o = (Edge<T>)a;
			return this.refFinal.equals(o.refFinal);
		}
		return false;
		
	}
	public String toString() {
		if(this.weight > -1)
			return this.refFinal.data+" ["+this.weight+"], ";
		return refFinal.data+", ";
	}

}
