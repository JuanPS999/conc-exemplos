import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class FabricaThreads implements ThreadFactory {

    private int contador;
    private String nome;
    private List<String> estatisticas;

    public FabricaThreads(String nome) {
        contador = 0;
        this.nome = nome;
        estatisticas = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, nome + "-Thread_" + contador);
        contador++;

        estatisticas
                .add(String.format("Thread %d criada com o nome %s em %s\n", t.threadId(), t.getName(), new Date()));
        return t;
    }

    public String getEstatisticas() {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = estatisticas.iterator();

        while (it.hasNext()) {
            buffer.append(it.next());
        }

        return buffer.toString();
    }
}
