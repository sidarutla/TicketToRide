public class Card {

    CardColor cardColor;

    public Card(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    public String toString() {
        String string = cardColor + "";
        return string;
    }

    public boolean isLocomotive() {
        return cardColor == CardColor.locomotive;
    }

    public boolean isColorMatching(Pathway pathway) {
        if (pathway != null) {
            if (pathway.color == TrackColor.grey) {
                return true;
            } else if (pathway.color == TrackColor.black && cardColor == CardColor.black) {
                return true;
            } else if (pathway.color == TrackColor.blue && cardColor == CardColor.blue) {
                return true;
            } else if (pathway.color == TrackColor.green && cardColor == CardColor.green) {
                return true;
            } else if (pathway.color == TrackColor.orange && cardColor == CardColor.orange) {
                return true;
            } else if (pathway.color == TrackColor.pink && cardColor == CardColor.pink) {
                return true;
            } else if (pathway.color == TrackColor.red && cardColor == CardColor.red) {
                return true;
            } else if (pathway.color == TrackColor.white && cardColor == CardColor.white) {
                return true;
            } else if (pathway.color == TrackColor.yellow && cardColor == CardColor.yellow) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
