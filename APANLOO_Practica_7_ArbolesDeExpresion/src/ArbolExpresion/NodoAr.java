package ArbolExpresion;

public class NodoAr{

	char dato;
	NodoAr izq;
	NodoAr der;
	
	public NodoAr(char dato, NodoAr izq, NodoAr der) {
		this.dato= dato;
		this.izq= izq;
		this.der= der;
	}
	
	public NodoAr(char dato) {
		this.dato= dato;
	}
}
