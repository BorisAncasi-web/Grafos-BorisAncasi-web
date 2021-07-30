
public class GraphLink<G> {
	protected ListLinked<Vertex<G>> listVertex;
	
	public GraphLink() {
		listVertex = new ListLinked<Vertex<G>>();
	}
	
	public void insertVertex(G data) {
		Vertex<G> newv = new Vertex<G>(data);
		//System.out.println("Vertice por crear: "+newv);
		if(this.listVertex.searchElement(newv)!=null) {
			System.out.println("Vertice ya fue insertado anteriormente....");
			return;
		}
		this.listVertex.insertFirst(newv);
	}
	public void insertEdge(G verorigin ,G verDest) {
		Vertex<G> refOri = this.listVertex.searchElement(new Vertex<G>(verorigin));
		Vertex<G> refDes = this.listVertex.searchElement(new Vertex<G>(verDest));
		if(refOri == null || refDes == null) {
			System.out.println("Vertice origin y/o destino no se encuentran en la lista");
			return;
		}
		if(refOri.listAdj.searchElement(new Edge(refDes)) != null) {
			System.out.println("Arista ya insertada........");
			return;
		}
		refOri.listAdj.insertFirst(new Edge<G>(refDes));
		//refDes.listAdj.insertFirst(new Edge<G>(refOri)); para uno no dirigido debe haber correspodiente

		

	}
	public String toString() {
		return this.listVertex.toString();
	}

}
