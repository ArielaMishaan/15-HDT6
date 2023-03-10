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

            String [] productoString = linea.split("\\|");
            
            String tipo = productoString[0];
            tipo = tipo.trim();
            //tipo.replaceFirst("^\\s*", "");

            String producto = productoString[1];
            producto = producto.trim();
            //producto = producto.replaceFirst("^\\s*", "");

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

        carrito.putIfAbsent(nombreCategoria, new ArrayList<String>());
        carrito.get(nombreCategoria).add(nombreProducto);
    }

    /**
     * Verifica que el usuario ingresó una categoría correcta.
     * @param categoria
     * @return
     */
    public boolean verificarCategoria(String categoria){
        boolean resultado = false;

        if (categoria.equalsIgnoreCase("Mueble de terraza") |
            categoria.equalsIgnoreCase("Sillones de masaje")|
            categoria.equalsIgnoreCase("Bebidas")|
            categoria.equalsIgnoreCase("Condimentos")|
            categoria.equalsIgnoreCase("Frutas")|
            categoria.equalsIgnoreCase("Carnes")| 
            categoria.equalsIgnoreCase("Lácteos")){

                resultado = true;
        }

        return resultado;
    }
   
    public boolean verificarProducto(String producto){
        boolean resultado = false;
        
        for(Map.Entry<String, ArrayList<String>> entrada: inventario.entrySet()){
            
            ArrayList<String> categoria = entrada.getValue();
            if(categoria.contains(producto)){
                resultado = true;
            }
        }

        return resultado;
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
                resultado =  entrada.getKey();
            }
        }

        if(resultado.equals("")){
            resultado = "No se encontró el producto";
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
        ArrayList<String> productosMostrados = new ArrayList<String>();

        for (Map.Entry<String, ArrayList<String>> entrada : carrito.entrySet()) {
            
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n\n" + producto + "\n  - Cantidad: " + Collections.frequency(entrada.getValue(), producto) + "\n  - Categoría: " + mostrarCategoriaProducto(producto);
                }
                productosMostrados.add(producto);
            }
        }

        return resultado;
    }

    /**
     * Muestra todos los productos del carrito, ordenados por categoría
     * @return resultado
     */
    public String mostrarInfoProducto(){
        String resultado = "\nTODOS LOS PRODUCTOS DE SU CARRITO, ORDENADOS POR CATEGORÍA";
        ArrayList<String> productosMostrados = new ArrayList<String>();

        for (Map.Entry<String, ArrayList<String>> entrada : carrito.entrySet()) {

            resultado = resultado + "\n\n" + entrada.getKey().toUpperCase() + "\n-----------------------------";
            
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n" + producto + " - Cantidad: " + Collections.frequency(entrada.getValue(), producto);
                }
                productosMostrados.add(producto);
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
        ArrayList<String> productosMostrados = new ArrayList<String>();

        for (Map.Entry<String, ArrayList<String>> entrada : inventario.entrySet()) {
            
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n\n" + producto + "\n  - Cantidad: " + Collections.frequency(entrada.getValue(), producto) + "\n  - Categoría: " + mostrarCategoriaProducto(producto);
                }
                productosMostrados.add(producto);
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
        ArrayList<String> productosMostrados = new ArrayList<String>();

        for (Map.Entry<String, ArrayList<String>> entrada : inventario.entrySet()) {

            resultado = resultado + "\n\n" + entrada.getKey().toUpperCase() + "\n-----------------------------";
            
            for (String producto : entrada.getValue()) {

                if(!productosMostrados.contains(producto)){
                    resultado = resultado + "\n" + producto + " - Cantidad: " + Collections.frequency(entrada.getValue(), producto);
                }
                productosMostrados.add(producto);
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
