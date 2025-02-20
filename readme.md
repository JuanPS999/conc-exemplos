# Repositório de Exemplos de Programação Concorrente

Este repositório contém diversos exemplos de técnicas de programação concorrente em Java, desenvolvidos e adaptados ao longo do estudo. Cada demo ilustra um conceito ou mecanismo específico, desde operações básicas com threads até frameworks avançados para processamento paralelo. A seguir, uma breve descrição de cada demonstração (demo):

---

## Lista de Demonstrações

- **demo05_dormir**  
  Demonstra o uso simples do método `Thread.sleep()` para pausar a execução de uma thread.

- **demo06_join**  
  Exibe como utilizar o método `join()` para sincronizar a finalização de threads com a thread principal.

- **demo07_daemon**  
  Ilustra o funcionamento de threads daemon, que são finalizadas automaticamente quando as threads não daemon terminam.

- **demo08_excecoesNaoControladas**  
  Demonstra o comportamento de exceções não controladas em threads, mostrando como elas afetam a execução.

- **demo09_variaveisLocais**  
  Exemplifica o uso de variáveis locais e, possivelmente, de `ThreadLocal` ou `InheritableThreadLocal` para manter dados específicos por thread.

- **demo10_grupoThreads**  
  Mostra a criação e gerenciamento de grupos de threads (`ThreadGroup`), facilitando o controle coletivo de threads.

- **demo11_tratarExecoes**  
  Apresenta técnicas para tratamento de exceções em ambientes concorrentes, garantindo que erros sejam capturados e tratados adequadamente.

- **demo12_fabricaThreads**  
  Demonstra a implementação de uma fábrica de threads (ThreadFactory), que permite a criação personalizada de threads com nomes e estatísticas.

- **demo13_sincronizar**  
  Ilustra métodos de sincronização (por exemplo, `synchronized`) para controlar o acesso a recursos compartilhados entre threads.

- **demo14_organizar**  
  Exemplifica a organização e coordenação de múltiplas threads para realizar tarefas em conjunto, com comentários que explicam cada etapa.

- **demo15_condicoes**  
  Demonstra o uso de condições com `wait()` e `notify()` para sincronizar a comunicação entre threads (ex.: produtor/consumidor).

- **demo16_syncLock**  
  Mostra a utilização de `ReentrantLock` para sincronizar o acesso a um recurso compartilhado, exemplificado por uma fila de impressão.

- **demo17_readWriteLock**  
  Ilustra o uso de `ReentrantReadWriteLock` para permitir acesso concorrente em leituras e exclusividade em escritas, no contexto de informações de preços.

- **demo18_modifyLock**  
  Demonstra modificações de dados utilizando locks, com exemplos que simulam operações em uma fila de impressão com seções de código distintas.

- **demo19_multiCondicoes**  
  Apresenta a coordenação de múltiplas condições (utilizando `Condition`) para gerenciar a comunicação entre threads produtoras e consumidoras.

- **demo20_controleRecursos**  
  Exibe o controle de recursos com o uso de `Semaphore`, gerenciando múltiplas impressoras para processamento de trabalhos.

- **demo21_semaforoMultiplasCopias**  
  Demonstra o uso de `Semaphore` para controlar o acesso a recursos que permitem múltiplas cópias simultâneas.

- **demo22_aguardandoMultiplosEventos**  
  Utiliza `CountDownLatch` para sincronizar a chegada de múltiplos participantes em uma videoconferência, iniciando a reunião somente quando todos estão presentes.

- **demo23_syncPontosComuns**  
  Mostra a sincronização de pontos comuns entre threads, possivelmente utilizando mecanismos como `CyclicBarrier` para agrupar resultados.

- **demo24_tarefasEmFases**  
  Demonstra a execução de tarefas divididas em fases usando `Phaser`, permitindo que múltiplas threads sincronizem seu progresso em etapas.

- **demo25_mudancaDeFasesControle**  
  Ilustra o controle de fases em um exame simulado, onde cada aluno (thread) realiza exercícios em etapas, sincronizando via `Phaser` customizado.

