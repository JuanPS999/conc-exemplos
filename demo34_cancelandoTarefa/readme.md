# Relatório: Cancelamento de Tarefa com Executor de Threads

## 1. Objetivo
Este exemplo demonstra como cancelar uma tarefa em execução utilizando um `ThreadPoolExecutor` e o método `cancel()` do objeto `Future`. A tarefa é projetada para executar indefinidamente, mas é interrompida após um determinado período, ilustrando o controle sobre tarefas longas ou infinitas.

## 2. Estrutura do Código
- **Tarefa**:  
  Implementa a interface `Callable<String>` e executa um loop infinito, imprimindo a mensagem "Tarefa: Teste" a cada 100 milissegundos.

- **Principal**:  
  Cria um pool de threads com `Executors.newCachedThreadPool()`, submete a `Tarefa` para execução e, após 2 segundos, cancela a tarefa. Em seguida, verifica e exibe o status de cancelamento e conclusão da tarefa antes de encerrar o executor.

## 3. Fluxo de Execução
1. O método `main` submete uma instância de `Tarefa` ao pool de threads.
2. A tarefa entra em um loop infinito, imprimindo "Tarefa: Teste" repetidamente.
3. Após 2 segundos, o método `main` cancela a execução da tarefa usando `cancel(true)`.
4. O status da tarefa é verificado com `isCancelled()` e `isDone()`.
5. O executor é encerrado, finalizando a execução do programa.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Principal: Executando a Tarefa
Tarefa: Teste
Tarefa: Teste
...
Principal: Cancelando a Tarefa
Principal: Cancelada: true
Principal: Concluída: true
Principal: O executor terminou
```

## 5. Conclusão
O exemplo ilustra como é possível cancelar uma tarefa em execução utilizando o método `cancel()` do objeto `Future`. Essa abordagem é essencial para gerenciar tarefas que podem se prolongar indefinidamente, permitindo que o sistema interrompa operações desnecessárias ou problemáticas e otimize a utilização dos recursos do executor.
