    package Ago;

    public class Exercicio01_MatrizZigZag {
        public static void main(String[] args) {
            int n = 3;

            int[][] m = {
                    {00, 01, 02},
                    {10, 11, 12},
                    {20, 21, 22},
            };


    //        for (int s = 0; s <= 2 * (n - 1); s++) {            // percorre diagonais
    //            if (s % 2 == 0)                                // par → sobe
    //                for (int i = Math.min(s, n - 1); i >= 0; i--) {
    //                    int j = s - i;
    //                    if (j < n)
    //                        System.out.print(m[i][j] + " ");
    //                }
    //            else                                            // ímpar → desce
    //                for (int j = Math.min(s, n - 1); j >= 0; j--) {
    //                    int i = s - j;
    //                    if (i < n)
    //                        System.out.print(m[i][j] + " ");
    //                }
    //        }


            for (int s = 0; s <= 2*(n-1); s++) {
                int a = Math.min(s, n-1), b = s - a;

                for (int k = 0; k <= a && k < n; k++) {
                    int i = (s % 2 == 0) ? a - k : b + k;
                    int j = s - i;
                    if (i < n && j < n) System.out.print(m[i][j] + " ");
                }
            }


        }
    }

