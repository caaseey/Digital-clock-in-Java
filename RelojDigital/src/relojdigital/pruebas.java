package relojdigital;

import java.util.Scanner;

public class pruebas {

    public static void main(String[] args) {
        int[] reloj = new int[4];
        System.out.print("Hora del reloj: ");
        iniciarReloj(reloj);
        int opc = 0;
        do {
            mostrarReloj(reloj);
            opc = menu(opc);
            switch (opc) {
                case 1:
                    adelantarReloj(reloj);
                    break;
                case 2:
                    retrasarReloj(reloj);
                    break;
                case 3:
                    adelantarMinuto(reloj);
                    break;
                case 4:
                    retrasarMinuto(reloj);
                    break;
            }
        } while (opc != 0);
    }

    public static void iniciarReloj(int[] reloj) {
        reloj[0] = 0;
        reloj[1] = 0;
        reloj[2] = 0;
        reloj[3] = 0;
    }

    public static void mostrarReloj(int[] reloj) {
        System.out.println("" + reloj[0] + reloj[1] + ":" + reloj[2] + reloj[3]);
    }

    public static void adelantarReloj(int[] reloj) {
        reloj[1]++;
        if (reloj[0] == 2 && reloj[1] == 4) {
            reloj[0] = 0;
            reloj[1] = 0;
        } else if (reloj[0] == 1 && reloj[1] == 10) {
            reloj[0] = 2;
            reloj[1] = 0;
        } else if (reloj[0] == 0 && reloj[1] == 10) {
            reloj[0] = 1;
            reloj[1] = 0;
        }
    }

    public static void retrasarReloj(int[] reloj) {
        if (reloj[0] == 0 && reloj[1] == 0) {
            reloj[0] = 2;
            reloj[1] = 3;
        } else if (reloj[0] == 1 && reloj[1] == 0) {
            reloj[0] = 0;
            reloj[1] = 9;
        } else if (reloj[0] == 2 && reloj[1] == 0) {
            reloj[0] = 1;
            reloj[1] = 9;
        } else if (reloj[0] == 0 && reloj[1] == 0) {
            reloj[0] = 2;
            reloj[1] = 3;
        } else {
            reloj[1]--;
        }
    }

    public static void adelantarMinuto(int[] reloj) {
        reloj[3]++;
        if (reloj[2] == 5 && reloj[3] == 10) {
            reloj[2] = 0;
            reloj[3] = 0;
            adelantarReloj(reloj);
        } else if (reloj[3] == 10) {
            reloj[2]++;
            reloj[3] = 0;
        }
    }

    public static void retrasarMinuto(int[] reloj) {
        reloj[3]--;
        if (reloj[3] < 0) {
            reloj[2]--;
            reloj[3] = 9;
            if (reloj[2] < 0) {
                reloj[2] = 5;
                reloj[1]--;
                if (reloj[1] < 0) {
                    if (reloj[0] == 2) {
                        reloj[0] = 1;
                        reloj[1] = 9;
                    }
                    if (reloj[0] == 1) {
                        reloj[0] = 0;
                        reloj[1] = 9;
                    }
                    if (reloj[0] == 0) {
                        reloj[0] = 2;
                        reloj[1] = 3;
                    }
                }
            }
        }

    }

    public static int menu(int opc) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] Para adelantar 1 hora");
        System.out.println("[2] Para retrasar 1 hora");
        System.out.println("[3] Para adelantar 1 minuto");
        System.out.println("[4] Para retrasar 1 minuto");
        System.out.println("[0] Para salir");
        System.out.print("Escriba su opcion: ");
        opc = sc.nextInt();
        return opc;
    }
}
