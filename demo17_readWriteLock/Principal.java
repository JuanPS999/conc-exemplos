public class Principal {
	public static void main(String[] args) {
		InfoPrecos infoPrecos = new InfoPrecos();

		Leitor leitores[] = new Leitor[5];
		Thread threadsLeitor[] = new Thread[5];

		for (int i = 0; i < 5; i++) {
			leitores[i] = new Leitor(infoPrecos);
			threadsLeitor[i] = new Thread(leitores[i]);
		}

		Escritor escritor = new Escritor(infoPrecos);
		Thread threadEscritor = new Thread(escritor);

		for (int i = 0; i < 5; i++) {
			threadsLeitor[i].start();
		}
		threadEscritor.start();
	}
}
