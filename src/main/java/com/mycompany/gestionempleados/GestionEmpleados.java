/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionempleados;

/**
 *
 * @author Dell
 */
import java.util.ArrayList;
import java.util.Scanner;

class Persona {
    protected int id;
    protected String nombre;
    
    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}

class Doctor extends Persona {
    private String especialidad;
    
    public Doctor(int id, String nombre, String especialidad) {
        super(id, nombre);
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad;
    }
}

class Deportista extends Persona {
    private String deporte;
    
    public Deportista(int id, String nombre, String deporte) {
        super(id, nombre);
        this.deporte = deporte;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Deporte: " + deporte;
    }
}

public class GestionEmpleados {
    private static final ArrayList<Persona> personas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    listarPersonas();
                    break;
                case 3:
                    buscarPersona();
                    break;
                case 4:
                    eliminarPersona();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no valida, intenta de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestion ---");
        System.out.println("1. Agregar persona");
        System.out.println("2. Listar personas");
        System.out.println("3. Buscar persona por ID");
        System.out.println("4. Eliminar persona");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void agregarPersona() {
        System.out.print("Ingrese ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Seleccione tipo de persona:");
        System.out.println("1. Doctor");
        System.out.println("2. Deportista");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (tipo) {
            case 1:
                System.out.print("Ingrese Especialidad: ");
                String especialidad = scanner.nextLine();
                personas.add(new Doctor(id, nombre, especialidad));
                break;
            case 2:
                System.out.print("Ingrese Deporte: ");
                String deporte = scanner.nextLine();
                personas.add(new Deportista(id, nombre, deporte));
                break;
            default:
                System.out.println("Opción invalida, no se agrego la persona.");
        }
        System.out.println("Persona agregada correctamente.");
    }

    private static void listarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("\nLista de Personas:");
            for (Persona p : personas) {
                System.out.println(p);
            }
        }
    }

    private static void buscarPersona() {
        System.out.print("Ingrese el ID de la persona a buscar: ");
        int id = scanner.nextInt();
        for (Persona p : personas) {
            if (p.getId() == id) {
                System.out.println("Persona encontrada: " + p);
                return;
            }
        }
        System.out.println("Persona no encontrada.");
    }

    private static void eliminarPersona() {
        System.out.print("Ingrese el ID de la persona a eliminar: ");
        int id = scanner.nextInt();
        for (Persona p : personas) {
            if (p.getId() == id) {
                personas.remove(p);
                System.out.println("Persona eliminada correctamente.");
                return;
            }
        }
        System.out.println("Persona no encontrada.");
    }
}
