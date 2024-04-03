package segundaVersion;

public class PacienteDos implements Comparable<PacienteDos> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    public PacienteDos(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    @Override
    public int compareTo(PacienteDos otroPaciente) {
        return Character.compare(this.codigoEmergencia, otroPaciente.codigoEmergencia);
    }
}