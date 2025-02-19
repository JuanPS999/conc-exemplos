# Relatório: Execução de Múltiplas Tarefas com Retorno Primeiro (invokeAny)

## 1. Objetivo
Este exemplo demonstra o uso do método `invokeAny` de um `ExecutorService` para executar múltiplas tarefas concorrentes que validam um usuário. A tarefa que concluir primeiro e retornar um resultado é utilizada, enquanto as demais são canceladas. Essa abordagem é útil quando se deseja obter a primeira resposta válida dentre várias fontes de validação.

## 2. Estrutura do Código
- **ValidadorTarefa**:  
  Implementa `Callable<String>` e utiliza um `ValidadorUsuario` para validar as credenciais de um usuário. Se a validação falhar, lança uma exceção; caso contrário, retorna o nome do validador que teve sucesso.

- **ValidadorUsuario**:  
  Simula a validação de um usuário, introduzindo um atraso aleatório e retornando um valor booleano aleatório para simular sucesso ou falha na validação.

- **Principal**:  
  Inicializa dois validadores (LDAP e DataBase) e cria duas tarefas de validação. As tarefas são submetidas a um `ExecutorService` e o método `invokeAny` retorna o resultado da primeira tarefa concluída com sucesso.

## 3. Fluxo de Execução
1. O método `main` define as credenciais de usuário e cria instâncias de `ValidadorUsuario` para LDAP e DataBase.
2. São criadas duas tarefas de validação (`ValidadorTarefa`) utilizando os validadores correspondentes.
3. As tarefas são adicionadas a uma lista e submetidas a um `ExecutorService` com pool de threads cacheado.
4. O método `invokeAny` retorna o resultado da primeira tarefa que concluir com sucesso.
5. O resultado é exibido e o executor é encerrado.

## 4. Exemplo de Execução
**Saída do Console:**
```text
Validador DataBase: Validando usuário durante 2 segundos
Validador LDAP: Validando usuário durante 5 segundos
Validador DataBase: O usuário foi encontrado
Principal: Resultado: DataBase
Validador LDAP: O usuário não foi encontrado
Principal: Fim da Execução
```

## 5. Conclusão
O exemplo evidencia como o uso do método `invokeAny` permite obter o primeiro resultado bem-sucedido entre várias tarefas concorrentes, otimizando o tempo de resposta em cenários onde múltiplas fontes de validação estão disponíveis. Essa técnica é fundamental para aplicações que necessitam de respostas rápidas e resilientes, utilizando a concorrência para melhorar a performance e a disponibilidade dos serviços.
