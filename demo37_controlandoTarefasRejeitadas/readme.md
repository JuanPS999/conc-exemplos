# Relatório: Controlando Tarefas Rejeitadas

## 1. Objetivo
Este exemplo demonstra o controle de tarefas rejeitadas em um ambiente concorrente usando um `ThreadPoolExecutor` em Java. Ao encerrar o executor e tentar submeter uma nova tarefa, o sistema rejeita essa tarefa. Um controlador personalizado (ControladorTarefaRejeitada) é utilizado para tratar essas rejeições, exibindo informações sobre a tarefa rejeitada e o estado do executor.

## 2. Estrutura do Código
- **Tarefa**:  
  Implementa a interface `Runnable` e simula a geração de um relatório com um atraso aleatório. A tarefa exibe mensagens informando seu início e término.

- **ControladorTarefaRejeitada**:  
  Implementa a interface `RejectedExecutionHandler` e define o comportamento a ser executado quando uma tarefa é rejeitada pelo executor. Ele imprime mensagens detalhadas, incluindo o estado do executor (se está terminando ou já terminou).

- **Principal**:  
  Cria um pool de threads cacheado e configura-o para usar o `ControladorTarefaRejeitada`. Submete três tarefas ao executor e, após encerrar o executor, tenta enviar uma tarefa adicional, que é rejeitada. Em seguida, o estado do executor e a rejeição são exibidos.

## 3. Fluxo de Execução
1. O método `main` cria um `ThreadPoolExecutor` e configura o controlador personalizado para tratar tarefas rejeitadas.
2. Três instâncias de `Tarefa` são submetidas ao executor para execução.
3. O executor é encerrado utilizando `shutdown()`.
4. Após o encerramento, uma nova tarefa é submetida; essa tarefa é rejeitada e o controlador imprime os detalhes da rejeição.
5. O programa exibe mensagens indicando o início e o fim do processamento.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Principal: Iniciando.
Tarefa Tarefa0: Iniciando
Tarefa Tarefa1: Iniciando
Tarefa Tarefa2: Iniciando
Principal: Encerrando o Executor.
Encerrado: true
Principal: Enviando outra Tarefa.
ControladorTarefaRejeitada: A tarefa TarefaRejeitada foi rejeitada
ControladorTarefaRejeitada: java.util.concurrent.ThreadPoolExecutor@1922f46[Shutting down, pool size = 3, active threads = 3, queued tasks = 0, completed tasks = 0]
ControladorTarefaRejeitada: Terminando: true
ControladorTarefaRejeitada: Terminado: false
Principal: Fim.
Tarefa Tarefa0: Terminando
Tarefa Tarefa1: Terminando
Tarefa Tarefa2: Terminando
```

## 5. Conclusão
O exemplo ilustra como o uso de um `RejectedExecutionHandler` personalizado permite o monitoramento e controle sobre tarefas que são submetidas após o encerramento do executor. Essa técnica é essencial para garantir que, em sistemas concorrentes, as operações rejeitadas sejam tratadas de forma apropriada, possibilitando a depuração e a manutenção da integridade do sistema.
