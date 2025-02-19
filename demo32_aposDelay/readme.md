# Relatório: Execução de Tarefas Agendadas com Atraso

## 1. Objetivo
Este exemplo demonstra o uso do `ScheduledExecutorService` em Java para agendar a execução de tarefas com atrasos específicos. Cada tarefa, ao ser executada, imprime o horário de início formatado e retorna uma mensagem, exemplificando como programar execuções futuras em um ambiente concorrente.

## 2. Estrutura do Código
- **Tarefa**:  
  Implementa a interface `Callable<String>` e representa uma tarefa agendada. Ao ser executada, a tarefa imprime o horário de início utilizando um `SimpleDateFormat` e retorna a mensagem "Hello, world".

- **Principal**:  
  Cria um `ScheduledExecutorService` com um pool de 1 thread e agenda 5 tarefas com atrasos incrementais de 1 segundo até 5 segundos. Após agendar as tarefas, o executor é desligado e o programa aguarda a conclusão de todas as tarefas, exibindo o horário final de execução.

## 3. Fluxo de Execução
1. O método `main` inicia o `ScheduledExecutorService`.
2. São agendadas 5 tarefas, cada uma com um atraso crescente (1, 2, 3, 4 e 5 segundos).
3. Cada tarefa, ao ser executada, imprime o horário de início.
4. Após todas as tarefas serem executadas, o executor é desligado e o horário de finalização é exibido.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Principal: Iniciando em: Wed May 15 13:20:39 CST 2023
Tarefa-0: Iniciando em: 15:30.567
Tarefa-1: Iniciando em: 15:30.568
Tarefa-2: Iniciando em: 15:30.569
Tarefa-3: Iniciando em: 15:30.570
Tarefa-4: Iniciando em: 15:30.571
Principal: Finalizando em: Wed May 15 13:20:47 CST 2023
```

## 5. Conclusão
O exemplo demonstra como o `ScheduledExecutorService` pode ser utilizado para agendar a execução de tarefas com atrasos específicos. Essa abordagem é fundamental para aplicações que necessitam de operações temporizadas ou programadas, permitindo uma execução organizada e previsível de tarefas concorrentes.
