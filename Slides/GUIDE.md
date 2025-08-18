
---

## Exercícios já implementados

### 1. **Exercicio_330.java**
- **Descrição:** Lê um número inteiro `a` e calcula uma soma baseada em múltiplos de `((7*a)/3)` e números ímpares.
- **Conceitos praticados:**
    - Estrutura de repetição `for`
    - Operações aritméticas e precedência
    - Entrada de dados com `Scanner`
- **Sugestões de melhoria:**
    - Pode ser simplificado usando fórmulas matemáticas (soma de ímpares = n²).
    - Fechar o `Scanner` após o uso.

---

### 2. **Exercicio_333.java**
- **Descrição:** Tenta calcular o valor de π (pi) usando uma série numérica.
- **Problemas encontrados:**
    - Fórmula incorreta (`pi *= somatorio` deveria ser `pi = 4 * somatorio`).
    - Critério de parada sem uso de `Math.abs()`.
    - Estrutura mais complexa que o necessário.
- **Conceitos praticados:**
    - Estrutura de repetição `while`
    - Operações com números de ponto flutuante
    - Critérios de convergência
- **Sugestões de melhoria:**
    - Usar diretamente a **série de Leibniz** para π:  
      \[
      \pi = 4 \cdot \sum_{k=0}^{\infty} \frac{(-1)^k}{2k+1}
      \]
    - Melhorar nomes de variáveis e clareza do código.

---

## Como compilar e executar

1. Compilar:
   ```bash
   javac src/Exercicio_330.java
   javac src/Exercicio_333.java
