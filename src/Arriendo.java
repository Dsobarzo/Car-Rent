import java.time.LocalDate;

public class Arriendo {
    private final int numeroArriendo;
    Vehiculo vehiculo;
    private final Cliente cliente;
    LocalDate fechaArriendo;
    private int diasArriendo;
    private final double precioDiario;

    public Arriendo(int numeroArriendo, Vehiculo vehiculo, Cliente cliente, LocalDate fechaArriendo, int diasArriendo, double precioDiario) {
        this.numeroArriendo = numeroArriendo;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        setDiasArriendo(diasArriendo);
        this.fechaArriendo = fechaArriendo;
        this.precioDiario = precioDiario;
    }

    public void setDiasArriendo(int diasArriendo) {
        if (diasArriendo >= 1 && diasArriendo <= 10) {
            this.diasArriendo = diasArriendo;
        } else {
            System.out.println("Número de días no válido.");
        }
    }

    public boolean evaluarArriendo() {
        return cliente.isVigente() && vehiculo.getCondicion() == 'D';
    }

    public boolean ingresarArriendo() {
        if (evaluarArriendo()) {
            vehiculo.setCondicion('A');
            return true;
        } else {
            System.out.println("El arriendo no es válido.");
            return false;
        }
    }

    public double obtenerMontoAPagar() {
        return diasArriendo * precioDiario;
    }

    public void generarTicketArriendo() {
        System.out.println("---------------------------------------------------------");
        System.out.println("TICKET ARRIENDO DE VEHÍCULO");
        System.out.println("NÚMERO ARRIENDO: " + numeroArriendo);
        System.out.println("VEHÍCULO: " + vehiculo);
        System.out.println("PRECIO DIARIO: $" + precioDiario);
        System.out.println("FECHA CLIENTE DÍAS A PAGAR");
        System.out.println("---------------------------------------------------------");
        System.out.println(fechaArriendo + " " + cliente + " " + diasArriendo + " días $" + obtenerMontoAPagar());
        System.out.println("---------------------------------------------------------");
        System.out.println("___________________");
        System.out.println("FIRMA CLIENTE");
        System.out.println("---------------------------------------------------------");
    }
}
