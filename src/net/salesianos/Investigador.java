package net.salesianos;

public abstract class Investigador {

    protected String nombre;
    protected String especialidad;
    protected double sueldo;

    public Investigador(String nombre, String especialidad, double sueldo) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
    }

    public void identificacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Sueldo: " + sueldo);
    }

    public void hacerCalculoBasico(int num1, int num2) {
        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
    }

    public abstract String estadoSueldo();

    public abstract void trabajar();
}