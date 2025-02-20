# Relatório: Combinando Resultados com Fork/Join

## 1. Objetivo
Este exemplo demonstra o uso do framework Fork/Join em Java para combinar resultados obtidos a partir da contagem de ocorrências de uma palavra em um documento. O documento é representado por uma matriz de strings gerada aleatoriamente. A tarefa é dividida recursivamente em subtarefas que processam partes do documento, e os resultados são combinados para fornecer a contagem total da palavra.

## 2. Estrutura do Código
- **DocumentoSimulado**:  
  Gera um documento representado por uma matriz de strings contendo palavras aleatórias. Durante a geração, exibe quantas vezes a palavra alvo aparece no documento.

- **TarefaDocumento**:  
  Extende `RecursiveTask<Integer>` e divide a tarefa de contagem de ocorrências em partes menores. Se o intervalo de linhas for pequeno (menos de 10 linhas), processa diretamente; caso contrário, divide a tarefa em duas subtarefas e agrupa os resultados.

- **TarefaLinha**:  
  Extende `RecursiveTask<Integer>` e processa uma linha do documento para contar quantas vezes a palavra aparece. Se o segmento de palavras for grande, divide a tarefa e agrupa os resultados.

- **Principal**:  
  Cria um documento utilizando `DocumentoSimulado`, inicializa a tarefa de contagem com `TarefaDocumento` e executa a tarefa em um `ForkJoinPool`. Após a conclusão, exibe o número total de ocorrências da palavra no documento.

## 3. Fluxo de Execução
1. O `DocumentoSimulado` gera um documento com 10 linhas e 100 palavras por linha, buscando a palavra "the".
2. Uma instância de `TarefaDocumento` é criada para processar o documento inteiro.
3. A tarefa é executada em um `ForkJoinPool`, que divide recursivamente o trabalho até que segmentos pequenos sejam processados diretamente.
4. Cada `TarefaLinha` conta as ocorrências da palavra "the" em sua linha, e os resultados são combinados para formar o resultado final.
5. O resultado final é exibido, indicando quantas vezes a palavra "the" aparece no documento.

## 4. Exemplo de Execução
**Saída do Console:**
```text
DocumentoSimulado: A palavra aparece 103 vezes no documento.
******************************************
Principal: Paralelismo: 2
Principal: Threads Ativas: 1
Principal: Tarefas em Fila: 0
Principal: Tarefas Roubadas: 0
******************************************
******************************************
Principal: Paralelismo: 2
Principal: Threads Ativas: 2
Principal: Tarefas em Fila: 8
Principal: Tarefas Roubadas: 0
******************************************
Principal: A palavra aparece 103 vezes no documento.
```

## 5. Conclusão
O exemplo evidencia a eficácia do framework `Fork/Join` para processar grandes volumes de dados de forma paralela. Ao dividir a tarefa de contagem de ocorrências em subtarefas menores, o sistema utiliza os recursos do processador de forma otimizada, melhorando a performance e a escalabilidade do processamento. Essa abordagem é ideal para aplicações que demandam processamento intensivo e concorrente de dados.
