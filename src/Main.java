import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Crear un cliente asignando los datos directamente y probar validaciones
        System.out.println("=== Crear cliente ===");
        Cliente cliente1 = new Cliente("16353658-7", "Diego Sobarzo");
        System.out.println("Estado del cliente creado: " + cliente1);

        //Intento de asignar cédula no válida
        Cliente clienteInvalido = new Cliente("163538-7", "Diego Sobarzo");
        System.out.println("Intento de cliente con cédula inválida: " + clienteInvalido);

        //Crear un automóvil asignando los datos directamente y probar validaciones
        System.out.println("\n=== Crear vehículo ===");
        Vehiculo vehiculo1 = new Vehiculo("ABCDEFGH", "Ford", "Fiesta", 2020);
        System.out.println("Estado del vehículo creado: " + vehiculo1);

        //Intento de asignar patente no válida
        Vehiculo vehiculoInvalido = new Vehiculo("123", "Chevrolet", "Cruze", 2025);
        System.out.println("Intento de vehículo con datos inválidos: " + vehiculoInvalido);

        //Deshabilitar al cliente creado y mostrar su estado
        System.out.println("\n=== Deshabilitar cliente ===");
        cliente1.deshabilitar();
        System.out.println("Estado del cliente después de deshabilitar: " + cliente1);

        //Asignar vehículo en mantención y mostrar su estado
        System.out.println("\n=== Asignar vehículo a mantención ===");
        vehiculo1.setCondicion('M');
        System.out.println("Estado del vehículo después de asignar mantención: " + vehiculo1);

        //Prueba de ingreso de arriendo
        System.out.println("\n=== Ingresar arriendo ===");
        //Crear un nuevo cliente y vehículo para la prueba de arriendo
        Cliente cliente2 = new Cliente("98765432-1", "Luis Pérez");
        Vehiculo vehiculo2 = new Vehiculo("JKL87654", "Toyota", "Corolla", 2019);

        //Crear arriendo válido
        Arriendo arriendoValido = new Arriendo(1001, vehiculo2, cliente2, LocalDate.of(2021, 1, 15), 5, 40000);
        if (arriendoValido.ingresarArriendo()) {
            System.out.println("Arriendo ingresado correctamente:");
            arriendoValido.generarTicketArriendo();
            System.out.println("Estado del vehículo arrendado: " + vehiculo2);
        }

        //Crear arriendo inválido (cliente no vigente)
        Cliente clienteNoVigente = new Cliente("34567890-2", "Carlos Ruiz");
        clienteNoVigente.deshabilitar();  // Deshabilitar al cliente
        Arriendo arriendoInvalido = new Arriendo(1002, vehiculo1, clienteNoVigente, LocalDate.of(2021, 1, 20), 4, 35000);
        if (!arriendoInvalido.ingresarArriendo()) {
            System.out.println("Error: No se pudo ingresar el arriendo (cliente no vigente o vehículo no disponible).");
        }

        //Prueba de ingreso de devoluciones
        System.out.println("\n=== Ingresar devoluciones ===");
        //Crear devolución válida
        Devolucion devolucionValida = new Devolucion(arriendoValido, LocalDate.of(2021, 1, 20));
        if (devolucionValida.ingresarDevolucion()) {
            System.out.println("Devolución ingresada correctamente.");
            System.out.println("Estado del vehículo después de la devolución: " + vehiculo2);
        }

        //Crear devolución inválida (fecha de devolución antes del arriendo)
        Devolucion devolucionInvalida = new Devolucion(arriendoValido, LocalDate.of(2021, 1, 14));  // Fecha inválida
        if (!devolucionInvalida.ingresarDevolucion()) {
            System.out.println("Error: No se pudo ingresar la devolución (fecha de devolución inválida).");
        }
    }
}

