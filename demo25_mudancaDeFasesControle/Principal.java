// Principal - Classe que inicializa o exame, registra os alunos e inicia as threads
public class Principal {
    public static void main(String[] args) {
        MeuPhaser phaser = new MeuPhaser();

        // Cria um array de 5 alunos e registra cada um no phaser
        Aluno[] alunos = new Aluno[5];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno(phaser);
            phaser.register();
        }

        // Cria e inicia uma thread para cada aluno
        Thread[] threads = new Thread[alunos.length];
        for (int i = 0; i < alunos.length; i++) {
            threads[i] = new Thread(alunos[i], "Aluno " + i);
            threads[i].start();
        }

        // Aguarda a finalização de todas as threads
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Principal: O phaser terminou: %s.\n", phaser.isTerminated());
    }
}
