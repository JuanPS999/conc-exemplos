public class Principal {
  public static void main(String[] args) {
    int numCadeiras = 5;
    Barbearia barbearia = new Barbearia(numCadeiras);
    Barbeiro barbeiro = new Barbeiro(barbearia);
    barbeiro.start();
    for (int i = 1; i <= 30; i++) {
      new Cliente(barbearia, i).start();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
