import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Principal - Inicializa os validadores e submete as tarefas para validação do usuário
public class Principal {
    public static void main(String[] args) {
        String usuario = "teste";
        String senha = "teste";

        // Cria instâncias de ValidadorUsuario para LDAP e Banco de Dados
        ValidadorUsuario ldapValidador = new ValidadorUsuario("LDAP");
        ValidadorUsuario dbValidador = new ValidadorUsuario("DataBase");

        // Cria tarefas de validação utilizando os validadores
        ValidadorTarefa ldapTarefa = new ValidadorTarefa(ldapValidador, usuario, senha);
        ValidadorTarefa dbTarefa = new ValidadorTarefa(dbValidador, usuario, senha);

        // Adiciona as tarefas em uma lista
        List<ValidadorTarefa> listaTarefas = new ArrayList<>();
        listaTarefas.add(ldapTarefa);
        listaTarefas.add(dbTarefa);

        // Cria um ExecutorService para executar as tarefas
        ExecutorService executor = Executors.newCachedThreadPool();
        String resultado;
        try {
            // Invoca qualquer tarefa que retorne um resultado primeiro
            resultado = executor.invokeAny(listaTarefas);
            System.out.printf("Principal: Resultado: %s\n", resultado);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.printf("Principal: Fim da Execução\n");
    }
}
