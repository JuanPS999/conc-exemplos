// Produtor - Implementa Runnable para ler linhas de um FileMock e inseri-las no Buffer
public class Produtor implements Runnable {
    private FileMock mock; // Objeto que simula o arquivo
    private Buffer buffer; // Buffer compartilhado para inserção das linhas

    // Construtor que inicializa com o FileMock e o Buffer fornecidos
    public Produtor(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // Indica que há linhas pendentes
        buffer.setPendingLines(true);
        // Enquanto houver linhas no FileMock, insere-as no Buffer
        while (mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }
        // Após inserir todas as linhas, sinaliza que não há mais linhas pendentes
        buffer.setPendingLines(false);
    }
}
