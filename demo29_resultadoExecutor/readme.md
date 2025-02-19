# Relatório: Resultados com Executor de Tarefas e Cálculo Fatorial

## 1. Objetivo
Este exemplo demonstra o uso de um pool de threads com tamanho fixo para executar tarefas que calculam o fatorial de números aleatórios. Cada tarefa é submetida a um `ThreadPoolExecutor` e os resultados são monitorados e exibidos após a conclusão de todas as tarefas.

## 2. Estrutura do Código
- **CalculadoraFatorial (CalculadoraFatorial)**:  
  Implementa a interface `Callable` para calcular o fatorial de um número. Simula um atraso de 20 milissegundos durante o cálculo e retorna o resultado.

- **Principal (Principal)**:  
  Cria um pool de threads fixo com 2 threads usando `Executors.newFixedThreadPool(2)`. Em um loop, são submetidas 10 tarefas (instâncias de `CalculadoraFatorial`) com números aleatórios. O progresso das tarefas é monitorado, e após a conclusão, os resultados são coletados e exibidos.

## 3. Fluxo de Execução
1. O método `main` cria um `ThreadPoolExecutor` com 2 threads.
2. São submetidas 10 tarefas para calcular o fatorial de números aleatórios entre 0 e 9.
3. Um loop monitora o número de tarefas concluídas, verificando o status de cada tarefa.
4. Após todas as tarefas serem concluídas, os resultados são coletados através dos objetos `Future` e exibidos.
5. Por fim, o executor é desligado.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Principal: Número de Tarefas Concluídas: 0
Principal: Tarefa 0: false
Principal: Tarefa 1: false
...
Thread-1: 120
Thread-0: 720
...
Principal: Número de Tarefas Concluídas: 10
Principal: Resultados
Principal: Tarefa 0: 120
Principal: Tarefa 1: 720
...
```

## 5. Conclusão
O exemplo ilustra como utilizar um pool de threads para gerenciar a execução de tarefas que realizam cálculos computacionais (neste caso, o fatorial). O uso de ThreadPoolExecutor possibilita a submissão e o monitoramento das tarefas de forma eficiente, garantindo que os recursos do sistema sejam utilizados de maneira controlada. Essa abordagem é essencial para aplicações que exigem alto desempenho e escalabilidade.
