import java.util.concurrent.TimeUnit; // Importa TimeUnit para controle de tempo

// Classe Principal: Orquestra a execução das tarefas utilizando um grupo de threads
public class Principal {
    public static void main(String[] args) {
        // Cria um grupo de threads denominado "Pesquisador"
        ThreadGroup grupoDeThreads = new ThreadGroup("Pesquisador");
        // Cria um objeto Resultado para compartilhar entre as threads
        Resultado resultado = new Resultado();

        // Cria a tarefa de pesquisa a ser executada pelas threads
        ProcurarTarefas tarefaDePesquisa = new ProcurarTarefas(resultado);
        // Inicia 5 threads para executar a tarefa
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(grupoDeThreads, tarefaDePesquisa);
            thread.start();
            try {
                // Aguarda 1 segundo entre a criação de cada thread
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Exibe o número de threads ativas no grupo
        System.out.printf("Número de Threads: %d\n", grupoDeThreads.activeCount());
        System.out.printf("Informações sobre o Grupo de Threads\n");
        // Lista informações do grupo de threads
        grupoDeThreads.list();

        // Cria um array para armazenar as threads ativas
        Thread[] threads = new Thread[grupoDeThreads.activeCount()];
        // Preenche o array com as threads ativas do grupo
        grupoDeThreads.enumerate(threads);
        // Exibe o nome e o estado de cada thread ativa
        for (int i = 0; i < grupoDeThreads.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        // Aguarda a finalização das threads conforme critério definido
        esperarFinalizacao(grupoDeThreads);
        // Interrompe todas as threads do grupo
        grupoDeThreads.interrupt();
    }

    // Método para aguardar até que o grupo de threads tenha um número reduzido de
    // threads ativas
    private static void esperarFinalizacao(ThreadGroup grupoDeThreads) {
        while (grupoDeThreads.activeCount() > 4) {
            try {
                // Aguarda 1 segundo antes de verificar novamente
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

