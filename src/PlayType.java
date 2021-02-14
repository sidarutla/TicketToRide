public enum PlayType {

    drawCards(1), buildTracks(2), drawTickets(3);

    private int index;

    PlayType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


    public static PlayType getPlayType(int index) {
        for (PlayType value : values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
