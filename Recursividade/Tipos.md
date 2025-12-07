# Tipos de Recursividade

Este documento apresenta os principais tipos de recursão utilizados em programação, com explicações claras e exemplos práticos em Java.

---

## 📌 1. Recursão Direta

A recursão direta ocorre quando **um método chama ele mesmo** diretamente.

### **Exemplo:**

```java
public int fatorial(int n) {
    if (n == 0)
        return 1;
    return n * fatorial(n - 1); // chamada direta
}
```

### ✔️ Características:

* O próprio método chama sua próxima execução.
* É o tipo mais comum de recursão.

---

## 📌 2. Recursão Indireta (Recursão Mútua)

A recursão indireta acontece quando **um método A chama o método B**, e **B chama novamente A**.

### **Exemplo:**

```java
public boolean isEven(int n) {
    if (n == 0)
        return true;
    return isOdd(n - 1); // chama o outro método
}

public boolean isOdd(int n) {
    if (n == 0)
        return false;
    return isEven(n - 1); // chama o primeiro método
}
```

### ✔️ Características:

* Dois ou mais métodos dependem uns dos outros.
* Usada em problemas onde há alternância de estados.

---

## 📌 3. Recursão de Cauda (Tail Recursion)

A recursão de cauda ocorre quando **a última instrução da função é a chamada recursiva**.

### **Exemplo:**

```java
public int soma(int n, int acumulador) {
    if (n == 0)
        return acumulador;
    return soma(n - 1, acumulador + n); // última operação
}
```

### ✔️ Características:

* Não há trabalho adicional após a chamada recursiva.
* Permite otimizações pelo compilador (tail call optimization).

---

## 📌 4. Recursão Não de Cauda (Non-Tail Recursion)

Aqui, a chamada recursiva **não** é a última operação da função.

### **Exemplo:**

```java
public int fatorial(int n) {
    if (n == 0)
        return 1;
    return n * fatorial(n - 1); // ainda precisa multiplicar após a chamada
}
```

### ✔️ Características:

* Trabalho adicional é realizado após a chamada recursiva.
* Consome mais memória pois depende do resultado da chamada interna.

---

## 📌 5. Recursão Múltipla

Quando **um método chama ele mesmo mais de uma vez** dentro da mesma execução.

### **Exemplo clássico (Fibonacci):**

```java
public int fibonacci(int n) {
    if (n <= 1)
        return n;
    return fibonacci(n - 1) + fibonacci(n - 2); // duas chamadas recursivas
}
```

### ✔️ Características:

* Número de chamadas cresce exponencialmente.
* Pode ser muito custosa se não houver técnicas de otimização (memoização).

---

## 📌 Conclusão

A recursão é uma técnica poderosa, porém deve ser usada com cuidado. Cada tipo apresenta vantagens e desvantagens dependendo do problema. Entender esses tipos ajuda a escrever códigos mais claros, eficientes e adequados para cada situação.

---

**Autor:** Documento gerado automaticamente para apoiar estudos de Recursividade.
