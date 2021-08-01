
public class Test {
	public static void main(String[]args) {
		GraphLink<String> grafo = new GraphLink<String>();
		grafo.insertVertex("lima");
		grafo.insertVertex("aqp");
		grafo.insertVertex("cusco");
		grafo.insertVertex("piura");
		grafo.insertVertex("tarapoto");
		grafo.insertVertex("puno");
		grafo.insertVertex("tacna");
		
		grafo.insertEdge("lima", "aqp");
		grafo.insertEdge("cusco", "aqp");
		grafo.insertEdge("piura", "lima");
		grafo.insertEdge("cusco", "lima");
		grafo.insertEdge("piura", "tarapoto");
		//grafo.insertEdge("puno", "tacna");


		
		System.out.println("Grafo ciudades:\n"+grafo);
		System.out.println("Recorrido en DFS");
		grafo.DFS("aqp");
		System.out.println("\nRecorrido en DFS");
		grafo.DFS("tacna");
		System.out.println("\nRecorrido en BFS");
		grafo.BFS("aqp");
		System.out.println("Grafo ciudades:\n"+grafo);

		
		


	}

}
