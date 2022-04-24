package Infija_Postfija;

public class Principal {

	public static void main(String[] args) {
		
		String infija= "A+B";
		System.out.println("Expresion Infija: " + infija);
		System.out.println("Expresion Postfija: " + infijaToPostfija(infija));
		
		String infija2= "(A+B)/(C^D)";
		System.out.println("\nExpresion Infija 2: " + infija2);
		System.out.println("Expresion Postfija 2: " + infijaToPostfija(infija2));
	}
	
	public static String infijaToPostfija(String infija) {
		
		char letra;
		String postfija= "";
		Pila<Character> pilaChars= new Pila<>();
		
		//seaparamos los caracteres del string infija
		for(int i=0; i<infija.length(); i++) {
			
			//guardamos cada caracter de la cadena infija en la variable letra
			letra= infija.charAt(i);  
			
			//si es un operador
			if((letra=='+') || (letra=='-') || (letra=='*') || (letra=='/') || (letra=='^') || (letra=='(') || (letra==')')) {
				
				System.out.println(letra + " Operador o parentesis.");
				
				
				//si la pila esta vacia, agregamos el operador a la pila
				if(pilaChars.esVacia()==true) {
					
					pilaChars.push(letra);
				}
				//si no esta vacia,
				else {
					
					//si no es un parentesis que cierra
					if(letra!= ')') {
						
						/*usando la tabla de prioridades, comparamos el valorTope de la pila con el caracter a ingresar.
						 * Si la prioridad del operador en la expresion es mayor que el operador que esta en la pila, 
						 * el operador de la expresion se mete a la pila. 
						 * en caso de que se menor, el operador de la pila se saca y se mete a la postfija.
						 * Se repite el proceso con el operardor de la expresion. 
						 */
						if(prioridadExpresion(letra) > prioridadPila(pilaChars.valorTope())) {
							pilaChars.push(letra);
						}
						else {
							
							while(pilaChars.esVacia()==false) {
								postfija= postfija + pilaChars.valorTope();
								System.out.println("Expresion Postfija: " + postfija);
								pilaChars.pop();
							}
						}
					}
					/*si es un parentesis que cierra, sacamos todo lo de la pila (hasta toparnos con un parentesis que abre)
					y lo pasamos a la cadena postfija*/
					else {
						
						while(pilaChars.valorTope() != '(') {
							
							postfija= postfija + pilaChars.valorTope();
							System.out.println("Expresion Postfija: " + postfija);
							pilaChars.pop();
						}
						
						pilaChars.pop();
					}
				}
			}
			//si es un operando
			else {
				System.out.println(letra + " Operando.");
				//si es un operando, lo agregamos a postfija
				postfija= postfija + letra;
				System.out.println("Expresion Postfija: " + postfija);
			}
		}
		
		//si la pila tiene elementos, los sacamos y los metemos a la postfija
		while(pilaChars.esVacia()==false) {
			
			char operador= pilaChars.valorTope();
			pilaChars.pop();
			
			postfija= postfija + operador;
			System.out.println("Expresion Postfija: " + postfija);
		}
		
		return postfija;
	}
	
	public static int prioridadExpresion(char letra) {
		
		int prioridad=0;
		
		switch(letra) {
		
		case '(':
			prioridad=5;
			break;
		case '^':
			prioridad=4;
			break;
		case '*', '/':
			prioridad=2;
			break;
		case '+', '-':
			prioridad=1;
			break;
		}
		
		return prioridad;
	}
	
	public static int prioridadPila(char operadorPila) {
		
		int prioridad=0;
		
		switch(operadorPila) {
		
		case '(':
			prioridad=0;
			break;
		case '^':
			prioridad=3;
			break;
		case '*', '/':
			prioridad=2;
			break;
		case '+', '-':
			prioridad=1;
		}
		
		return prioridad;
	}
}
