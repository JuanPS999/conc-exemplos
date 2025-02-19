# Relatório: Execução de Múltiplas Tarefas com Vários Resultados

## 1. Objetivo
Este exemplo demonstra o uso de um pool de threads para executar tarefas que retornam resultados (neste caso, o cálculo de um valor simulado). As tarefas são submetidas a um `ExecutorService` e, após a conclusão, os resultados de cada tarefa são coletados e exibidos. Essa abordagem permite processar múltiplas tarefas de forma concorrente e obter seus resultados de forma coordenada.

## 2. Estrutura do Código
- **Resultado (Resultado)**:  
  - Classe simples que armazena o nome e o valor resultante do processamento de uma tarefa.

- **Tarefa (Tarefa)**:  
  - Implementa a interface `Callable<Resultado>` e simula o processamento, introduzindo um atraso aleatório e somando 5 números aleatórios.
  - Retorna um objeto do tipo `Resultado` contendo o nome da tarefa e o valor calculado.

- **Principal (Principal)**:  
  - Cria um `ExecutorService` com pool de threads cacheado.
  - Submete 3 instâncias de `Tarefa` para execução e aguarda a conclusão de todas.
  - Coleta e exibe os resultados retornados por cada tarefa.
  - Encerra o executor após a conclusão das tarefas.

## 3. Fluxo de Execução
1. O método `main` inicia criando um executor e uma lista de tarefas.
2. São criadas 3 tarefas, cada uma com um nome único (por exemplo, "Tarefa-0", "Tarefa-1", "Tarefa-2").
3. As tarefas são submetidas ao executor utilizando o método `invokeAll`, que bloqueia até que todas as tarefas sejam concluídas.
4. Após a execução, os resultados de cada tarefa são recuperados dos objetos `Future` e exibidos.
5. Finalmente, o executor é desligado e o programa imprime os resultados.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Wed May 15 13:20:39 CST 2013
Tarefa-0: Iniciando
Tarefa-1: Iniciando
Tarefa-2: Iniciando
Tarefa-0: Aguardando 6 segundos para obter resultados.
Tarefa-1: Aguardando 7 segundos para obter resultados.
Tarefa-2: Aguardando 6 segundos para obter resultados.
Tarefa-0: Finalizando
Tarefa-1: Finalizando
Tarefa-2: Finalizando
Wed May 15 13:20:47 CST 2013
Principal: Imprimindo os resultados
Principal: Tarefa-0: 202
Principal: Tarefa-1: 302
Principal: Tarefa-2: 159
```

## 5. Conclusão
O exemplo evidencia como o uso de `Callable` e `ExecutorService` permite a execução concorrente de tarefas que retornam resultados. Ao utilizar o método `invokeAll`, o sistema aguarda a conclusão de todas as tarefas, facilitando a coleta e a exibição dos resultados. Essa abordagem é fundamental para aplicações que requerem processamento paralelo e agregação de resultados, garantindo eficiência e escalabilidade.
