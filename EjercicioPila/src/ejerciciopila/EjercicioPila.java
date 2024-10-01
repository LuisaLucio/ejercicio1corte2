package ejerciciopila;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Valentina Rubio & Luisa Lucio
 */
public class EjercicioPila {
    private String textoActual;
    private Stack <String> pilasDeshacer;
    private Stack <String> pilasRehacer;
    
    public EjercicioPila() {
        textoActual = "";
         pilasDeshacer = new Stack<>();
         pilasRehacer = new Stack<>();        
    }
    
    public void escribirTexto (String texto){
         pilasDeshacer.push(textoActual);
         pilasRehacer.clear();
         textoActual += texto;
    }
    
    public void deshacerAccion(){
        if(!pilasDeshacer.isEmpty()){
            pilasRehacer.push(textoActual);
            textoActual = pilasDeshacer.pop();
        }else{
            System.out.println("No hay acciones para DESHACER!");
        }
    }
    
    public void rehacerAccion(){
        if(!pilasRehacer.isEmpty()){
            pilasDeshacer.push(textoActual);
            textoActual = pilasRehacer.pop();
        }else{
            System.out.println("No hay acciones para REHACER!");
        }
    }
    
    public void mostrarTexto() {
        System.out.println("Texto actual: " + textoActual);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EjercicioPila ed = new EjercicioPila();
        int op; 
        
        do{
            System.out.println("\n--- EDITOR DE TEXTO ---");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer texto");
            System.out.println("3. Rehacer texto");
            System.out.println("4. Mostrar texto");
            System.out.println("5. Salida");
            System.out.print("Elija una opcion: ");
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1:
                    System.out.print("Ingrese el texto que desea escribir: ");
                    String texto = sc.nextLine();
                    ed.escribirTexto(texto);
                    break;
                case 2:
                    ed.deshacerAccion();
                    break;
                case 3:
                    ed.rehacerAccion();
                    break;
                case 4:
                    ed.mostrarTexto();
                    break;
                case 5:
                    System.out.println("Saliendo del modo editor...");
                    break;
                default:
                    System.out.println("Opcion inválida! Intentelo de nuevo!");
            }
        }while (op != 5);
            sc.close();
    }
}
