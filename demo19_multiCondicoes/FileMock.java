// FileMock - Simula um arquivo com múltiplas linhas de conteúdo aleatório
public class FileMock {
    private String[] content; // Array de linhas
    private int index;        // Índice para rastrear a linha atual

    // Construtor: Cria um arquivo simulado com um número definido de linhas e comprimento de cada linha
    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                // Gera um caractere aleatório
                int indice = (int) (Math.random() * 255);
                buffer.append((char) indice);
            }
            content[i] = buffer.toString();
        }
        index = 0;
    }

    // Verifica se ainda há linhas no arquivo simulado
    public boolean hasMoreLines() {
        return index < content.length;
    }

    // Retorna a próxima linha do arquivo simulado e atualiza o índice
    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mock: " + (content.length - index));
            return content[index++];
        }
        return null;
    }
}
