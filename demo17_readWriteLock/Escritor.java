class Escritor implements Runnable {
	private InfoPrecos infoPrecos;

	public Escritor(InfoPrecos infoPrecos) {
		this.infoPrecos = infoPrecos;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.printf("Writer: Attempt to modify the prices.\n");
			infoPrecos.setPrices(Math.random() * 10, Math.random() * 8);
			System.out.printf("Writer: Prices have been modified.\n");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
