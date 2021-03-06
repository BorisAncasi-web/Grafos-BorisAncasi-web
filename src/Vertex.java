
public class Vertex<V> {
	protected V data;
	protected ListLinked<Edge<V>> listAdj;
	protected int label;
	
	public Vertex(V data) {
		this.data = data;
		this.listAdj = new ListLinked<Edge<V>>();
	}
	public boolean equals(Object a) {
		if( a instanceof Vertex<?>) {
			Vertex<V> o = (Vertex<V>)a;
			return this.data.equals(o.data);
		}
		return false;
	}
	public String toString() {
		return "label : "+label+"  "+this.data+" --> "+ this.listAdj.toString()+"\n";
	}

}
