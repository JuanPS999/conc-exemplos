import java.util.Date;

/**
 * Classe que representa um evento armazenado na fila.
 */
public class Evento {
    private Date data;
    private String evento;

    public Date getData() {
        return data;
    }

    public void setData(Date date) {
        this.data = date;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String event) {
        this.evento = event;
    }
}
