
public class ListLinked<T> {
	protected Node<T> first;
	public ListLinked() {
		this.first =null;
	}
	public boolean isEmpty() {
		return this.first ==null;
	}
	public String toString() {
    	String str = "";
    	Node<T> helper = this.first;
    	for(; helper != null; helper = helper.getNext())
    		str += helper.getData();
    	return str;	
    }
	  
	public void insertFirst(T x) {
		this.first = new Node<T>(x,this.first);
	}
	public T searchElement(T element) {
    	Node<T> aux = this.first;
    	while( aux != null && !aux.getData().equals(element)) {
    		aux = aux.getNext();
    	}
    	if(aux != null) {
    		return aux.getData();
    	}
    	return null;
    }
	public int search(T element) {
    	Node<T> aux = this.first;
    	for(int i=0; aux != null ;aux = aux.getNext(), i++) 
    		if(aux.getData().equals(element)) 
    			return i;
    	return -1;
    }
	public void remove(T x){
		   int pos = this.search(x);
		   if(pos!=-1) {
			   if(pos==0)
				   this.first = first.getNext();	
			   else {
				   Node<T> aux=this.first;
				   for(int i = 1;i <= pos-1;i++)//k-1 porque aux ya hizo auz ya ha sido declarado con la cabeza 
					   aux=aux.getNext();   
					aux.setNext(aux.getNext().getNext());
				   }
			   }
		   else {
			   System.out.println("Elemento no encotrado");
		   }	    		 
		}


}
