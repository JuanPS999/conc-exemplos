import java.util.Date;

public class Principal {

	public static void main(String[] args) {
		CarregadorConexoes dsLoader = new CarregadorConexoes();
		Thread thread1 = new Thread(dsLoader, "CarregadorConexoes");
		thread1.start();

	  FontesDeDados ncLoader = new FontesDeDados();
		Thread thread2 = new Thread(ncLoader, "CarregadorDados");
		thread2.start();

		try {
			thread1.join();
			System.out.println("==========================================");
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Principal: Configuracao carregada: %s\n", new Date());
	}
}
