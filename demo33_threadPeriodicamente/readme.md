# Relatório: Execução Periódica de Tarefas com ScheduledExecutorService

## 1. Objetivo
Este exemplo demonstra o uso do `ScheduledExecutorService` em Java para agendar a execução periódica de uma tarefa. A tarefa é executada repetidamente com um atraso fixo, e o programa monitora o atraso até a próxima execução.

## 2. Estrutura do Código
- **Tarefa**:  
  Implementa a interface `Runnable` e representa a tarefa que é executada periodicamente. Ao ser executada, a tarefa imprime seu nome e o horário de execução.

- **Principal**:  
  Utiliza um `ScheduledExecutorService` para agendar a execução da tarefa com um atraso inicial de 1 segundo e um período de 2 segundos. O programa monitora o atraso entre execuções e, após um determinado tempo, encerra o executor e exibe o horário final.

## 3. Fluxo de Execução
1. O método `main` inicia o executor e agenda a execução da tarefa.
2. A tarefa é executada repetidamente em intervalos regulares (2 segundos).
3. O programa monitora o atraso da próxima execução a cada 500 milissegundos, por 10 iterações.
4. Após o monitoramento, o executor é encerrado, e o programa aguarda o término antes de finalizar.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Principal: Iniciando em: Wed May 15 15:32:42 CST 2013
Principal: Atraso: 999 milissegundos
Principal: Atraso: 499 milissegundos
Principal: Atraso: 0 milissegundos
Tarefa: Executado em: Wed May 15 15:32:45 CST 2013
Principal: Atraso: 1498 milissegundos
Principal: Atraso: 998 milissegundos
Principal: Atraso: 498 milissegundos
Principal: Atraso: -1 milissegundos
Tarefa: Executado em: Wed May 15 15:32:47 CST 2013
...
Principal: Sem mais tarefas em: Wed May 15 15:32:49 CST 2013
Principal: Finalizado em: Wed May 15 15:32:54 CST 2013
```

## 5. Conclusão
Este exemplo evidencia como o `ScheduledExecutorService` pode ser utilizado para agendar tarefas que precisam ser executadas periodicamente. Ao monitorar o atraso entre as execuções, o sistema permite uma gestão precisa do tempo de execução, sendo uma abordagem essencial para aplicações que requerem operações temporizadas de forma repetitiva e confiável.
