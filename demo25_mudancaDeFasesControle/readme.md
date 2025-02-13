# Relatório: Sincronização de Tarefas em Fases com Phaser

## 1. Objetivo
Este exemplo demonstra o uso do `Phaser` em Java para coordenar as atividades de um exame dividido em fases. Cada aluno realiza uma série de exercícios e espera que todos os colegas terminem a mesma fase antes de avançar para a próxima. A sincronização é personalizada através da classe `MeuPhaser`, que define ações específicas para cada fase do exame.

## 2. Estrutura do Código
- **Aluno**:  
  Representa um estudante que participa do exame. Cada aluno realiza três exercícios, aguardando que todos os colegas concluam a mesma fase antes de prosseguir.

- **MeuPhaser**:  
  Estende a classe `Phaser` para customizar o comportamento entre as fases do exame. Define métodos específicos que são executados ao final de cada fase, exibindo mensagens informativas sobre o progresso.

- **Principal**:  
  Inicializa o sistema registrando 5 alunos no `MeuPhaser` e cria as threads correspondentes para executar as tarefas. Após a conclusão de todas as fases, o sistema informa se o `Phaser` foi encerrado.

## 3. Fluxo de Execução
1. A classe `Principal` cria um objeto `MeuPhaser` e registra 5 alunos.
2. Cada aluno, ao iniciar sua thread, imprime mensagens indicando sua chegada e a realização de cada exercício.
3. Ao final de cada fase (chegada, término do primeiro exercício, segundo exercício e exame completo), os alunos chamam `arriveAndAwaitAdvance()`, aguardando a sincronização de todos.
4. A classe `MeuPhaser` executa métodos específicos para cada fase:
   - **Fase 0**: Confirma a chegada de todos os alunos e inicia o exame.
   - **Fase 1**: Indica a conclusão do primeiro exercício e a passagem para o segundo.
   - **Fase 2**: Indica a conclusão do segundo exercício e a passagem para o terceiro.
   - **Fase 3**: Indica o término do exame e encerra o `Phaser`.
5. Após todas as fases, o `Phaser` é encerrado e o programa exibe uma mensagem final.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Aluno 0: Chegou para fazer o exame. Sat Feb 10 15:30:12 BRT 2025
Aluno 1: Chegou para fazer o exame. Sat Feb 10 15:30:13 BRT 2025
...
Phaser: O exame vai começar. Todos os alunos estão prontos.
Phaser: Temos 5 alunos.
Aluno 0: Vai fazer o primeiro exercício. Sat Feb 10 15:30:14 BRT 2025
Aluno 0: Terminou o primeiro exercício. Sat Feb 10 15:30:18 BRT 2025
...
Phaser: Todos os alunos terminaram o primeiro exercício.
Phaser: É hora do segundo exercício.
...
Phaser: Todos os alunos terminaram o segundo exercício.
Phaser: É hora do terceiro exercício.
...
Aluno 0: Finalizou o exame. Sat Feb 10 15:31:00 BRT 2025
...
Phaser: Todos os alunos finalizaram o exame.
Phaser: Obrigado pelo tempo de vocês.
Principal: O phaser terminou: true.
```

## 5. Conclusão

Este exemplo evidencia a importância do Phaser para sincronizar múltiplas fases de execução em um ambiente concorrente. Ao garantir que todos os alunos completem cada fase antes de avançar, o sistema mantém a ordem e a coordenação necessárias para o sucesso do exame. A customização do Phaser por meio da classe MeuPhaser demonstra como adaptar a sincronização às necessidades específicas de uma aplicação, facilitando o controle de tarefas em fases.
