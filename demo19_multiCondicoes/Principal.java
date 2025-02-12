public class Principal {
	public static void main(String[] args) {
		FileMock mock = new FileMock(101, 10);

		Buffer buffer = new Buffer(20);

		Produtor producer = new Produtor(mock, buffer);
		Thread threadProdutor = new Thread(producer, "Produtor");

		Consumidor consumers[] = new Consumidor[3];
		Thread threadConsumidores[] = new Thread[3];

		for (int i = 0; i < 3; i++) {
			consumers[i] = new Consumidor(buffer);
			threadConsumidores[i] = new Thread(consumers[i], "Consumidor " + i);
		}

		threadProdutor.start();
		for (int i = 0; i < 3; i++) {
			threadConsumidores[i].start();
		}
	}
}
