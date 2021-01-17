public class Connection {

    String source;
    String destination;
     Pathway pathway1;
     Pathway pathway2;

    public Connection(String source, String destination, Pathway pathway1, Pathway pathway2) {
        this.source = source;
        this.destination = destination;
        this.pathway1 = pathway1;
        this.pathway2 = pathway2;
    }

    public static Connection buildConnection(String source, String destination, boolean doubleTracks, int tracks, TrackColor color1, TrackColor color2) {
        Pathway pathway1 = new Pathway(tracks, color1, true, null);
        Pathway pathway2 = new Pathway(tracks, color2, true, null);

        Connection connection = new Connection(source, destination, pathway1, doubleTracks? pathway2 : null);
        return connection;
    }
    public String toString() {
        String string = source + ", " + destination + ", " + pathway1;
        if (pathway2 != null){
            string += ", " + pathway2;
        }
        return string;
        }
    }


