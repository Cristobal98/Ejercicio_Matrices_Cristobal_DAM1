package ejercicio_matrices;
import java.util.Scanner;
import java.util.Arrays;

public class matrices {

	private static char operacion;

	public static void main(String[] args) {
		int salir = 1;
		//MENU
		while (salir == 1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("ELIGE UNA OPCION DE LAS DISPONIBLES");
			System.out.println("1. Suma de dos matrices");
			System.out.println("2. Producto de un escalar por una matriz");
			System.out.println("3. Producto de dos matrices");
			System.out.println("4. Transponer una matriz");
			System.out.println("5. Diagonal principal de una matriz");
			System.out.println("6. Comprobar si una matriz es simétrica");
			System.out.println("7. Potencia de una matriz cuadrada");
			System.out.println("8. Resta de dos matrices");
			System.out.println("9. Exit");
			
			int opcion = sc.nextInt();
			
			switch (opcion) {
				case 1: 
					operacion = 1;
					suma();
					break;
				case 2: productoEscalar();
					break;
				case 3: producto();
					break;
				case 4: trasponer();
					break;
				case 5: diagonal();
					break;
				case 6: simetrica();
					break;
				case 7: potenciaDeMatriz();
					break;
				case 8: 
					operacion = 2;
					resta();
					break;
				case 9:
					salir = 0;
					break;
			}
		}
	}
	
	
	//1. METODO SUMA
	
	private static void suma (){

		int[][] matriz1 =  crearMatriz();
		int[][] matriz2 =  crearMatriz();
		int [][] matrizFinal = new int [matriz1.length][matriz1[0].length];
		
		//COMPRUEBA LA DIMENSION DE LAS MATRICES
		if (matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length) {
			//SUMA DE MATRICES
			for (int i = 0; i < matrizFinal.length; i++) {
				for (int j = 0; j < matrizFinal.length; j++) {
					if (operacion == 1) {
						matrizFinal [i][j] = matriz1 [i][j] + matriz2 [i][j];
					} else if  (operacion == 2) {
						//EN CASO DE SER RESTA REALIZA LA OPERACION
						matrizFinal [i][j] = matriz1 [i][j] - matriz2 [i][j];
					}
				}
			}
			

			//MOSTRAR RESULTADO DE LA SUMA
			for (int i = 0;i<matrizFinal.length;i++) {
				System.out.println("");
				System.out.println(Arrays.toString(matrizFinal[i]));
				System.out.println("");
			}
			
		} else {
			System.out.println("");
			System.out.println("NO ES POSIBLE REALIZAR LA OPERACION (LAS MATRICES DEBEN SER DE LA MISMA DIMENSION)");
			System.out.println("");
		}
		
	}
	
	
	//2. METODO PRODUCTO ESCALAR
	
