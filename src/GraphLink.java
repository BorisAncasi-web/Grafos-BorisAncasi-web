
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
		refDes.listAdj.insertFirst(new Edge<G>(refOri));// para uno no dirigido debe haber correspodiente

		

	}
	public String toString() {
		return this.listVertex.toString();
	}
	private void initLabel() {
		Node<Vertex<G>> helper = this.listVertex.first;
		for(; helper != null; helper = helper.getNext()) {
			helper.getData().label = 0;
			Node<Edge<G>> aux = helper.getData().listAdj.first;
			for(; aux != null; aux = aux.getNext())
				aux.getData().label = 0;	
		} 
	}
	//0: UNEXPLORED
	//1: VISITED
	//2 : BACK
	public void DFS(G data) {
		Vertex<G> search = this.listVertex.searchElement(new Vertex<G>(data));
		if(search == null) {
			System.out.println("Vertice no existe para hacer DFS....");
			return;
		}
		initLabel();
		DFSRec(search);

	}
	private void DFSRec(Vertex<G> a) {
		a.label = 1;
		System.out.print(a.data+"   ;");
		Node<Edge<G>> enlace = a.listAdj.first;
		for(; enlace != null; enlace = enlace.getNext()) {
			if(enlace.getData().label == 0) {
				Vertex<G> vert = enlace.getData().refFinal;
				if(vert.label == 0) {//no visitado
					enlace.getData().label = 1;//visitado
					DFSRec(vert);
				}
				else
					enlace.getData().label = 2;//tipo back
			}
		}
		
	}
	//0: UNEXPLORED
	//1: VISITED
	//2: CROSS
	public void BFS(G data) {
		Vertex<G> search = this.listVertex.searchElement(new Vertex<G>(data));
		if(search == null) {
			System.out.println("Vertice no existe para hacer DFS....");
			return;
		}
		initLabel();
		//DFSRec(search);

	}

}