- **demo26_mudancaDados**  
  Exibe o uso de `Exchanger` para trocar dados entre duas threads (produtor e consumidor), permitindo a atualização de informações de forma sincronizada.

- **demo27_threadExecutor**  
  Demonstra a utilização de um executor de threads para submeter e executar tarefas concorrentes.

- **demo28_executorTamanhoFixo**  
  Apresenta o uso de um pool de threads de tamanho fixo (fixed thread pool) para gerenciar a execução de tarefas de forma controlada.

- **demo29_resultadoExecutor**  
  Ilustra a execução de tarefas que retornam resultados, utilizando `Callable` e `Future` para capturar e exibir os resultados.

- **demo30_multiTarefasPrimeiroResultado**  
  Demonstra a utilização do método `invokeAny` para obter o primeiro resultado válido entre várias tarefas concorrentes.

- **demo31_multiresultados**  
  Mostra a combinação de resultados de tarefas concorrentes utilizando o framework Fork/Join para processar dados em paralelo.

- **demo32_aposDelay**  
  Utiliza o `ScheduledExecutorService` para agendar tarefas com atraso, demonstrando a execução temporizada de tarefas.

- **demo33_threadPeriodicamente**  
  Exibe a execução periódica de uma tarefa usando `scheduleAtFixedRate`, monitorando o atraso entre execuções.

- **demo34_cancelandoTarefa**  
  Demonstra como cancelar uma tarefa em execução utilizando `Future.cancel()` e monitorar seu status após o cancelamento.

- **demo35_controlandoFinal**  
  Ilustra o controle de finalização de tarefas com `FutureTask`, personalizando o método `done()` para indicar se uma tarefa foi concluída ou cancelada.

- **demo36_tarefasSeparadas**  
  Utiliza `CompletionService` para separar a geração e o processamento de relatórios, permitindo a execução assíncrona e o consumo dos resultados conforme ficam disponíveis.

- **demo37_controlandoTarefasRejeitadas**  
  Mostra como implementar um `RejectedExecutionHandler` para tratar tarefas rejeitadas após o shutdown do executor, exibindo informações sobre o estado do executor.

- **demo38_fork**  
  Demonstra o uso do framework Fork/Join para atualizar preços de produtos de forma paralela, dividindo a tarefa em subtarefas até que o processamento seja direto.

- **demo39_combinandoResultados**  
  Exibe a combinação de resultados obtidos através do framework Fork/Join para contar ocorrências de uma palavra em um documento, utilizando tarefas subdivididas e a agregação dos resultados.

- **demo40_tarefaAssincrona**  
  Utiliza o `ScheduledExecutorService` para agendar a execução de tarefas assíncronas com atraso, retornando uma mensagem após a execução.

---

## Instruções Gerais de Uso

Cada demonstração (demo) possui um diretório com seu código-fonte e um relatório detalhado (em formato Markdown) que explica o objetivo, a estrutura, o fluxo de execução, um exemplo de saída e a conclusão do exemplo. Para explorar cada demo, basta navegar até o diretório correspondente e seguir as instruções fornecidas nos relatórios.

Por exemplo, para compilar e executar um exemplo Java, você pode usar os comandos:
```bash
javac Principal.java
java Principal
``` 
ou, se a demo utilizar o Fork/Join ou ScheduledExecutorService, siga as instruções específicas contidas no relatório de cada demo.

### Referências e Recursos
- **Java Concurrency in Practice** – Um livro essencial para aprofundar os conceitos de programação concorrente em Java.
- **Documentação Oficial da Oracle** – Disponível em [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/essential/concurrency/), oferece detalhes completos sobre threads, executores, locks e outros mecanismos concorrentes.
- **Java Concurrency Cookbook** - Um ótimo livro para aprender concorrência em java, disponibilizado por [Vaquar Khan](https://github.com/vaquarkhan/JavaConcurrencyExamples/(https://github.com/vaquarkhan/JavaConcurrencyExamples/)(https://github.com/vaquarkhan/JavaConcurrencyExamples/).
