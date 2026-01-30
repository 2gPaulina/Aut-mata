import java.util.Scanner;

public class Automata {
    
    public static boolean procesarPalabra(String palabra) {
        int estado = 0; // Estado inicial q0
        
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            
            if (estado == 0) {
                if (letra == 'a') estado = 1;
                else if (letra == 'b') estado = 2;
                else {
                    System.out.println("Error: solo se permiten 'a' y 'b'");
                    return false;
                }
            }
            else if (estado == 1) {
                if (letra == 'a') estado = 1;
                else if (letra == 'b') estado = 1;
            }
            else if (estado == 2) {
                if (letra == 'a') estado = 0;
                else if (letra == 'b') estado = 2;
            }
        }
        
        return estado == 1 || estado == 2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== AUTOMATA FINITO ===");
        System.out.println("Estados: q0=0 (inicial), q1=1 (final), q2=2 (final)\n");
        
        // Palabras aceptadas
        System.out.println("Ingresa tu palabra:");
        int aceptadas = 0;
        for (int i = 1; i <= 20; i++) {
            System.out.print(i + ". ");
            String palabra = scanner.nextLine().trim();
            
            if (procesarPalabra(palabra)) {
                System.out.println("   ACEPTADA");
                aceptadas++;
            } else {
                System.out.println("   NO ACEPTADA");
            }
        }
        
        scanner.close();
    }
}