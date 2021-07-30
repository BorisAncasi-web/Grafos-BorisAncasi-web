
public class Vertex<V> {
	protected V data;
	protected ListLinked<Edge<V>> listAdj;
	
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
		return this.data+" --> "+ this.listAdj.toString()+"\n";
	}

}
