package net.salesianos;

public class Matematico extends Investigador {

    private int[][] resultadosActuales;

    public Matematico(String nombre, String especialidad, double sueldo) {
        super(nombre, especialidad, sueldo);

        resultadosActuales = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
    }

    @Override
    public String estadoSueldo() {
        if (sueldo < 1800) {
            return "El matemático solicita un aumento.";
        } else {
            return "El sueldo del matemático es correcto.";
        }
    }

    @Override
    public void trabajar() {
        System.out.println("El matemático está trabajando con matrices 3x3.");
    }

    public void trabajar(int numero) {
        for (int i = 0; i < resultadosActuales.length; i++) {
            for (int j = 0; j < resultadosActuales[i].length; j++) {
                resultadosActuales[i][j] = resultadosActuales[i][j] * numero;
            }
        }

        System.out.println("Matriz multiplicada por " + numero);
        mostrarMatriz();
    }

    public void trabajar(int[][] matriz) {
        for (int i = 0; i < resultadosActuales.length; i++) {
            for (int j = 0; j < resultadosActuales[i].length; j++) {
                resultadosActuales[i][j] = resultadosActuales[i][j] + matriz[i][j];
            }
        }

        System.out.println("Matrices sumadas.");
        mostrarMatriz();
    }

    public void mostrarMatriz() {
        for (int i = 0; i < resultadosActuales.length; i++) {
            for (int j = 0; j < resultadosActuales[i].length; j++) {
                System.out.print(resultadosActuales[i][j] + " ");
            }

            System.out.println();
        }
    }
}