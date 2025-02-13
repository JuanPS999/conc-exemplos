import java.util.concurrent.Phaser;

// MeuPhaser - Customiza o comportamento do Phaser para coordenar as fases do exame
public class MeuPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int fase, int totalRegistrados) {
        switch (fase) {
            case 0:
                return alunosChegaram();
            case 1:
                return terminouExercicio1();
            case 2:
                return terminouExercicio2();
            case 3:
                return terminouExame();
            default:
                return true;
        }
    }

    // Verifica se todos os alunos chegaram e informa o início do exame
    private boolean alunosChegaram() {
        System.out.printf("Phaser: O exame vai começar. Todos os alunos estão prontos.\n");
        System.out.printf("Phaser: Temos %d alunos.\n", getRegisteredParties());
        return false;
    }

    // Indica que todos os alunos terminaram o primeiro exercício e que é hora do segundo
    private boolean terminouExercicio1() {
        System.out.printf("Phaser: Todos os alunos terminaram o primeiro exercício.\n");
        System.out.printf("Phaser: É hora do segundo exercício.\n");
        return false;
    }

    // Indica que todos os alunos terminaram o segundo exercício e que é hora do terceiro
    private boolean terminouExercicio2() {
        System.out.printf("Phaser: Todos os alunos terminaram o segundo exercício.\n");
        System.out.printf("Phaser: É hora do terceiro exercício.\n");
        return false;
    }

    // Indica que todos os alunos finalizaram o exame e encerra o Phaser
    private boolean terminouExame() {
        System.out.printf("Phaser: Todos os alunos finalizaram o exame.\n");
        System.out.printf("Phaser: Obrigado pelo tempo de vocês.\n");
        return true;
    }
}
