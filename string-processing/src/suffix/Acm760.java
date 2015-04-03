/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suffix;

class Acm760
{	
	///Punto de entrada del programa...
	public static void main(String args[])
	{
		///VARIABLES LOCALES
		
		ElementoListaPos posicionLetrasCadena2[]; ///Array de punteros a las listas ligadas de posiciones de cada letra que aparece en la segunda cadena.
		
		String cadena1 = ""; ///cadena1
		String cadena2 = ""; ///cadena2
		String output = ""; ///output del programa
		
		
		///CODIGO LOCAL
		
		//cadena1 = "sadfkjhxasdg";
		//cadena2 = "sadxfkjhasdg";
		
		while( true )
		{
			cadena1 = leerLinea();
			cadena2 = leerLinea();

			
			posicionLetrasCadena2 = new ElementoListaPos[256];
			
			///inicializar la lista de listas ligadas de las posiciones de los
			///caracteres que aparecen en el programa
			inicializarLetras(posicionLetrasCadena2, cadena2);
		
			///buscar secuencias de caracteres comunes...
			output += buscarSecuencias(posicionLetrasCadena2, cadena1, cadena2) + "\n";
			
			if ( leerLinea() == null ) break;
		}
		
		///imprimir las listas de posiciones de caracteres ocurrentes en cadena2
		///debugImprimirListasDeLetras(posicionLetrasCadena2);
		
		///imprimir las secuencias comunes entre cadena1 y cadena2
		System.out.println(output.substring(0, output.length() - 2));
	}

	///Método que busca las secuencias más largas entre dos cadenas
	static String buscarSecuencias(ElementoListaPos posicionLetrasCadena2[], String cadena1, String cadena2)
	{		
		///variable para almacenar el código del caracter de la cadena1 que se
		///esté procesando
		char c;
		
		///variable para referenciar a los elementos de la lista ligada de
		///posiciones que corresponde al caracter almacenado en "c"...
		ElementoListaPos posC;
		
		///variable para almacenar el tamaño de la(s) secuencia(s) más largas
		///encontradas a lo largo de la ejecución del programa.
		short tamSecuencias = 0;
		
		///variable para referenciar la lista ligada de secuencias encontradas...
		ElementoListaString listaSecuencias = null;
		
		///variable para almacenar el resultado final que dará esta función...
		///(todas las secuencias ordenadas lexicográficamente)
		String secuencias = "";
		
		///variable para contar el tamaño de la secuencia que se está analizando
		short contSecuencia;
		
		///variables de posición dentro de las cadenas 1 y 2...
		short pos1, pos2;
		
		///recorrer caracter por caracter la cadena1 y encontrar si existen
		///secuencias comunes en cadena2 para cada caracter inicial de cadena1
		///aprovechando las listas ligadas del array letras...
		for(short i=0; i < cadena1.length(); i++)
		{
			///obtener el caracter c que está en la posición i de cadena1
			c = cadena1.charAt(i);
				
			///por cada caracter c de cadena1, recorrer la lista ligada de las
			///posiciones del caracter c en cadena2...
			posC = posicionLetrasCadena2[c];
			while(posC != null) ///si la lista ligada no contiene elementos, el caracter c no aparece en cadena2 y no hay que hacer nada de nada
			{
				///si hay una ocurrencia de c en cadena2, ver si existe una secuencia...
				contSecuencia = 1;
				pos1 = i;
				pos2 = posC.pos;
				
				while(++pos1 < cadena1.length() && ++pos2 < cadena2.length() && ///mientras las posiciones no se salgan de los límites de cada cadena...
				cadena1.charAt(pos1) == cadena2.charAt(pos2)) ///y mientras haya coincidencias...
						contSecuencia++; ///aumentar el contador
				
				///si el contador de la secuencia encontrada es mayor al tamaño
				///de la(s) secuencia(s) más larga(s) encontrada(s) hasta el
				///momento...
				if(contSecuencia > tamSecuencias)
				{
					///reemplazar la lista actual de secuencias...
					listaSecuencias = new ElementoListaString(cadena1.substring(i, pos1));
					///indicar el nuevo tamaño de la secuencia más grande
					///encontrada hasta el momento
					tamSecuencias = contSecuencia;
				}
				///si el contador de la secuencia encontrada es igual al tamaño
				///de la(s) secuencia(s) más larga(s) encontrada(s) hasta el
				///momento...
				else if(contSecuencia == tamSecuencias)
				{	///agregar la secuencia encontrada a la lista de secuencias
					///en el orden lexicográfico correspondiente...
					int comp;
					String secuenciaEncontrada = cadena1.substring(i, pos1);
					ElementoListaString secuencia = listaSecuencias;
					ElementoListaString secuenciaAnterior = listaSecuencias;
					
					while(secuencia != null)
					{
						comp = secuencia.s.compareTo(secuenciaEncontrada);
						if(comp > 0) ///si hay una secuencia que sea mayor a la encontrada...
						{
							if(secuencia != secuenciaAnterior) ///y si ya hay una secuencia anterior, agregar la secuencia encontrada donde le corresponde
							{
								secuenciaAnterior.siguiente = new ElementoListaString(secuenciaEncontrada);
								secuenciaAnterior.siguiente.siguiente = secuencia;
								break;
							}	
							else ///si no hay secuencia anterior, agregar la secuencia encontrada al inicio de la lista
							{
								listaSecuencias = new ElementoListaString(secuenciaEncontrada);
								listaSecuencias.siguiente = secuencia;
								break;
							}
						}
						else if(comp == 0) ///si las secuencias son iguales, no hay nada que agregar...
							break;
							
						///actualizar los apuntadores que recorren la lista...
						secuenciaAnterior = secuencia; ///actualizar la secuencia anterior
						secuencia = secuencia.siguiente; ///movernos a la siguiente secuencia
					}
					
					///si en el while anterior llegamos a secuencia == null quiere decir que no hay en la lista
					///una secuencia igual ni una secuencia que fuera mayor lexicográficamente hablando,
					///entonces la secuencia encontrada se agrega al final...
					if(secuencia == null) secuenciaAnterior.siguiente = new ElementoListaString(secuenciaEncontrada);
					
				}
				///si el contador de la secuencia encontrada es menor al tamaño
				///de la(s) secuencia(s) más larga(s) encontrada(s) hasta el
				///momento, no hay que hacer nada, esta secuencia no nos
				///interesa
				
				///ahora movernos a la siguiente ocurrencia de la letra c en
				///cadena2...
				posC = posC.siguiente;
			}
		}
		
		///formatear el contenido de la lista de secuencias encontradas...
		if(listaSecuencias == null) ///si la lista de secuencias es null, no hubo secuencias comunes...
			secuencias = "No common sequence.\n";
		else ///si la lista de secuencias tiene elementos, concatenarlos!
			while(listaSecuencias != null)
			{
				secuencias += listaSecuencias.s + "\n";
				listaSecuencias = listaSecuencias.siguiente;
			}
		
		return secuencias;
	}
	
