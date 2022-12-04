import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al programa de metodos de ordenamiento");
        while (opcion != 6) {
            try {
                System.out.println("1. Burbuja");
                System.out.println("2. Insercion");
                System.out.println("3. Seleccion");
                System.out.println("4. QuickSort");
                System.out.println("5. MergeSort");
                System.out.println("6. Salir");
                System.out.println("Ingrese una opcion");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Burbuja");
                        Burbuja();
                        break;
                    case 2:
                        System.out.println("Insercion");
                        Insercion();
                        break;
                    case 3:
                        System.out.println("Seleccion");
                        Seleccion();
                        break;
                    case 4:
                        System.out.println("QuickSort");
                        QuickSort();
                        break;
                    case 5:
                        System.out.println("MergeSort");
                        MergeSort();
                        break;
                    case 6:
                        System.out.println("Gracias por usar el programa");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Valor no valido");
                sc.nextLine();
            }
        }
    }
    public static void MergeSort() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el tamaño del arreglo");
            int tam = sc.nextInt();
            int[] arreglo = new int[tam];
            System.out.println("Ingrese los valores del arreglo");
            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = sc.nextInt();
            }
            long startTime = System.nanoTime();
            MergeSort(arreglo, 0, arreglo.length - 1);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("El tiempo de ejecucion es: " + duration + " nanosegundos");
            System.out.println("El arreglo ordenado es: ");
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Valor no valido");
        }
    }
    private static void MergeSort(int[] arreglo, int i, int j) {
        if (i < j) {
            int m = (i + j) / 2;
            MergeSort(arreglo, i, m);
            MergeSort(arreglo, m + 1, j);
            Merge(arreglo, i, m, j);
        }
    }
    private static void Merge(int[] arreglo, int i, int m, int j) {
        int[] aux = new int[arreglo.length];
        for (int k = i; k <= j; k++) {
            aux[k] = arreglo[k];
        }
        int a = i;
        int b = m + 1;
        for (int k = i; k <= j; k++) {
            if (a > m) {
                arreglo[k] = aux[b++];
            } else if (b > j) {
                arreglo[k] = aux[a++];
            } else if (aux[a] < aux[b]) {
                arreglo[k] = aux[a++];
            } else {
                arreglo[k] = aux[b++];
            }
        }
    }
    public static void QuickSort() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el tamaño del arreglo");
            int tam = sc.nextInt();
            int[] arreglo = new int[tam];
            System.out.println("Ingrese los valores del arreglo");
            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = sc.nextInt();
            }
            long startTime = System.nanoTime();
            QuickSort(arreglo, 0, arreglo.length - 1);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("El tiempo de ejecucion es: " + duration + " nanosegundos");
            System.out.println("El arreglo ordenado es: ");
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Valor no valido");
        }
    }
    private static void QuickSort(int[] arreglo, int i, int j) {
        if (i < j) {
            int p = particion(arreglo, i, j);
            QuickSort(arreglo, i, p - 1);
            QuickSort(arreglo, p + 1, j);
        }
    }
    private static int particion(int[] arreglo, int i, int j) {
        int pivote = arreglo[i];
        int a = i;
        int b = j;
        while (a < b) {
            while (arreglo[a] <= pivote && a < j) {
                a++;
            }
            while (arreglo[b] > pivote) {
                b--;
            }
            if (a < b) {
                int aux = arreglo[a];
                arreglo[a] = arreglo[b];
                arreglo[b] = aux;
            }
        }
        arreglo[i] = arreglo[b];
        arreglo[b] = pivote;
        return b;
    }
    public static void Seleccion() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el tamaño del arreglo");
            int tam = sc.nextInt();
            int[] arreglo = new int[tam];
            System.out.println("Ingrese los valores del arreglo");
            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = sc.nextInt();
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < arreglo.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arreglo.length; j++) {
                    if (arreglo[j] < arreglo[min]) {
                        min = j;
                    }
                }
                int aux = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = aux;
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("El tiempo de ejecucion es: " + duration + " nanosegundos");
            System.out.println("El arreglo ordenado es: ");
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Valor no valido");
        }
    }
    public static void Insercion() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el tamaño del arreglo");
            int tam = sc.nextInt();
            int[] arreglo = new int[tam];
            System.out.println("Ingrese los valores del arreglo");
            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = sc.nextInt();
            }
            long startTime = System.nanoTime();
            for (int i = 1; i < arreglo.length; i++) {
                int aux = arreglo[i];
                int j = i - 1;
                while (j >= 0 && arreglo[j] > aux) {
                    arreglo[j + 1] = arreglo[j];
                    j--;
                }
                arreglo[j + 1] = aux;
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("El tiempo de ejecucion es: " + duration + " nanosegundos");
            System.out.println("El arreglo ordenado es: ");
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Valor no valido");
        }
    }
    public static void Burbuja() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el tamaño del arreglo");
            int tam = sc.nextInt();
            int[] arreglo = new int[tam];
            System.out.println("Ingrese los valores del arreglo");
            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = sc.nextInt();
            }
            long startTime = System.nanoTime();
            for (int i = 0; i < arreglo.length - 1; i++) {
                for (int j = 0; j < arreglo.length - 1; j++) {
                    if (arreglo[j] > arreglo[j + 1]) {
                        int aux = arreglo[j];
                        arreglo[j] = arreglo[j + 1];
                        arreglo[j + 1] = aux;
                    }
                }
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("El tiempo de ejecucion es: " + duration + " nanosegundos");
            System.out.println("El arreglo ordenado es: ");
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Valor no valido");
        }
    }
}
