# Relatório: Tarefas Separadas com CompletionService

## 1. Objetivo
Este exemplo demonstra o uso do `CompletionService` em Java para separar a geração e o processamento de relatórios em tarefas concorrentes. Utilizando duas classes de solicitação de relatório (para "Face" e "Online") e um processador de relatórios, o sistema permite que os relatórios sejam gerados e consumidos de forma assíncrona.

## 2. Estrutura do Código
- **PedidoRelatorio (ReportRequest)**:  
  - Implementa `Runnable` e cria uma tarefa de geração de relatório (usando `GeradorRelatorio`).
  - Submete a tarefa ao `CompletionService` para processamento assíncrono.

- **ProcessadorRelatorio (ReportProcessor)**:  
  - Implementa `Runnable` e consome os resultados do `CompletionService`.
  - Utiliza o método `poll()` com timeout para recuperar os relatórios gerados e os imprime.

- **GeradorRelatorio (ReportGenerator)**:  
  - Implementa `Callable<String>` e simula a geração de um relatório com um atraso aleatório.
  - Retorna uma mensagem concatenando o remetente e o título do relatório.

- **Principal (Main)**:  
  - Inicializa um `ExecutorService` e um `CompletionService`.
  - Cria e inicia threads para os pedidos de relatório (para "Face" e "Online") e para o processador.
  - Aguarda a finalização dos pedidos, encerra o executor e sinaliza o término do processamento.

## 3. Fluxo de Execução
1. As threads de `PedidoRelatorio` criam e submetem tarefas de geração de relatório para "Face" e "Online" ao `CompletionService`.
2. O `ProcessadorRelatorio` fica em loop, aguardando os resultados dos relatórios com um timeout de 20 segundos.
3. Quando um relatório é gerado, o processador o consome e o imprime.
4. Após a finalização dos pedidos, o executor é desligado e o processador é sinalizado para encerrar seu loop.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Principal: Iniciando as Threads
Principal: Aguardando os geradores de relatório.
Principal: Encerrando o executor.
Validador Online_Report: GeradorRelatorio: Gerando um relatório durante 1 segundos
Validador Face_Report: GeradorRelatorio: Gerando um relatório durante 4 segundos
ProcessadorRelatorio: Relatório recebido: Online: Relatório
ProcessadorRelatorio: Relatório recebido: Face: Relatório
Principal: Encerramento
```

## 5. Conclusão
O uso do `CompletionService` permite separar a criação de tarefas de geração de relatório do processamento dos resultados, facilitando o desenvolvimento de sistemas assíncronos e concorrentes. Essa abordagem melhora a eficiência ao permitir que a tarefa de processamento consuma os resultados assim que estiverem disponíveis, sem bloquear a criação de novas tarefas. É uma técnica fundamental para aplicações que exigem alta performance e escalabilidade.
