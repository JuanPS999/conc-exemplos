# Relatório: Fabricação e Monitoramento de Threads

## 1. Objetivo

O objetivo deste exercício é demonstrar a criação personalizada de threads utilizando a interface `ThreadFactory` e o monitoramento das threads criadas através de estatísticas. O código implementa uma fábrica de threads que cria threads com nomes únicos e armazena informações sobre sua criação, como o nome da thread, seu ID e o horário de criação.

## 2. Estrutura do Código

### 2.1. Classe `FabricaThreads`
- **Descrição:** 
  - Implementa a interface `ThreadFactory` para criar threads com nomes personalizados e armazenar estatísticas sobre elas.
- **Método `newThread`:**
  - Este método cria uma nova thread, atribui um nome único baseado no contador de threads e adiciona estatísticas sobre sua criação.
- **Método `getEstatisticas`:**
  - Retorna uma string contendo as estatísticas das threads criadas, como o nome e o horário de criação.

### 2.2. Classe `Tarefa`
- **Descrição:** 
  - Implementa a interface `Runnable` para ser executada em múltiplas threads.
- **Funcionamento:**
  - Cada thread executa a tarefa de dormir por 1 segundo, simulando um trabalho realizado pela thread.

### 2.3. Classe `Principal`
- **Descrição:** 
  - Orquestra a criação e execução das threads utilizando a fábrica de threads.
- **Funcionamento:**
  - Cria a fábrica de threads e a tarefa a ser executada.
  - Inicializa 5 threads utilizando a fábrica e exibe as estatísticas de criação das threads.

## 3. Exemplo de Execução

**Saída do Console:**

```
Iniciando as Threads
Thread 1 criada com o nome FabricaThreads-Thread_0 em Mon Feb 11 12:34:56 GMT 2025
Thread 2 criada com o nome FabricaThreads-Thread_1 em Mon Feb 11 12:34:56 GMT 2025
Thread 3 criada com o nome FabricaThreads-Thread_2 em Mon Feb 11 12:34:56 GMT 2025
Thread 4 criada com o nome FabricaThreads-Thread_3 em Mon Feb 11 12:34:56 GMT 2025
Thread 5 criada com o nome FabricaThreads-Thread_4 em Mon Feb 11 12:34:56 GMT 2025
Estatísticas da fábrica:
Thread 1 criada com o nome FabricaThreads-Thread_0 em Mon Feb 11 12:34:56 GMT 2025
Thread 2 criada com o nome FabricaThreads-Thread_1 em Mon Feb 11 12:34:56 GMT 2025
Thread 3 criada com o nome FabricaThreads-Thread_2 em Mon Feb 11 12:34:56 GMT 2025
Thread 4 criada com o nome FabricaThreads-Thread_3 em Mon Feb 11 12:34:56 GMT 2025
Thread 5 criada com o nome FabricaThreads-Thread_4 em Mon Feb 11 12:34:56 GMT 2025
```

## 4. Modificações Realizadas

- **Customização da Criação das Threads:** 
  - Foi implementado um método `newThread` que cria threads com nomes personalizados e mantém um histórico de sua criação.
- **Estatísticas de Criação:** 
  - Cada thread criada tem suas estatísticas registradas, como o nome da thread e a data de criação, permitindo monitoramento do processo.

## 5. Testes Realizados

- **Cenário 1:** Criação e execução de 5 threads utilizando a fábrica de threads.
  - Resultado esperado: As threads são criadas com nomes únicos e executam a tarefa de dormir por 1 segundo.
  - As estatísticas sobre as threads criadas são exibidas corretamente após a execução.

## 6. Conclusão

Este exercício permitiu demonstrar a criação personalizada de threads em Java utilizando a interface `ThreadFactory`. A personalização do nome das threads e o registro de suas estatísticas proporcionam uma forma eficiente de monitorar a execução de múltiplas threads. As modificações realizadas no código validaram a funcionalidade da fábrica de threads e a exibição das estatísticas geradas.
