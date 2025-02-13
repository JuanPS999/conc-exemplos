// Principal - Inicializa o Servidor e envia 100 tarefas para execução
public class Principal {
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        for (int i = 0; i < 100; i++) {
            Tarefa tarefa = new Tarefa("Tarefa " + i);
            servidor.executarTarefa(tarefa);
        }
        servidor.encerrarServidor();
    }
}
