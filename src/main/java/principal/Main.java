package principal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Operaciones operaciones = new Operaciones();

        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion ");
            System.out.println("Opcion 1 - Registar un nuevo cliente ");
            System.out.println("Opcion 2 - Consultar los clientes ");
            System.out.println("Opcion 3 - Modificar un cliente ");
            System.out.println("Opcion 4 - Eliminar un cliente ");
            System.out.println("Opcion 5 - Salir del programa");
            opcion = leer.nextInt();


        }while(opcion != 3);

        if(opcion==1){
            System.out.println("Falta por agregar");
        }

    }
}
