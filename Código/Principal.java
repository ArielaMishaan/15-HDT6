import java.util.ArrayList;
import java.util.Scanner;

/*
 * Ariela Mishaan (22052)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 06-03-2023
 * Clase Principal: interactúa con el usuario.
 */

public class Principal{
    public static void main(String[] args) {

        Archivo archivo = new Archivo("./ListadoProducto.txt");
        ArrayList<String> lineasDatos = archivo.leerArchivo();

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        String menu = "\n°°°°°°°°°°°°°°°°°°° TIENDA ONLINE °°°°°°°°°°°°°°°°°°°°\n";
        menu = menu + "\n\nSeleccione el tipo de Map con el que quiere que se realicen las operaciones de este programa. ";
        menu = menu + "\n\n1. HashMap\n2. Linked HashMap \n3. Hash Tree.";

        while(opcion >= 0 && opcion < 4){

            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                Tienda tienda = new Tienda(opcion);
                int opcion2 = 0;

                //Ya teniendo creada la tienda, abrir el archivo.
                tienda.abrirArchivoInventario(lineasDatos);

                while(opcion2 >= 0 && opcion2 <7){
                    
                    try {
                        System.out.println("\n\n--------------------------------");
                        System.out.println("\nBienvenido a la tienda online.");
                        System.out.println("--------------------------------");
                        System.out.println("\n1. Agregar un producto al carrito. \n2. Mostrar categoría de un producto \n3. Mostrar datos de los productos en el carrito \n4. Mostrar datos de los productos en el carrito (ordenados por categoría) \n5. Mostrar productos del inventario \n6. Mostrar productos del inventario (ordenados por categoría)\n7. Salir");
                        System.out.println("\nSeleccione la acción que quiere llevar a cabo: ");
                        opcion2 = teclado.nextInt();
                        teclado.nextLine();

                        switch (opcion2) {
                            case 1: //Agregar producto al carrito

                                System.out.println("\nLas categorías disponibles son: Mueble de terraza, Sillones de masaje, Bebidas, Condimentos, Frutas, Carnes y Lácteos");
                                System.out.println("\nEscriba la categoría del producto que desea agregar (verifique haber escrito bien).");
                                String categoria = teclado.nextLine();

                                if(tienda.verificarCategoria(categoria)){
                                    System.out.println("\nEscriba el nombre del producto que quiere agregar a su carrito:");
                                    String producto = teclado.nextLine();

                                    if(tienda.verificarProducto(producto)){
                                        tienda.agregarProductoCarrito(categoria, producto);
                                    }
                                    else{
                                        System.out.println("\nLo sentimos. No se pudo agregar el producto porque no existe en el inventario.");
                                    }
                                }
                                else{
                                    System.out.println("\nLo sentimos. No se pudo agregar el producto porque la categoría que ingresó no existe en el inventario.");
                                }
                                break;

                            case 2: //Mostrar categoría de un producto
                                
                                System.out.println("\nEscriba el nombre del producto: ");
                                String producto2 = teclado.nextLine();
                                System.out.println("\nCategoría del producto " + producto2 +": " + tienda.mostrarCategoriaProducto(producto2));

                                break;
                            
                            case 3: //Mostrar datos de los productos en el carrito
                                System.out.println(tienda.mostrarDatosCarrito());
                                break;

                            case 4: //Mostrar datos de los productos en el carrito, ordenado por categoría
                                System.out.println(tienda.mostrarInfoProducto());
                                break;

                            case 5: //Mostrar datos de los productos en el inventario
                                System.out.println(tienda.mostrarInventario());
                                break;

                            case 6: //Mostrar datos de los productos en el inventario, ordenado por categoría
                                System.out.println(tienda.mostrarInventarioPorTipo());
                                break;

                            default:
                                break;
                        }
                        
                    } catch (Exception e) {
                        // TODO: handle exception
                        teclado.nextLine();
                        System.out.println("\nEntrada incorrecta. Verificar que el tipo de dato ingresado sea el solicitado.");
                    }
                }
            } 

            catch (Exception e) {
                // TODO: handle exception
                teclado.nextLine();
                System.out.println("\nEntrada incorrecta. Verificar que el tipo de dato ingresado sea el solicitado.");
            }
        }
    }
}