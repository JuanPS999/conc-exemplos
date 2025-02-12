import java.util.ArrayList; // Importação para manipulação de listas
import java.util.Date; // Importação para manipulação de data e hora
import java.util.Iterator; // Importação para iteração sobre listas
import java.util.List; // Importação para listas genéricas
import java.util.concurrent.ThreadFactory; // Importação para criação de fábricas de threads

// Classe que implementa ThreadFactory para customizar a criação de threads
public class FabricaThreads implements ThreadFactory {
    private int contador; // Contador para nomear as threads
    private String nome; // Nome base das threads
    private List<String> estatisticas; // Lista para armazenar estatísticas sobre as threads criadas

    // Construtor que recebe o nome base das threads
    public FabricaThreads(String nome) {
        contador = 0;
        this.nome = nome;
        estatisticas = new ArrayList<String>(); // Inicializa a lista de estatísticas
    }

    @Override
    // Método que cria novas threads com um nome único e armazena suas estatísticas
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, nome + "-Thread_" + contador); // Cria uma nova thread com nome único
        contador++; // Incrementa o contador para a próxima thread

        // Adiciona as estatísticas da thread criada
        estatisticas
                .add(String.format("Thread %d criada com o nome %s em %s\n", t.threadId(), t.getName(), new Date()));
        return t;
    }

    // Método que retorna as estatísticas das threads criadas
    public String getEstatisticas() {
        StringBuffer buffer = new StringBuffer(); // Buffer para armazenar as estatísticas
        Iterator<String> it = estatisticas.iterator(); // Iterador para percorrer a lista de estatísticas

        // Adiciona cada estatística ao buffer
        while (it.hasNext()) {
            buffer.append(it.next());
        }

        return buffer.toString(); // Retorna as estatísticas como uma string
    }
}
