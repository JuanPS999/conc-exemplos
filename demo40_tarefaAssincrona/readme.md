# Relatório: Tarefa Assíncrona para Processamento de Pastas com Fork/Join

## 1. Objetivo
Este exemplo demonstra o uso do framework Fork/Join em Java para processar recursivamente diretórios e identificar arquivos que terminam com uma extensão específica. O objetivo é buscar e listar os caminhos dos arquivos que possuem uma determinada extensão (por exemplo, "log") em diversos diretórios do sistema.

## 2. Estrutura do Código
- **ProcessadorPasta**:  
  - Extende `RecursiveTask<List<String>>` e implementa o método `compute()` para processar recursivamente os diretórios.  
  - Se o segmento de arquivos for pequeno (menos de 10 arquivos), o processamento é feito diretamente; caso contrário, a tarefa é subdividida em subtarefas.  
  - Os resultados das subtarefas são combinados para formar uma lista completa dos arquivos encontrados.

- **Principal**:  
  - Cria um `ForkJoinPool` e instâncias de `ProcessadorPasta` para três diretórios diferentes: "C:\\Windows", "C:\\Program Files" e "C:\\Documents And Settings".  
  - Executa as tarefas no pool e monitora o progresso da execução, exibindo estatísticas como paralelismo, threads ativas, tarefas em fila e tarefas roubadas.  
  - Ao final, os resultados são coletados e o número de arquivos encontrados em cada diretório é exibido.

## 3. Fluxo de Execução
1. O `ProcessadorPasta` percorre o diretório especificado, dividindo a tarefa para cada subdiretório e processando os arquivos que não são diretórios.
2. Para cada arquivo, o método `verificarArquivo()` confirma se o nome termina com a extensão desejada e, em caso afirmativo, adiciona seu caminho à lista.
3. As subtarefas são combinadas através do método `adicionarResultados()`, que agrega os resultados das tarefas secundárias.
4. Na classe `Principal`, as tarefas são executadas simultaneamente em um `ForkJoinPool` e o progresso é monitorado.
5. Após a conclusão, os resultados de cada tarefa são exibidos, mostrando o número total de arquivos encontrados em cada diretório.

## 4. Exemplo de Execução
**Saída do Console:**
```text
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
Sistema: 23 arquivos encontrados.
Aplicativos: 15 arquivos encontrados.
Documentos: 42 arquivos encontrados.
```

## 5. Conclusão
O exemplo evidencia a eficácia do framework `Fork/Join` para processar recursivamente diretórios, permitindo a divisão de tarefas em subtarefas menores que podem ser executadas de forma paralela. Essa abordagem otimiza o uso dos recursos do processador e melhora a performance na busca por arquivos, sendo ideal para aplicações que lidam com grandes volumes de dados de forma concorrente.
