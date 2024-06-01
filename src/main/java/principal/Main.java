package principal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Operaciones operaciones = new Operaciones();
        boolean continuar = true;

        do {
            System.out.println(" BIENVENIDO AL SISTEMA - *GIMNASIO SIEMPRE FUERTE* ");
            System.out.println(" --------------------------------------------------");
            System.out.println("|            >>>MENÚ PRINCIPAL<<<                  |");
            System.out.println("|--------------------CLIENTES----------------------|");
            System.out.println("|Opción 1 - Registrar un cliente nuevo             |");
            System.out.println("|Opción 2 - Buscar un cliente activo               |");
            System.out.println("|Opción 3 - Actualizar datos de un cliente         |");
            System.out.println("|Opción 4 - Eliminar un cliente                    |");
            System.out.println("|--------------------PAGOS-------------------------|");
            System.out.println("|Opcion 5 - Registrar un pago                      |");
            System.out.println("|Opcion 6 - Consultar fecha de pago                |");
            System.out.println("|Opcion 7 - Eliminar un pago                       |");
            System.out.println("|------------------ENTRENADORES--------------------|");
            System.out.println("|Opción 8 - Agregar un entrenador                  |");
            System.out.println("|Opción 9 - Buscar un entrenador                   |");
            System.out.println("|Opción 10 - Eliminar un entrenador                |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|Opción 11 - Salir del programa                    |");
            System.out.println(" --------------------------------------------------");
            System.out.print("Porfavor seleccione una opción en números.... ");
            int opcion = entrada.nextInt(); entrada.nextLine();
            System.out.println(" ");

            switch (opcion) {
                case 1:
                    operaciones.registrarCliente();
                    break;
                case 2:
                    operaciones.buscarCliente();
                    break;
                case 3:
                    operaciones.actualizarCliente();
                    break;
                case 4:
                    operaciones.eliminarCliente();
                    break;
                case 5:
                    operaciones.registrarPago();
                    break;
                case 6:
                    operaciones.consultarPago();
                    break;
                case 7:
                    operaciones.eliminarPago();
                    break;
                case 8:
                    operaciones.agregarEntrenador();
                    break;
                case 9:
                    operaciones.buscarEntrenador();
                    break;
                case 10:
                    operaciones.eliminarEntrenador();
                    break;
                case 11:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    System.exit(0);
                default:
                    System.out.println("Opción incorrecta, intentélo nuevamente");
            }

            if (continuar) {
                System.out.println(" ");
                System.out.print("Presione S para volver al menú principal, o cualquier tecla para salir... ");
                System.out.println(" ");
                String respuesta = entrada.next();
                if (!respuesta.equalsIgnoreCase("S")) {
                    continuar = false;
                }
            }
        }while(continuar);
        entrada.close();
    }
}
