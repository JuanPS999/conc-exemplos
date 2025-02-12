import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CarregadorConexoes implements Runnable {

	@Override
	public void run() {
		System.out.printf("Carregador de conexoes carregando: %s\n", new Date());
		try {
			// 
//			TimeUnit.SECONDS.sleep(6);
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Carregamento de conexoes terminou: %s\n", new Date());
	}
}
