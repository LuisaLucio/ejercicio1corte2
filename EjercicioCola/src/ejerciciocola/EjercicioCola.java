package ejerciciocola;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Luisa Lucio & Valentina Rubio
 */
public class EjercicioCola {

   
    class Cliente{
        private double noCuenta;
        private String nombre;

        public Cliente(double noCuenta, String nombre) {
            this.noCuenta = noCuenta;
            this.nombre = nombre;
        }

        public double getNoCuenta() {
            return noCuenta;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return "Cuenta: " + noCuenta + "Nombre: " + nombre;
        }
    
    } 
    
    public class Banco {
        Queue<Cliente> clientes= new LinkedList<>();
        
        public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
            System.out.println("El cliente: "+cliente+ " agregado.");
        }
        
        public void atenderCliente() {
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes para atender.");
            } else {
                Cliente clienteAtendido = clientes.poll();
                System.out.println("Atendiendo al cliente: " + clienteAtendido);
            }
        }

    
        public void mostrarClientesEnCola() {
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes en la cola.");
            } else {
                System.out.println("Clientes en la cola:");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
            }
        }

    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        int op;
        do {
            System.out.println("\n Menú de Atención al Cliente");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar clientes en cola");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine();  

            switch (op) {
                case 1:
                    System.out.print("Ingrese el número de cuenta: ");
                    Double noCuenta = sc.nextDouble();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = sc.nextLine();
                    Cliente nuevoCliente = new Cliente(noCuenta, nombre);
                    banco.agregarCliente(nuevoCliente);
                    break;
                case 2:
                    banco.atenderCliente();
                    break;
                case 3:
                    banco.mostrarClientesEnCola();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 4);

        sc.close();           
    }
}