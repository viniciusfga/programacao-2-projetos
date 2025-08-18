# Lista de Exercícios - Programação 2

## Exercício 1

### 3.30
Elabore um fluxograma e um algoritmo em Portugol que representem o algoritmo para calcular a soma dos primeiros 40 termos da sequência abaixo, com o valor de **A** fornecido via teclado:

\[
S = \frac{7 \cdot A}{3} - \frac{7 \cdot A}{6} + \frac{7 \cdot A}{12} - \frac{7 \cdot A}{24} + \frac{7 \cdot A}{48} - \ldots
\]

---

### 3.33
O número \(\pi\) pode ser calculado por meio da série infinita:

\[
\pi = 4 \cdot \left(1 - \frac{1}{3} + \frac{1}{5} - \frac{1}{7} + \frac{1}{9} - \frac{1}{11} + \frac{1}{13} - \ldots \right)
\]

Elabore um fluxograma e um algoritmo em Portugol que calculem e exibam o valor do número \(\pi\) utilizando a série anterior, até que o valor absoluto da diferença entre o número calculado em uma iteração e o da anterior seja menor ou igual a **0.00000000005**.

---

## Exercício 2
Elabore um programa que permita a entrada de um número inteiro entre 1 e 9999 e escreva seu valor por extenso.

---

### 4.11
Escreva a expansão da expressão \((a+b)^n\) para um valor de \(n\) lido.  
Os termos da expansão são os valores da n-ésima linha do triângulo de Pascal. Por exemplo:

\[
(a+b)^3 = a^3 + 3a^2b + 3ab^2 + b^3
\]

O fluxograma e o algoritmo em Portugol deverão exibir a resposta no seguinte formato:

\[
(a+b)^3 = a^3 + 3*a^2*b + 3*a*b^2 + b^3
\]

> Observação: `*` representa a operação de multiplicação e `^` a operação de potenciação.  
> O tipo de dado a ser exibido é uma cadeia de caracteres.
