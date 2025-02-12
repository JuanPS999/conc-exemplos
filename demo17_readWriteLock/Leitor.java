public class Leitor implements Runnable {

	private InfoPrecos infoPrecos;

	public Leitor(InfoPrecos infoPrecos) {
		this.infoPrecos = infoPrecos;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), infoPrecos.getPreco1());
			System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), infoPrecos.getPreco2());
		}
	}
}
