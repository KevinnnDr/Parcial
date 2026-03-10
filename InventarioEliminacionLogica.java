import java.io.*;
import java.util.Scanner;
 
public class InventarioEliminacionLogica {
    public static void mostrarArchivo(String nombreArchivo) {
        System.out.println("Contenido del archivo: " + nombreArchivo);
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        System.out.println("-------------------------");
    }
     // Métodos a implementar
    // 1. Marcar un registro como eliminado agregando '#' al inicio si coincide con el producto indicado
    public static void marcarEliminado(String nombreArchivo, String productoEliminar) {
        // Completar implementación
    }
 
    public static void crearArchivoSinEliminados(String archivoOriginal, String archivoNuevo) {
        try (
            BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoNuevo))
        ) {
            String linea;
 
            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith("#")) {
                    bw.write(linea);
                    bw.newLine();
                }
            }
 
        } catch (IOException e) {
            System.out.println("Error al crear archivo actualizado: " + e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivo = "inventario.txt";
 
        mostrarArchivo(archivo);
  
        System.out.print("Ingrese el nombre del producto para eliminar: ");
        String productoEliminar = sc.nextLine();
 
        marcarEliminado(archivo, productoEliminar);
        mostrarArchivo(archivo);
 
        String archivoActualizado = "inventario_actualizado.txt";
        crearArchivoSinEliminados(archivo, archivoActualizado);
        mostrarArchivo(archivoActualizado);
 
        sc.close();
    }
}