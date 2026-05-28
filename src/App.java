import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import net.salesianos.Biologo;
import net.salesianos.Investigador;
import net.salesianos.Matematico;
import net.salesianos.Quimico;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Investigador> investigadores = new ArrayList<>();

        investigadores.add(new Matematico("Iker", "Matemáticas", 1700));
        investigadores.add(new Biologo("Fernando", "Biología", 1400));
        investigadores.add(new Quimico("Pedrito Picapiedra", "Química", 1100));

        int opcionInvestigador;
        int opcionMenu = 0;

        try {

            System.out.println("SEDE DE INVESTIGADORES");
            System.out.println("Selecciona un investigador:");
            System.out.println("0. Matemático");
            System.out.println("1. Biólogo");
            System.out.println("2. Químico");

            opcionInvestigador = scanner.nextInt();
            scanner.nextLine();

            Investigador investigador = investigadores.get(opcionInvestigador);

            do {
                System.out.println();
                System.out.println("1. Identificación");
                System.out.println("2. Cálculo básico");
                System.out.println("3. Estado del sueldo");
                System.out.println("4. Trabajar");
                System.out.println("5. Trabajo especial");
                System.out.println("6. Salir");
                System.out.print("Elige una opción: ");

                opcionMenu = scanner.nextInt();
                scanner.nextLine();

                switch (opcionMenu) {

                    case 1:
                        investigador.identificacion();
                        break;

                    case 2:
                        System.out.print("Introduce el primer número: ");
                        int num1 = scanner.nextInt();

                        System.out.print("Introduce el segundo número: ");
                        int num2 = scanner.nextInt();
                        scanner.nextLine();

                        investigador.hacerCalculoBasico(num1, num2);
                        break;

                    case 3:
                        System.out.println(investigador.estadoSueldo());
                        break;

                    case 4:
                        investigador.trabajar();
                        break;

                    case 5:
                        menuEspecial(scanner, investigador);
                        break;

                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción incorrecta.");
                        break;
                }

            } while (opcionMenu != 6);

        } catch (InputMismatchException e) {
            System.out.println("Error: debes introducir un número.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: investigador no válido.");
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }

    public static void menuEspecial(Scanner scanner, Investigador investigador) {

        if (investigador instanceof Matematico) {

            Matematico matematico = (Matematico) investigador;

            System.out.println("1. Multiplicar matriz por número");
            System.out.println("2. Sumar matriz 3x3");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Introduce un número: ");
                int numero = scanner.nextInt();

                matematico.trabajar(numero);
            } else if (opcion == 2) {

                int[][] matriz = {
                        { 1, 1, 1 },
                        { 1, 1, 1 },
                        { 1, 1, 1 }
                };

                matematico.trabajar(matriz);
            } else {
                System.out.println("Opción incorrecta.");
            }

        } else if (investigador instanceof Biologo) {

            Biologo biologo = (Biologo) investigador;

            System.out.println("1. Añadir espécimen");
            System.out.println("2. Mostrar especímenes");
            System.out.println("3. Trabajo dual");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Introduce el espécimen: ");
                String especimen = scanner.nextLine();

                biologo.anadirEspecimen(especimen);
            } else if (opcion == 2) {
                biologo.mostrarEspecimenes();
            } else if (opcion == 3) {
                biologo.trabajoDual();
            } else {
                System.out.println("Opción incorrecta.");
            }

        } else if (investigador instanceof Quimico) {

            Quimico quimico = (Quimico) investigador;

            System.out.println("1. Añadir elemento");
            System.out.println("2. Mostrar elementos");
            System.out.println("3. Trabajo dual");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Introduce el elemento: ");
                String elemento = scanner.nextLine();

                quimico.anadirElemento(elemento);
            } else if (opcion == 2) {
                quimico.mostrarElementos();
            } else if (opcion == 3) {
                quimico.trabajoDual();
            } else {
                System.out.println("Opción incorrecta.");
            }
        }
    }
}