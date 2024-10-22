import java.time.LocalDate;

public class Devolucion {
    private final Arriendo arriendo;
    private LocalDate fechaDevolucion;

    public Devolucion(Arriendo arriendo, LocalDate fechaDevolucion) {
        this.arriendo = arriendo;
        setFechaDevolucion(fechaDevolucion);
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        if (fechaDevolucion.isAfter(arriendo.fechaArriendo) || fechaDevolucion.isEqual(arriendo.fechaArriendo)) {
            this.fechaDevolucion = fechaDevolucion;
        } else {
            System.out.println("Fecha de devolución no válida.");
        }
    }

    public boolean ingresarDevolucion() {
        if (fechaDevolucion != null) {
            arriendo.vehiculo.setCondicion('D');
            return true;
        } else {
            return false;
        }
    }
}