	///Método que inicializa las listas ligadas de posiciones de cada letra
	///que aparece en la segunda cadena.
	static void inicializarLetras(ElementoListaPos posicionLetras[], String cadena)
	{
		ElementoListaPos letrasUltimoElemento[] = new ElementoListaPos[256]; ///array que apunta a los últimos elementos agregados a cada lista
		char _char; ///variable temporal para el código del caracter que se está procesando
		
		for(short i = 0; i < cadena.length(); i++)
		{
			_char = cadena.charAt(i);
			
			///si todavía no hay un primer elemento en la lista del caracter
			///actual, crearlo...
			if(posicionLetras[_char] == null)
			{
				posicionLetras[_char] = new ElementoListaPos();
				posicionLetras[_char].pos = i;
				///decir que el último elemento es el que acabamos de agregar
				letrasUltimoElemento[_char] = posicionLetras[_char];
			}
			///si ya hay elementos en la lista del caracter actual, agregar un
			///nuevo elemento
			else
			{
				letrasUltimoElemento[_char].siguiente = new ElementoListaPos();
				letrasUltimoElemento[_char].siguiente.pos = i;
				///decir que el último elemento es el que acabamos de agregar
				letrasUltimoElemento[_char] = letrasUltimoElemento[_char].siguiente;
			}
			
		}
	}
	
	
	///Método que imprime la lista de listas ligadas de los elementos que
	///aparecen en la segunda cadena.
	static void debugImprimirListasDeLetras(ElementoListaPos letras[])
	{
		ElementoListaPos temp;
		for(int i = 0; i < 256; i++)
		{
			System.out.print("[" + i + "] = ");
			temp = letras[i];
			while(temp != null)
			{
				System.out.print(temp.pos + " -> ");
				temp = temp.siguiente;
			}
			System.out.println();
		}
	}
	
	
	///Función helper para leer líneas desde el std input (ya que el
	///judge system está chafa y no permite usar las clases de 
	///java.io.*).
	static String leerLinea()
	{
		///variable para almacenar el input...
		String input = "";
		
		///variable para almacenar el caracter que se está procesando...
		int caracter = -1;
		
		///leer todos los caracteres antes de un salto de línea...
		try
		{
			while(true)
			{
				///leer un caracter
				caracter = System.in.read();
				if(caracter == '\n' || caracter < 0) ///si se encuentra un new line
					break; ///terminar el bucle de lectura...
				else if(caracter != '\r') ///si se encuentra un caracter diferente a un retorno de carro..
					input += (char) caracter; ///guardarlo
					
			}
		}
		catch(Exception e)
		{} ///me vale claxon lo que pase en este caso...

		if(caracter < 0) return null;
		return input;
	}
}

class ElementoListaPos
{
	ElementoListaPos siguiente = null;; ///apuntador al siguiente elemento en la lisa ligada
	short pos; ///ubicación de este elemento dentro de la cadena
}

class ElementoListaString
{
	ElementoListaString siguiente = null;; ///apuntador al siguiente elemento en la lisa ligada
	String s; ///string de este elemento
	
	ElementoListaString(String _s)
	{
		s = _s;
	}
}