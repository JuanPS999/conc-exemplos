# Relatório: Atualização de Preços com Fork/Join

## 1. Objetivo
Este exemplo demonstra o uso do framework Fork/Join em Java para atualizar os preços de uma lista de produtos de forma paralela. A tarefa é dividida recursivamente até que o segmento de produtos seja pequeno o suficiente para ser processado diretamente. Cada produto tem seu preço atualizado com um incremento de 20%, de modo que o preço inicial de 10 passa a ser 12.

## 2. Estrutura do Código
- **TarefaAtualizaPrecos (Task)**:  
  - Extende `RecursiveAction` e realiza a atualização dos preços dos produtos.
  - Se o segmento (diferença entre `ultimo` e `primeiro`) for menor que 10, o método `atualizarPrecos()` é chamado; caso contrário, a tarefa é dividida em duas subtarefas.
  - Exibe informações sobre o número de tarefas pendentes e os limites do segmento processado.

- **GeradorListaProdutos (ProductListGenerator)**:  
  - Gera uma lista de produtos, cada um com um preço inicial de 10.

- **Produto (Product)**:  
  - Classe simples que representa um produto com nome e preço.

- **Principal (Main)**:  
  - Inicializa a lista de produtos e cria uma tarefa para atualizar os preços com um incremento de 20%.
  - Utiliza um `ForkJoinPool` para executar a tarefa e monitora o progresso da execução.
  - Após a conclusão, verifica se os preços foram atualizados corretamente e exibe os produtos que não atingiram o preço esperado.

## 3. Fluxo de Execução
1. A classe `Principal` utiliza `GeradorListaProdutos` para criar uma lista de 40 produtos.
2. Uma instância de `TarefaAtualizaPrecos` é criada para atualizar os preços dos produtos de 0 a 40 com um incremento de 20%.
3. A tarefa é submetida a um `ForkJoinPool`, que divide recursivamente a tarefa até que os segmentos possam ser processados diretamente.
4. Durante a execução, são exibidas estatísticas do pool (threads ativas, tarefas roubadas e paralelismo).
5. Após a conclusão, o programa verifica se os preços foram atualizados para 12 e exibe os produtos que não atingiram o valor esperado.
6. O pool é encerrado e o programa finaliza.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Principal: Número de Threads Ativas: 3
Principal: Tarefas Roubadas: 5
Principal: Paralelismo: 4
Principal: O processo foi concluído normalmente.
Principal: Fim do programa.
```

## 5. Conclusão
Este exemplo evidencia a eficácia do framework `Fork/Join` para processar grandes volumes de dados de forma paralela. Ao dividir a tarefa de atualização de preços em subtarefas menores, o sistema consegue utilizar os recursos de forma otimizada, melhorando a performance e a escalabilidade do processamento. A abordagem é ideal para aplicações que demandam processamento intenso e que podem ser divididas em partes independentes.
