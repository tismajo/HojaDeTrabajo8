/*
 * Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * CC2016 – Algoritmos y Estructura de Datos - 40
 * María José Girón Isidro 23559
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VectorHeap<Paciente> colaPacientes = new VectorHeap<>();

        // Leer datos de pacientes del archivo pacientes.txt
        try {
            File file = new File("pacientes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] pacienteData = scanner.nextLine().split(",");
                String nombre = pacienteData[0].trim();
                String sintoma = pacienteData[1].trim();
                char codigoEmergencia = pacienteData[2].trim().charAt(0);
                Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                colaPacientes.add(paciente);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
            return;
        }

        // Atender pacientes en orden de prioridad
        while (!colaPacientes.isEmpty()) {
            Paciente paciente = colaPacientes.remove();
            System.out.println(paciente.getNombre() + ", " + paciente.getSintoma() + ", " + paciente.getCodigoEmergencia());
        }
    }
}
