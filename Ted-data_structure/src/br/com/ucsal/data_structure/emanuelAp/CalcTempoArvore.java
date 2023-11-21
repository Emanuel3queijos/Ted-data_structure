package br.com.ucsal.data_structure.emanuelAp;

import java.util.Random;

public class CalcTempoArvore {

    static Random rand = new Random();

    static Tree tree = new Tree();

    public static void calcularTempo10() {
        long start = System.currentTimeMillis();

        Integer[] values = gerarRandom(10);

        for (int i = 0; i < values.length; i++) {
            String inserted = tree.insert(values[i]);
            System.out.println(inserted + " " + values[i]);

        }


        tree.printTree();
        imprimirTempo(start, System.currentTimeMillis());


    }

    public static void calcularTempo100() {
        long start = System.currentTimeMillis();

        Integer[] values = gerarRandom(100);

        for (int i = 0; i < values.length; i++) {
            String inserted = tree.insert(values[i]);
            System.out.println(inserted + " " + values[i]);

        }


        tree.printTree();
        imprimirTempo(start, System.currentTimeMillis());


    }

    public static void calcularTempo1000() {
        long start = System.currentTimeMillis();

        Integer[] values = gerarRandom(1000);

        for (int i = 0; i < values.length; i++) {
            String inserted = tree.insert(values[i]);
            System.out.println(inserted + " " + values[i]);

        }


        tree.printTree();
        imprimirTempo(start, System.currentTimeMillis());


    }

    public static void calcularTempo10000() {
        long start = System.currentTimeMillis();

        Integer[] values = gerarRandom(10000);

        for (int i = 0; i < values.length; i++) {
            String inserted = tree.insert(values[i]);
            System.out.println(inserted + " " + values[i]);

        }


        tree.printTree();
        imprimirTempo(start, System.currentTimeMillis());


    }

    public static void main(String[] args) {
        System.out.println("---Tempo execução vetor 10 elementos---");
        calcularTempo10();
        System.out.println("---Tempo execução vetor 100 elementos---");
        calcularTempo100();
        System.out.println("---Tempo execução vetor 1000 elementos---");
        calcularTempo1000();
        System.out.println("---Tempo execução vetor 10000 elementos---");
        calcularTempo10000();
    }


    public static Integer[] gerarRandom(Integer x) {
        Integer[] values = new Integer[x];

        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(201) - 100;

        }
        return values;
    }

    private static void imprimirTempo(Long start, Long currentMs) {
        System.out.println("Tempo decorrido: " + (currentMs - start) + " ms");
    }
}