	private static void productoEscalar (){

		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un numero para realizar el producto");
		int[][] matriz1 =  crearMatriz();
		int [][] matriz2 = new int [matriz1.length][matriz1[0].length];
		int num = sc.nextInt();
		
		//REALIZANDO EL PRODUCTO
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2.length; j++) {
				matriz2 [i][j] = matriz1 [i][j] * num;
			}
		}
		
		//MOSTRAR RESULTADO DEL PRODUCTO ESCALAR
		for (int i = 0;i<matriz2.length;i++) {
			System.out.println("");
			System.out.println(Arrays.toString(matriz2[i]));
			System.out.println("");
		}
	}
	
	//3. METODO PRODUCTO DE MATRICES
	
	private static void producto (){
		int[][] matriz1 =  crearMatriz();
		int[][] matriz2 =  crearMatriz();
		int [][] matrizFinal = new int [matriz1.length][matriz1[0].length];
		int resultado = 0;
		
		//COMPRUEBA LA DIMENSION DE LAS MATRICES
		if (matriz1[0].length == matriz2.length) {
			//REALIZA EL PRODUCTO
			for (int i = 0; i < matriz1.length; i++) {
				for (int j = 0; j < matriz2[0].length; j++) {
					for (int k = 0; k < matriz1[0].length; k++) {
						resultado = resultado + matriz1[i][k] * matriz2[k][j];
						matrizFinal[i][j] = resultado;
					}
					resultado = 0;
				}
			}
			
			//MOSTRAR RESULTADO
			for (int i = 0;i<matrizFinal.length;i++) {
				System.out.println(Arrays.toString(matrizFinal[i]));
			}
		} else {
			System.out.println("");
			System.out.println("NO ES POSIBLE REALIZAR LA OPERACION");
			System.out.println("");
		}
		
		
	}
	
	//4. METODO TRASPONER MATRIZ
	private static void trasponer (){
		int[][] matriz1 =  crearMatriz();
		int[][] matriz2 =  new int [matriz1[0].length][matriz1.length];
		
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[0].length; j++) {
				matriz2[j][i] = matriz1[i][j];
			}
		}
		
		//MOSTRAR RESULTADO
		for (int i = 0;i<matriz2.length;i++) {
			System.out.println("");
			System.out.println(Arrays.toString(matriz2[i]));
			System.out.println("");
		}
	}
	
	//5. METODO DIAGONAL MATRIZ
	private static void diagonal (){
		int[][] matriz1 =  crearMatriz();
		int[] array =  new int [matriz1.length];
			
		if (matriz1.length == matriz1[0].length) {
			for (int i = 0; i < matriz1.length; i++) {
				for (int j = 0; j < matriz1[0].length; j++) {
					if (j == i) {
						array[i] = matriz1[i][j];
					}
				}
			}
			
			//MOSTRAR RESULTADO
			System.out.println("");
			System.out.println(Arrays.toString(array));
			System.out.println("");
			
		}   else {
			System.out.println("");
			System.out.println("LA MATRIZ DEBE TENER LA MISMA DIMENSION");
			System.out.println("");
		}
	}
	
	//6. METODO MATRIZ SIMETRICA
	private static void simetrica (){
		int[][] matriz1 =  crearMatriz();
		int[][] matriz2 =  new int [matriz1[0].length][matriz1.length];
		boolean simetrica = true;
		
		//TRASPONE LA MATRIZ
		if (matriz1.length == matriz1[0].length) {
			for (int i = 0; i < matriz1.length; i++) {
				for (int j = 0; j < matriz1[0].length; j++) {
					matriz2[j][i] = matriz1[i][j];
				}
			}
			
			//COMPRUEBA LA SIMETRIA DE LAS MATRICES
			for (int i = 0; i < matriz1.length; i++) {
				for (int j = 0; j < matriz1[0].length; j++) {
					if (matriz2[i][j] != matriz1[i][j]) {
						simetrica = false;
					}
				}
			}
			
			//MOSTRAR RESULTADO
			if (simetrica == true) {
				System.out.println("");
				System.out.println("LA MATRIZ ES SIMETRICA");
				System.out.println("");
			} else {
				System.out.println("");
				System.out.println("LA MATRIZ NO ES SIMETRICA");
				System.out.println("");
			}
			
		}  else {
			System.out.println("");
			System.out.println("LA MATRIZ DEBE TENER LA MISMA DIMENSION");
			System.out.println("");
		}
	}
	

	//7. METODO POTENCIA
	
	private static void potenciaDeMatriz (){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un numero para elevar la matriz");
		int num = sc.nextInt();
		int[][] matriz1 =  crearMatriz();
		int [][] matriz2 = new int [matriz1.length][matriz1[0].length];
		int [][] matriz3Clonada = new int [matriz1.length][matriz1[0].length];
		int resultado = 0;
		
		//CLONAR MATRIZ 1
		for (int i = 0;i<matriz1.length;i++) {
			for (int u = 0;u<matriz1[0].length;u++) {
				matriz3Clonada[i][u] = matriz1[i][u];
			}
		}
		
		//COMPRUEBA LA DIMENSION DE LAS MATRICES
		if (matriz1[0].length == matriz2.length) {
			
			for (int a = 1; a < num; a++) {
				for (int i = 0; i < matriz1.length; i++) {
					for (int j = 0; j < matriz2[0].length; j++) {
						for (int k = 0; k < matriz1[0].length; k++) {
								resultado = resultado + matriz1[i][k] * matriz3Clonada[k][j];
								matriz2[i][j] = resultado;
						}
						resultado = 0;
					}
				}
				for (int i = 0; i < matriz1.length; i++) {
					for (int j = 0; j < matriz1[0].length; j++) {
						matriz3Clonada[i][j] = matriz2[i][j];
					}
				}
			}
			
			
			//MOSTRAR RESULTADO
			for (int i = 0;i<matriz2.length;i++) {
				System.out.println(Arrays.toString(matriz2[i]));
			}
		} else {
			System.out.println("");
			System.out.println("NO ES POSIBLE REALIZAR LA OPERACION");
			System.out.println("");
		}
	}
	
	
	//8. METODO RESTA
	
	private static void resta (){
		//LLAMA A SUMA PARA REALIZAR LA OPERACION
		suma();
	}
	
	
	//CREAR MATRIZ
	
	private static int [][] crearMatriz(){
		Scanner sc = new Scanner (System.in);
		//CREANDO MATRIZ
		System.out.println("Dime las filas de la matriz");
		int y = sc.nextInt();
		System.out.println("Dime el numero de columnas");
		int z = sc.nextInt();
		int[][] matriz = new int[y][z];
		
			// INICIAR MATRIZ CON NUMEROS INTRODUCIDOS
			for (int i = 0;i<matriz.length;i++) {
				for (int u = 0;u<matriz[0].length;u++) {
					System.out.println("Dame un numero");
					int x = sc.nextInt();
					matriz[i][u] = x;
				}
			}
		return matriz;
	}
}