package ArbolExpresion;

import java.util.ArrayList;

public class Pila<Tipo> {
	
	ArrayList<Tipo> pila;
	
	public Pila(){
		this.pila= new ArrayList<Tipo>();
	}
	
	public void push(Tipo dato) {
		pila.add(dato);
	}
	
	public void pop() {
		pila.remove((pila.size())-1);
	}
	
	public Tipo valorTope() {
		
		Tipo valorTope= pila.get((pila.size())-1);
		
		return valorTope;
	}
	
	public boolean esVacia() {
		
		if(pila.isEmpty()==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void hazNula() {
		pila.clear();
	}
	
	public String despliega() {
		
		String pilaString="";
		
		for(int i=0; i<pila.size(); i++) {
			pilaString= pilaString + pila.get(i) + ", ";
		}
		
		return pilaString;
	}
	
	public String despliegaReversa() {
		
		String pilaString="";
		int i= pila.size()-1;
		
		while(i>=0) {
			pilaString= pilaString + pila.get(i) + ", ";
			i--;
		}
		
		return pilaString;
	}
	
	public int size() {
		return pila.size();
	}
}
