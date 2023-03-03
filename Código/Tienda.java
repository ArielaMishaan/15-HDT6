import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/*
 * Ariela Mishaan (22052)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 06-03-2023
 * Clase Tienda: controladora.
 */

public class Tienda {

    //atributos
    private Map<String, ArrayList<String>> inventario;
    private FactoryMap factory;
    private Map<String, ArrayList<String>> carrito;

    //métodos

    /**
     * 
     * @param tipoMap
     * CONSTRUCTOR (1 = HashMap, 2 = Linked HashMap, 3 = TreeMap)
     */
    public Tienda(int tipoMap){
        this.factory = new FactoryMap();
        this.inventario = factory.getInstanceMap(tipoMap);
        this.carrito = factory.getInstanceMap(tipoMap);
    }

    //Otros métodos

    /**
     * Con la lista de las líneas del archivo, categoriza la información y la guarda en el map. 
     * @param lineasInventario
     */
    public void abrirArchivoInventario(ArrayList<String> lineasInventario){

        for (String linea : lineasInventario) {

            String [] productoString = linea.split(" | ");
            String tipo = productoString[0];
            String producto = productoString[1];

            inventario.putIfAbsent(tipo, new ArrayList<String>());
            inventario.get(tipo).add(producto);            
        }

    }

    /**
     * Agrega un producto al carrito del usuario. El usuario le tiene que dar como parámetro el nombre de la categoría al cuál agregar el producto, y el nombre del producto.
     * @param nombreCategoria
     * @param nombreProducto
     */
    public void agregarProductoCarrito(String nombreCategoria, String nombreProducto){

        //suponiendo que se le ingresa correctamente el nombre de la categoría disponible (esto se debe controlar en la clase principal)
        inventario.putIfAbsent(nombreCategoria, new ArrayList<String>());
        inventario.get(nombreCategoria).add(nombreProducto);
    }

    /**
     * Retorna la categoría de un producto específico. 
     * @param nombreProducto
     * @return resultado
     */
    public String mostrarCategoriaProducto(String nombreProducto){
        String resultado = "";

        for (Map.Entry<String, ArrayList<String>> entrada : inventario.entrySet()) {
            
            ArrayList<String> lista = entrada.getValue();
            if(lista.contains(nombreProducto)){
                resultado = entrada.getKey();
            }
        }

        return resultado;
    }
    
    /**
     * Muestra todos los productos del carrito
     * @return resultado
     */
    public String mostrarDatosCarrito(){
        String resultado = "";
        resultado = resultado + "\nTODOS LOS PRODUCTOS DE SU CARRITO: ";

        for (Map.Entry<String, ArrayList<String>> entrada : carrito.entrySet()) {
            
            ArrayList<String> productosMostrados = new ArrayList<String>();
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n\n" + producto + "\n  - Cantidad: " + Collections.frequency(entrada.getValue(), producto) + "\n  - Categoría: " + mostrarCategoriaProducto(producto);
                }
            }
        }

        return resultado;
    }

    /**
     * Muestra todos los productos del carrito, ordenados por categoría
     * @param nombreProducto
     * @return resultado
     */
    public String mostrarInfoProducto(String nombreProducto){
        String resultado = "\nTODOS LOS PRODUCTOS DE SU CARRITO, ORDENADOS POR CATEGORÍA";

        for (Map.Entry<String, ArrayList<String>> entrada : carrito.entrySet()) {

            resultado = resultado + "\n" + entrada.getKey().toUpperCase() + "\n\n-----------------------------";
            ArrayList<String> productosMostrados = new ArrayList<String>();
            
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n\n" + producto + " - Cantidad: " + Collections.frequency(entrada.getValue(), producto);
                }
            }
        }

        return resultado;
    }
    
    /**
     * Muestra todos los productos del inventario
     * @return resultado
     */
    public String mostrarInventario(){
        String resultado = "";

        resultado = resultado + "\nTODOS LOS PRODUCTOS DEL INVENTARIO: ";

        for (Map.Entry<String, ArrayList<String>> entrada : inventario.entrySet()) {
            
            ArrayList<String> productosMostrados = new ArrayList<String>();
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n\n" + producto + "\n  - Cantidad: " + Collections.frequency(entrada.getValue(), producto) + "\n  - Categoría: " + mostrarCategoriaProducto(producto);
                }
            }
        }
        return resultado;
    }

    /**
     * Muestra todos los productos del inventario, ordenados por categoría
     * @return resultado
     */
    public String mostrarInventarioPorTipo(){

        String resultado = "\nTODOS LOS PRODUCTOS DEL INVENTARIO, ORDENADOS POR CATEGORÍA";

        for (Map.Entry<String, ArrayList<String>> entrada : inventario.entrySet()) {

            resultado = resultado + "\n" + entrada.getKey().toUpperCase() + "\n\n-----------------------------";
            ArrayList<String> productosMostrados = new ArrayList<String>();
            
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n\n" + producto + " - Cantidad: " + Collections.frequency(entrada.getValue(), producto);
                }
            }
        }

        return resultado;
    }

    //Gets y Sets

    /**
     * Método para acceder al inventario
     * @return
     */
    public Map<String,ArrayList<String>> getInventario() {
        return this.inventario;
    }

    /**
     * Método para modificar el inventario
     * @param inventario
     */
    public void setInventario(Map<String,ArrayList<String>> inventario) {
        this.inventario = inventario;
    }

    /**
     * Método para obtener la factory
     * @return
     */
    public FactoryMap getFactory() {
        return this.factory;
    }

    /**
     * Método para modificar la factory
     * @param factory
     */
    public void setFactory(FactoryMap factory) {
        this.factory = factory;
    }

    /**
     * Método para obtener el carrito de compras
     * @return
     */
    public Map<String,ArrayList<String>> getCarrito() {
        return this.carrito;
    }

    /**
     * Método para modificar el carrito de compras.
     * @param carrito
     */
    public void setCarrito(Map<String,ArrayList<String>> carrito) {
        this.carrito = carrito;
    }

}
