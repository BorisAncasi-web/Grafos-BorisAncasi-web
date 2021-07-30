
public class Test {
	public static void main(String[]args) {
		GraphLink<String> grafo = new GraphLink<String>();
		grafo.insertVertex("lima");
		grafo.insertVertex("aqp");
		grafo.insertVertex("cusco");
		grafo.insertVertex("piura");
		grafo.insertVertex("tarapoto");
		grafo.insertEdge("lima", "aqp");
		grafo.insertEdge("cusco", "aqp");
		grafo.insertEdge("piura", "lima");
		grafo.insertEdge("cusco", "lima");
		grafo.insertEdge("piura", "tarapoto");
		grafo.insertEdge("tarapoto", "piura");

		
		System.out.println("Grafo ciudades:\n"+grafo);


	}

}
