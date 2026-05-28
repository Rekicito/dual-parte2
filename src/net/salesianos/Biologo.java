package net.salesianos;

import java.util.ArrayList;

public class Biologo extends Investigador implements TrabajoDual {

    private ArrayList<String> especimenes;

    public Biologo(String nombre, String especialidad, double sueldo) {
        super(nombre, especialidad, sueldo);
        especimenes = new ArrayList<>();
    }

    public void anadirEspecimen(String especimen) {
        especimenes.add(especimen);
        System.out.println("Espécimen añadido.");
    }

    @Override
    public String estadoSueldo() {
        if (sueldo < 1500) {
            return "El biólogo solicita un aumento.";
        } else {
            return "El sueldo del biólogo es correcto.";
        }
    }

    @Override
    public void trabajar() {
        if (especimenes.isEmpty()) {
            System.out.println("No hay especímenes.");
        } else {
            ordenarPorLongitud();
            eliminarMayor();
            mostrarEspecimenes();
        }
    }

    @Override
    public void trabajoDual() {
        if (especimenes.isEmpty()) {
            System.out.println("No hay especímenes para invertir.");
        } else {
            invertirLista();
            mostrarEspecimenes();
        }
    }

    private void ordenarPorLongitud() {
        for (int i = 0; i < especimenes.size(); i++) {
            for (int j = 0; j < especimenes.size() - 1; j++) {

                if (especimenes.get(j).length() > especimenes.get(j + 1).length()) {
                    String aux = especimenes.get(j);
                    especimenes.set(j, especimenes.get(j + 1));
                    especimenes.set(j + 1, aux);
                }
            }
        }
    }

    private void eliminarMayor() {
        especimenes.remove(especimenes.size() - 1);
        System.out.println("Se ha eliminado el espécimen con más caracteres.");
    }

    private void invertirLista() {
        for (int i = 0; i < especimenes.size() / 2; i++) {
            String aux = especimenes.get(i);
            especimenes.set(i, especimenes.get(especimenes.size() - 1 - i));
            especimenes.set(especimenes.size() - 1 - i, aux);
        }

        System.out.println("Lista invertida.");
    }

    public void mostrarEspecimenes() {
        if (especimenes.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (String especimen : especimenes) {
                System.out.println("- " + especimen);
            }
        }
    }
}