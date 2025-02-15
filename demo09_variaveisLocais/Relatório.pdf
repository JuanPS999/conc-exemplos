## Relatório sobre o Código: Uso de `ThreadLocal` e `InheritableThreadLocal`

### 1. **Objetivo**

O código demonstra o uso de `ThreadLocal` e `InheritableThreadLocal` para armazenar valores que são exclusivos para cada thread. A principal diferença entre ambos é que `ThreadLocal` mantém valores separados para cada thread, enquanto `InheritableThreadLocal` permite que valores sejam passados para threads filhas.

### 2. **Estrutura do Código**

O código está dividido em várias classes e demonstra os seguintes comportamentos:

- **InheritableThreadLocalTest**: Demonstra o uso de `InheritableThreadLocal`, mostrando como o valor pode ser compartilhado entre threads filhas.
- **ThreadLocalTest**: Demonstra o uso de `ThreadLocal`, criando múltiplas threads, cada uma com seu próprio valor único.
- **Principal**: Usa tanto `ThreadLocal` quanto `InheritableThreadLocal` para mostrar a diferença de comportamento entre ambos.
- **Sub**: Uma subclasse de `Thread`, que acessa o valor de um `ThreadLocal` recebido no seu construtor.

### 3. **Funcionamento**

- **InheritableThreadLocal**: O valor é passado para as threads filhas, permitindo que elas compartilhem o mesmo valor.
- **ThreadLocal**: Cada thread tem seu próprio valor, sem compartilhamento entre threads.
  
**Exemplo de Saída:**
- Para `InheritableThreadLocal`: 
    ```
    Principal-1:ThreadLocal-VAL
    Filha-1:null
    Filha-2:InheritableThreadLocal-VAL
    ```
- Para `ThreadLocal`:
    ```
    Nome da thread 1 : main
    Nome da thread 2 : main
    ```

### 4. **Testes Realizados**
   
- **Testando `InheritableThreadLocal`**: As threads filhas conseguiram acessar o valor configurado na thread principal.
- **Testando `ThreadLocal`**: Cada thread teve seu próprio valor, mostrando que os valores não são compartilhados.

### 5. **Conclusão**

- O uso de `InheritableThreadLocal` é adequado quando é necessário que as threads filhas herdem o valor da thread principal.
- `ThreadLocal` é ideal quando cada thread precisa de seu próprio valor exclusivo.
- O código funciona conforme esperado, demonstrando as diferenças e usos dessas classes para manipulação de dados por thread.
