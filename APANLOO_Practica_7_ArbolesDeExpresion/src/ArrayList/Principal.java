package ArrayList;

public class Principal {
	
	static Pila<Integer> numeros;
	static Pila<NodoAr> arboles;
	
	public static void main(String[] args) {
		
		numeros= new Pila<>();
		
		//se inicializa la pila de numeros con los datos: limites inferior, superior y los intervalos entre numeros (i.e. de 2 en 2)
		inicializaNumeros(0, 100, 10);
		//desplegamos la pila de numeros
		System.out.println("La pila de numeros en orden de ingreso es: \n" + numeros.despliega());
		//se sacan con patron LIFO 
		System.out.println("\nLa pila de numeros en orden de egreso es: \n" + numeros.despliegaReversa());
		
		//Tenemos los arboles:
		//---Arbol 1---
		NodoAr raiz= new NodoAr(5);
		
		raiz.izq= new NodoAr(4);
		raiz.der= new NodoAr(6);
		
		//---Arbol 2---
		NodoAr raiz2= new NodoAr(10);
		
		raiz2.izq= new NodoAr(8);
		
		raiz2.izq.der= new NodoAr(15);
		
		//---Arbol 3---
		NodoAr raiz3= new NodoAr(1);
		
		raiz3.izq= new NodoAr(2);
		
		raiz3.izq.izq= new NodoAr(3);
		raiz3.izq.der= new NodoAr(4);
		
		raiz3.izq.der.izq= new NodoAr(5);
		raiz3.izq.der.der= new NodoAr(6);
		
		//se crea una pila de tipo NodoAr
		arboles = new Pila<>();
		//se agregan los tres arboles
		arboles.push(raiz);
		arboles.push(raiz2);
		arboles.push(raiz3);
		//desplegamos la pila de arboles llamando a los recorridos de cada arbol
		System.out.println("\nLa pila de arboles en orden de ingreso: ");
		despliegaArboles();
		//sacamos a los arboles con patron LIFO
		System.out.println("\nLa pila de arboles en orden de egreso: ");
		despliegaArbolesReversa();
	}
	
	public static void inicializaNumeros(int valorInf, int valorSup, int intervalo) {
		
		for(int i=valorInf; i<=valorSup; i=i+intervalo) {
			numeros.push(i);
		}
	}
	
	public static void despliegaArboles() {
		
		int j=0;
		
		for(int i=0; i<arboles.pila.size(); i++){
			
			j=i+1;
			System.out.print("Arbol " + j + ": ");
			Recorridos.preorden(arboles.pila.get(i));
			System.out.print("\n");
		}
	}
	
	public static void despliegaArbolesReversa() {
		
		int i=arboles.pila.size()-1;
		int j=0;
			
		while (i>=0) {
			
			j=i+1;
			
			System.out.print("Arbol " + j + ": ");
			Recorridos.preorden(arboles.pila.get(i));
			System.out.print("\n");
			
			i--;
		}	
	}
}