# Relatório: Mudança de Dados com Exchanger

## 1. Objetivo
Este exemplo demonstra o uso do `Exchanger` em Java para realizar a troca de dados entre duas threads: um produtor e um consumidor. O produtor preenche um buffer com mensagens (eventos) e, a cada ciclo, troca o conteúdo do buffer com o consumidor. O consumidor, por sua vez, recebe o buffer, processa as mensagens e esvazia o buffer, permitindo que o ciclo se repita. Essa abordagem ilustra como sincronizar a troca de informações entre threads de forma segura e coordenada.

## 2. Estrutura do Código
- **Produtor**:  
  - Preenche um buffer com 10 mensagens por ciclo.  
  - Utiliza o método `exchange` do `Exchanger` para trocar o buffer com o consumidor.  
  - Exibe mensagens indicando o início do ciclo e o tamanho do buffer após a troca.

- **Consumidor**:  
  - Utiliza o `Exchanger` para receber o buffer preenchido pelo produtor.  
  - Processa e remove 10 mensagens do buffer a cada ciclo.  
  - Exibe mensagens indicando o ciclo atual e o número de elementos no buffer recebido.

- **Principal**:  
  - Inicializa dois buffers e um `Exchanger` para listas de strings.  
  - Cria instâncias de `Produtor` e `Consumidor`, iniciando as threads correspondentes para executar o processo de troca de dados.

## 3. Fluxo de Execução
1. O produtor preenche seu buffer com 10 mensagens numeradas, indicando o ciclo atual.
2. Após preencher o buffer, o produtor utiliza o `Exchanger` para trocar o buffer com o consumidor.
3. O consumidor recebe o buffer, exibe o tamanho do buffer e processa cada mensagem, removendo-a do buffer.
4. Esse processo se repete por 10 ciclos, permitindo a troca contínua de dados entre as duas threads.
5. Ao final de cada ciclo, ambos os participantes exibem informações sobre o estado do buffer.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Produtor: Ciclo 1
Produtor: Evento 0
Produtor: Evento 1
...
Produtor: Evento 9
Produtor: Buffer com 10 elementos
Consumidor: Ciclo 1
Consumidor: Buffer com 10 elementos
Consumidor: Evento 0
Consumidor: Evento 1
...
Consumidor: Evento 9
Produtor: Ciclo 2
...
```

## 5. Conclusão
O uso do `Exchanger` neste exemplo permite que duas threads troquem dados de forma sincronizada, garantindo que o produtor e o consumidor operem em ciclos coordenados. Essa técnica é útil para situações em que é necessário intercambiar informações entre threads de maneira segura, permitindo a implementação de processos paralelos que dependem da troca de dados entre seus componentes.
