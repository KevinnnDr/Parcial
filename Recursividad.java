public class Recursividad {
    public static String invertirCadena(String texto) {
        if (texto.length() <= 1) {
            return texto;
        }

        return invertirCadena(texto.substring(1)) + texto.charAt(0);
    }
 
    public static void main(String[] args) {
        String original = "Recursividad";
        String invertida = invertirCadena(original);
        System.out.println("Original: " + original);
        System.out.println("Invertida: " + invertida);
    }
}