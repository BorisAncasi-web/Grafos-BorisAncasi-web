
public class ListLinked<T> implements TDAList<T> {
	private Node<T> first;
	protected int count;
	public ListLinked() {
		this.first =null;
		this.count = 0;
	}
	public Node<T> getFirst() {
		return this.first;
	}
	public void setFirst(Node<T> a) {
		this.first =a;
	}
	public boolean isEmpty() {
		return this.first ==null;
	}
	public int length() {
		return count;
	}
	//para todo los lenguajes
	public void destroyList() {
		while(this.first != null)
			this.first = this.first.getNext();
		this.count = 0;
	}
	 //Retorno al anterior nodo hago el enlace con el nuevo y que es nuevo tenga un enlace con el siguiente del anterior
    public void insertIndex(T element, int k) {
    	if(count>=k) {
    		if (k==0)
    			this.insertFirst(element);
    		else if(count==k)
    			this.insertLast(element);
    		else {
    			Node<T> aux=this.first;
    			for(int i = 1;i <= k-1;i++)//k-1 porque aux ya hizo auz ya ha sido declarado con la cabeza 
    				aux=aux.getNext();
    			aux.setNext(new Node<T>(element,aux.getNext()));
    			count++;
    		}	
    	}
    	else
    		System.out.println("IndexOutBoundedException");
    	
    }
    public T searchFor(int k) {
    	if(k>0 && k<=count) {
    		if(k==1)
    			return this.first.getData();
    		else if(k==count)
    			return this.getLastNode().getData();
    		else {
    			Node<T> aux=this.first;
    			for(int i = 1;i <= k-1;i++)//k-1 porque aux ya hizo auz ya ha sido declarado con la cabeza 
    				aux=aux.getNext();
    			return aux.getData();
    		}		
    	}
    	else {
    		return null;
    	}
    }
	public void insertLast(T x) {
		if(this.first==null)
			this.insertFirst(x);
		else {
			Node<T>lastNode = getLastNode();
			lastNode.setNext(new Node<T>(x));
			count++;
		}	
	}
	private Node<T> getLastNode(){
		Node<T> aux = this.first;
		while(aux.getNext()!=null)
			aux = aux.getNext();
		return aux;
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
		   count--;
		   }
	   else {
		   System.out.println("Elemento no encotrado");
	   }	    		 
	}
	public String toString() {
    	String str = "";
    	Node<T> helper = this.first;
    	for(; helper != null; helper = helper.getNext())
    		str += helper.getData()+",  ";
    	return str;
    	
    }
	  
	
	public void insertFirst(T x) {
		this.first = new Node<T>(x,this.first);
		this.count++;
	}
	public int search(T element) {
    	Node<T> aux = this.first;
    	for(int i=0; aux != null ;aux = aux.getNext(), i++) 
    		if(aux.getData().equals(element)) 
    			return i;
    	return -1;
    }
	

}
