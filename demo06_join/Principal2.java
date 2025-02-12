import java.util.Date;

public class Principal2 {

	public static void main(String[] args) {
		FontesDeDados dsLoader = new FontesDeDados();
		Thread thread1 = new Thread(dsLoader, "FontesDedados");
		thread1.start();

		//
		CarregadorConexoes ncLoader = new CarregadorConexoes();
		Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");
		thread2.start();

		try {
			thread1.join(1000);
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Principal: Configuracao carregada: %s\n", new Date());
	}
}
