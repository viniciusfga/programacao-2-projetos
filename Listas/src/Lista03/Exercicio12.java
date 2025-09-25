package Lista03;

import java.util.*;

public class Exercicio12 {
    static class Segmento {
        double x1, y1, x2, y2;
        Segmento(double x1, double y1, double x2, double y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
        boolean isHorizontal() {
            return y1 == y2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        List<Segmento> segs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            segs.add(new Segmento(x1, y1, x2, y2));
        }

        for (int c = 0; c < C; c++) {
            double xAtual = sc.nextDouble();
            double yAtual = 0;

            while (true) {
                double menorY = Double.MAX_VALUE;
                Segmento segEncontrado = null;
                double xInter = 0, yInter = 0;

                // Procurar segmento acima
                for (Segmento s : segs) {
                    // segmento entre x1 e x2?
                    if ((xAtual >= Math.min(s.x1, s.x2)) &&
                            (xAtual <= Math.max(s.x1, s.x2))) {
                        // Calcular y da interseção vertical
                        double ySeg;
                        if (s.x1 == s.x2) {
                            // segmento vertical (não dado no enunciado, mas previne divisão zero)
                            ySeg = Math.max(s.y1, s.y2);
                        } else {
                            double m = (s.y2 - s.y1) / (s.x2 - s.x1);
                            double b = s.y1 - m * s.x1;
                            ySeg = m * xAtual + b;
                        }

                        if (ySeg > yAtual && ySeg < menorY) {
                            menorY = ySeg;
                            segEncontrado = s;
                            xInter = xAtual;
                            yInter = ySeg;
                        }
                    }
                }

                if (segEncontrado == null) {
                    // Não encontrou segmento acima => escapa
                    System.out.println((int)xAtual);
                    break;
                }

                if (segEncontrado.isHorizontal()) {
                    // Fica preso
                    System.out.println((int)xInter + " " + (int)yInter);
                    break;
                } else {
                    // Segmento inclinado: escorregar para ponto mais alto
                    double xTopo, yTopo;
                    if (segEncontrado.y1 > segEncontrado.y2) {
                        xTopo = segEncontrado.x1; yTopo = segEncontrado.y1;
                    } else {
                        xTopo = segEncontrado.x2; yTopo = segEncontrado.y2;
                    }
                    xAtual = xTopo;
                    yAtual = yTopo;
                    // Continua o laço
                }
            }
        }
        sc.close();
    }
}
