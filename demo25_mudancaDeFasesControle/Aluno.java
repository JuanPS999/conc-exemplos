import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

// Aluno - Representa um estudante que realiza o exame dividido em fases
public class Aluno implements Runnable {
    private Phaser phaser; // Phaser para sincronizar as fases do exame

    // Construtor que inicializa o aluno com o Phaser
    public Aluno(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s: Chegou para fazer o exame. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Vai fazer o primeiro exercício. %s\n", Thread.currentThread().getName(), new Date());
        fazerExercicio1();
        System.out.printf("%s: Terminou o primeiro exercício. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Vai fazer o segundo exercício. %s\n", Thread.currentThread().getName(), new Date());
        fazerExercicio2();
        System.out.printf("%s: Terminou o segundo exercício. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Vai fazer o terceiro exercício. %s\n", Thread.currentThread().getName(), new Date());
        fazerExercicio3();
        System.out.printf("%s: Finalizou o exame. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    // Simula a realização do primeiro exercício
    private void fazerExercicio1() {
        try {
            long duracao = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Simula a realização do segundo exercício
    private void fazerExercicio2() {
        try {
            long duracao = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Simula a realização do terceiro exercício
    private void fazerExercicio3() {
        try {
            long duracao = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duracao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
