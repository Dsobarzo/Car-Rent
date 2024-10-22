public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int anoFabricacion;
    private char condicion; // D: Disponible, A: Arrendado, M: Mantención

    public Vehiculo(String patente, String marca, String modelo, int anoFabricacion) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnoFabricacion(anoFabricacion);
        this.condicion = 'D'; // Inicialmente disponible
    }

    public void setPatente(String patente) {
        if (patente != null && patente.length() == 8) {
            this.patente = patente.toUpperCase();
        } else {
            System.out.println("Patente no válida.");
        }
    }

    public void setMarca(String marca) {
        if (marca != null) {
            this.marca = marca.toUpperCase();
        } else {
            System.out.println("Marca no válida.");
        }
    }

    public void setModelo(String modelo) {
        if (modelo != null) {
            this.modelo = modelo.toUpperCase();
        } else {
            System.out.println("Modelo no válido.");
        }
    }

    public void setAnoFabricacion(int anoFabricacion) {
        if (anoFabricacion >= 2000 && anoFabricacion <= java.time.Year.now().getValue()) {
            this.anoFabricacion = anoFabricacion;
        } else {
            System.out.println("Año de fabricación no válido.");
        }
    }

    public void setCondicion(char condicion) {
        if (condicion == 'D' || condicion == 'A' || condicion == 'M') {
            this.condicion = condicion;
        } else {
            System.out.println("Condición no válida.");
        }
    }

    public char getCondicion() {
        return this.condicion;
    }

    /*public String getPatente() {
        return this.patente;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }*/

    @Override
    public String toString() {
        return patente + " - " + marca + " " + modelo + " (" + anoFabricacion + ")";
    }
}
