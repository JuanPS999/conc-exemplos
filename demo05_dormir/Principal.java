//Exemplo 5: Dormindo e Retomando uma Thread package concorrente.dormir;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Principal {
	public static void main(String[] args) {
		Relogio relogio = new Relogio();
    Thread thread = new Thread(relogio);
		
		thread.start();
		
		try { TimeUnit.SECONDS.sleep(5); }
    catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
		}
}
