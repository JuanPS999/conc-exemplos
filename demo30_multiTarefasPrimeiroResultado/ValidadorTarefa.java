import java.util.concurrent.Callable;

// ValidadorTarefa - Responsável por validar um usuário utilizando um validador específico
public class ValidadorTarefa implements Callable<String> {
    private ValidadorUsuario validador;
    private String usuario;
    private String senha;

    // Construtor que inicializa o validador, o usuário e a senha
    public ValidadorTarefa(ValidadorUsuario validador, String usuario, String senha) {
        this.validador = validador;
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public String call() throws Exception {
        // Se a validação falhar, imprime mensagem e lança exceção
        if (!validador.validate(usuario, senha)) {
            System.out.printf("%s: O usuário não foi encontrado\n", validador.getName());
            throw new Exception("Erro ao validar o usuário");
        }
        // Se a validação for bem-sucedida, imprime mensagem e retorna o nome do
        // validador
        System.out.printf("%s: O usuário foi encontrado\n", validador.getName());
        return validador.getName();
    }
}
