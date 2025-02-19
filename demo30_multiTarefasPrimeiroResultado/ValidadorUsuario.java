import java.util.Random;
import java.util.concurrent.TimeUnit;

// ValidadorUsuario - Simula a validação de um usuário com um atraso e retorno aleatório
public class ValidadorUsuario {
    private String nome;

    // Construtor que inicializa o validador com um nome
    public ValidadorUsuario(String nome) {
        this.nome = nome;
    }

    // Método que valida o usuário e a senha, simulando um processamento com atraso
    public boolean validate(String usuario, String senha) {
        Random random = new Random();
        try {
            Long duracao = (long) (Math.random() * 10);
            System.out.printf("Validador %s: Validando usuário durante %d segundos\n", this.nome, duracao);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            return false;
        }
        // Retorna um valor booleano aleatório para simular sucesso ou falha na
        // validação
        return random.nextBoolean();
    }

    // Retorna o nome do validador
    public String getName() {
        return nome;
    }
}
