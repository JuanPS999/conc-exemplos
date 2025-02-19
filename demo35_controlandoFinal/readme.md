# Relatório: Controle de Finalização de Tarefas com FutureTask

## 1. Objetivo
Este exemplo demonstra o uso de `FutureTask` para gerenciar a finalização de tarefas que retornam um resultado. Através da classe personalizada `TarefaResultado`, o sistema monitora se uma tarefa foi cancelada ou finalizada e imprime os resultados das tarefas que não foram canceladas. Essa abordagem permite o controle refinado do término das tarefas em um ambiente concorrente.

## 2. Estrutura do Código
- **TarefaExecutavel**:  
  - Implementa a interface `Callable<String>` e simula um processamento com atraso aleatório.
  - Retorna uma mensagem que inclui o nome da tarefa após a conclusão do processamento.

- **TarefaResultado**:  
  - Estende `FutureTask<String>` para encapsular a execução da `TarefaExecutavel`.
  - Personaliza o método `done()` para imprimir uma mensagem indicando se a tarefa foi cancelada ou finalizada.

- **Principal**:  
  - Cria um pool de threads utilizando `Executors.newCachedThreadPool()`.
  - Submete 5 tarefas ao executor, aguarda 5 segundos e, em seguida, cancela todas as tarefas.
  - Após o cancelamento, tenta obter e imprimir os resultados das tarefas que não foram canceladas e encerra o executor.

## 3. Fluxo de Execução
1. O método `main` cria um pool de threads e 5 instâncias de `TarefaExecutavel`, cada uma encapsulada em um `TarefaResultado`.
2. As tarefas são submetidas ao executor, iniciando sua execução simultânea.
3. Após 5 segundos, o método `cancel()` é chamado em cada tarefa.
4. O método `done()` de cada `TarefaResultado` é executado, imprimindo se a tarefa foi cancelada ou finalizada.
5. O `Principal` tenta recuperar e imprimir os resultados das tarefas que não foram canceladas.
6. Por fim, o executor é desligado.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Tarefa 0: Aguardando 6 segundos para obter resultados.
Tarefa 1: Aguardando 7 segundos para obter resultados.
Tarefa 2: Aguardando 3 segundos para obter resultados.
Tarefa 3: Aguardando 4 segundos para obter resultados.
Tarefa 4: Aguardando 5 segundos para obter resultados.
Tarefa 0: Foi cancelada
Tarefa 1: Foi cancelada
Tarefa 2: Foi finalizada
Tarefa 3: Foi cancelada
Tarefa 4: Foi cancelada

Imprimindo os resultados:

Principal: Olá, mundo. Eu sou Tarefa 2
```

## 5. Conclusão
O exemplo evidencia como o uso de `FutureTask` e a personalização do método `done()` permitem monitorar e controlar a finalização de tarefas concorrentes. Ao cancelar tarefas após um período determinado e imprimir os resultados das que não foram canceladas, o sistema demonstra uma abordagem robusta para gerenciamento de tarefas em ambientes concorrentes, garantindo que os recursos sejam utilizados de forma eficiente e controlada.
