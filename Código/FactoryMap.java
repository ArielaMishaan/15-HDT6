import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Ariela Mishaan (22052)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 6
 * 06-03-2023
 * Clase FactoryMap: sirve para crear los distintos tipos de Map, según lo que pida el usuario.
 */



public class FactoryMap {

    //atributo
    private Map<String, ArrayList<String>> mapa;

    
    /** 
     * @param tipoMap
     * @return Map<String, ArrayList<String>>
     * Método que crea el Map según el tipo que se pida. 
     */
    public Map<String, ArrayList<String>> getInstanceMap(int tipoMap){
        
        switch (tipoMap) {
            
            case 1: //Hash map
                this.mapa = new HashMap<String, ArrayList<String>>();
                break;

            case 2: //linked hash map
                this.mapa = new LinkedHashMap<String, ArrayList<String>>();
                break;

            case 3: //tree map
                this.mapa = new TreeMap<String, ArrayList<String>>();
                break;
        
            default:
                break;
        }

        return mapa;
    }
     
}
