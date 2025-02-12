class Barbeiro extends Thread {
  private final Barbearia barbearia;

  public Barbeiro(Barbearia barbearia) {
    this.barbearia = barbearia;
  }

  public void run() {
    try {
      barbearia.atenderClientes();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
