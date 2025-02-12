import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FontesDeDados implements Runnable {

	@Override
	public void run() {
		
		System.out.printf("Fontes de dados carregando: %s\n",new Date());
		try {
			//
//			TimeUnit.SECONDS.sleep(4);
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Carregamento de fontes de dados terminou: %s\n",new Date());
	}
}
