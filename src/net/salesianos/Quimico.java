package net.salesianos;

import java.util.ArrayList;

public class Quimico extends Investigador implements TrabajoDual {

    private ArrayList<String> elementosReaccion;

    public Quimico(String nombre, String especialidad, double sueldo) {
        super(nombre, especialidad, sueldo);
        elementosReaccion = new ArrayList<>();
    }

    public void anadirElemento(String elemento) {
        elementosReaccion.add(elemento);
        System.out.println("Elemento añadido.");
    }

    @Override
    public String estadoSueldo() {
        if (sueldo < 1200) {
            return "El químico solicita un aumento.";
        } else {
            return "El sueldo del químico es correcto.";
        }
    }

    @Override
    public void trabajar() {

        if (elementosReaccion.isEmpty()) {
            System.out.println("No hay elementos en la reacción.");
        } else {
            invertirLista();
            mostrarElementos();
        }
    }

    @Override
    public void trabajoDual() {

        if (elementosReaccion.isEmpty()) {
            System.out.println("No hay elementos para ordenar.");
        } else {
            ordenarPorLongitud();
            eliminarMayor();
            mostrarElementos();
        }
    }

    private void invertirLista() {

        for (int i = 0; i < elementosReaccion.size() / 2; i++) {

            String aux = elementosReaccion.get(i);

            elementosReaccion.set(
                    i,
                    elementosReaccion.get(elementosReaccion.size() - 1 - i));

            elementosReaccion.set(
                    elementosReaccion.size() - 1 - i,
                    aux);
        }

        System.out.println("Lista invertida.");
    }

    private void ordenarPorLongitud() {

        for (int i = 0; i < elementosReaccion.size(); i++) {

            for (int j = 0; j < elementosReaccion.size() - 1; j++) {

                if (elementosReaccion.get(j).length() > elementosReaccion.get(j + 1).length()) {

                    String aux = elementosReaccion.get(j);

                    elementosReaccion.set(
                            j,
                            elementosReaccion.get(j + 1));

                    elementosReaccion.set(j + 1, aux);
                }
            }
        }
    }

    private void eliminarMayor() {

        elementosReaccion.remove(elementosReaccion.size() - 1);

        System.out.println(
                "Se ha eliminado el elemento con más caracteres.");
    }

    public void mostrarElementos() {

        if (elementosReaccion.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {

            for (String elemento : elementosReaccion) {
                System.out.println("- " + elemento);
            }
        }
    }
}