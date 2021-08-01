
public class Cola<E> {
	
    private Node<E> primero;
    private Node<E> ultimo;
    
    public Cola(){
        primero = ultimo = null;
    }

    
    public E ObtenerValorFinal(){
        return ultimo.getData();
    }
    public E ObtenerValorInicial(){
        return primero.getData();
    }

    public void Encolar(E elemento){
        Node<E> temporal = new Node<E>(elemento, null);
        if (ultimo == null){
            primero = ultimo = temporal;            
        }
        else{
            ultimo.setNext(temporal);
            ultimo = temporal;
        }
    }

    public E desencolar(){
        Node<E> helper = primero;

        if (primero != null) {  
        	
            primero = primero.getNext();
            if (primero == null){
                ultimo = null;
            }
            return helper.getData();
        }
        return null;
       
    }
    
    public boolean isEmpty(){
        return this.ultimo == null;
    }
    public String toString() {
    	String str = "";
    	Node<E> helper = this.primero;
    	System.out.println(ultimo+ " primero: "+ultimo);
    	for(; helper != null; helper = helper.getNext())
    		str += helper.getData()+",  ";
    	return str;	
    }

    public static void main(String[] args) {
        Cola <Integer> notas = new Cola<Integer>();
        notas.Encolar(1);
        notas.Encolar(0);
        notas.Encolar(10);
        notas.Encolar(11);
        System.out.println(notas);
        System.out.println(notas.desencolar());
        System.out.println(notas.desencolar());
        System.out.println(notas.desencolar());
        System.out.println(notas.desencolar());

        System.out.println(notas);
        notas.Encolar(11);
        System.out.println(notas);       
    }

}
