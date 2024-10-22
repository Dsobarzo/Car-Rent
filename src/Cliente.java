public class Cliente {
    private String cedula;
    private final String nombre;
    private boolean vigente;

    public Cliente(String cedula, String nombre) {
        setCedula(cedula);
        this.nombre = nombre;
        this.vigente = true; // Inicialmente vigente
    }

    public void setCedula(String cedula) {
        if (cedula != null && cedula.matches("\\d{8}-[0-9k]")) {
            this.cedula = cedula;
        }
        else {
            System.out.println("Cédula no válida!!.");
        }
    }

    public void deshabilitar() {
        this.vigente = false;
    }

    public boolean isVigente() {
        return this.vigente;
    }

    @Override
    public String toString() {
        return cedula + "/" + nombre;
    }
}
