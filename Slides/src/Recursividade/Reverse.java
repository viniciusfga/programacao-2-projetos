package Recursividade;

import java.util.*;

    /*
        Escreva um método recursivo que inverta os elementos do
        vetor. O método deve receber como entrada o vetor, os
        valores i e j que devem ser números inteiros e positivos
    */

public class Reverse {
    /*
    // Verificar índices
        if (i < 0 || i >= A.length) {
            System.out.println("Índice i inválido: " + i);
            throw new IndexOutOfBoundsException("Índice i inválido: " + i);
        }

        if (j < 0 || j >= A.length) {
            System.out.println("Índice j inválido: " + j);
            throw new IndexOutOfBoundsException("Índice j inválido: " + j);
        }
     */
    public static void reverse(int[] A, int i, int j) {
        if (i < j) {
            replacement(A, i , j);
            reverse(A, i + 1 , j - 1);
        }
    }

    public static void replacement(int[] A, int i, int j) {
        int indiceTemporario = A[i];
        A[i] = A[j];
        A[j] = indiceTemporario;
    }

    public static void main(String[] args) {

        int[] vector = {1, 2, 3, 4, 5};

        reverse(vector, 1, 4);

        System.out.println(Arrays.toString(vector));

    }
}
