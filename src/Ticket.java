public class Ticket {

    private String source;
    private String destination;
    private int value;

    public Ticket(String source, String destination, int value) {
        this.source = source;
        this.destination = destination;
        this.value = value;
    }

    public static Ticket buildTicket(String source, String destination, int value) {
        Ticket ticket = new Ticket(source, destination, value);
        return ticket;
    }
    public String toString(){
        String string = source + ", " + destination + ", " + value;
        return string;
    }
}
