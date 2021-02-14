import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

public class GUI extends Application {

    Board board = MainClass.getBoard();
    Button drawCardsButton = new Button();
    Button drawTicketsButton = new Button();
    Button buildTracksButton = new Button();
    int turn = 0;

    @Override
    public void start(Stage stage) {

        ImageView boardImageView = buildBoardImageView();

        VBox cardPileContainer = buildCardPileContainer();

        VBox scoreBoardAndOpenCardContainer = scoreBoardAndOpenCardContainer();

        FlowPane playerActionsAreaContainer = buildPlayerAreaContainer();

        FlowPane playerActionsContainer = buildPlayerActionsContainer();

        AnchorPane mainPane = new AnchorPane(boardImageView, cardPileContainer, scoreBoardAndOpenCardContainer, playerActionsAreaContainer, playerActionsContainer);
        mainPane.setPrefHeight(400);
        mainPane.setPrefWidth(600);

        Scene scene = new Scene(mainPane);
        stage.setTitle("Ticket To Ride");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void drawTicketsForPlayer() {
        drawCardsButton.setText("player 1 button clicked");
    }

    private ImageView buildBoardImageView() {
        ImageView boardImageView = new ImageView("resources/Board.png");
        boardImageView.setFitHeight(1011);
        boardImageView.setFitWidth(1348);
        boardImageView.setPickOnBounds(true);
        boardImageView.setPreserveRatio(true);
        return boardImageView;
    }

    private VBox buildCardPileContainer() {

        ImageView imageView6 = new ImageView("resources/CardBack.jpg");
        imageView6.setFitHeight(400);
        imageView6.setFitHeight(300);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        Label spaceLabel = new Label();
        spaceLabel.setFont(Font.font(10));
        ImageView imageView7 = new ImageView("resources/TicketBack.jpg");
        imageView7.setFitHeight(400);
        imageView7.setFitHeight(300);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        VBox cardPileContainer = new VBox(imageView6, spaceLabel, imageView7);
        cardPileContainer.setLayoutX(1600);
        cardPileContainer.setLayoutY(250);
        cardPileContainer.setPrefWidth(70);

        return cardPileContainer;
    }

    private VBox scoreBoardAndOpenCardContainer() {
        ArrayList<Label> scoreboardList = new ArrayList<>();
        for (int i = 0; i < board.playerList.size(); i++) {
            Label label = new Label(board.playerList.get(i).name + ": " + board.playerList.get(i).score);
            label.setFont(Font.font(50));
            scoreboardList.add(label);
        }
        ArrayList<ImageView> imageViewList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (board.fiveOpenCards.get(i).cardColor == CardColor.red) {
                ImageView imageView1 = new ImageView("resources/RedCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.orange) {
                ImageView imageView1 = new ImageView("resources/OrangeCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.yellow) {
                ImageView imageView1 = new ImageView("resources/YellowCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.green) {
                ImageView imageView1 = new ImageView("resources/GreenCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.blue) {
                ImageView imageView1 = new ImageView("resources/BlueCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.pink) {
                ImageView imageView1 = new ImageView("resources/PinkCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.black) {
                ImageView imageView1 = new ImageView("resources/BlackCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.white) {
                ImageView imageView1 = new ImageView("resources/WhiteCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            } else {
                ImageView imageView1 = new ImageView("resources/LocoCard.jpg");
                imageView1.setFitHeight(147);
                imageView1.setFitWidth(196);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageViewList.add(imageView1);
            }
        }
        VBox scoreBoardAndOpenCardContainer;
        if (scoreboardList.size() == 2) {
            VBox vbox1 = new VBox(scoreboardList.get(0), scoreboardList.get(1), imageViewList.get(0), imageViewList.get(1), imageViewList.get(2), imageViewList.get(3), imageViewList.get(4));
            scoreBoardAndOpenCardContainer = vbox1;
        } else if (scoreboardList.size() == 3) {
            VBox vbox1 = new VBox(scoreboardList.get(0), scoreboardList.get(1), scoreboardList.get(2), imageViewList.get(0), imageViewList.get(1), imageViewList.get(2), imageViewList.get(3), imageViewList.get(4));
            scoreBoardAndOpenCardContainer = vbox1;
        } else if (scoreboardList.size() == 4) {
            VBox vbox1 = new VBox(scoreboardList.get(0), scoreboardList.get(1), scoreboardList.get(2), scoreboardList.get(3), imageViewList.get(0), imageViewList.get(1), imageViewList.get(2), imageViewList.get(3), imageViewList.get(4));
            scoreBoardAndOpenCardContainer = vbox1;
        } else {
            VBox vbox1 = new VBox(scoreboardList.get(0), scoreboardList.get(1), scoreboardList.get(2), scoreboardList.get(3), scoreboardList.get(4), imageViewList.get(0), imageViewList.get(1), imageViewList.get(2), imageViewList.get(3), imageViewList.get(4));
            scoreBoardAndOpenCardContainer = vbox1;
        }
        scoreBoardAndOpenCardContainer.setLayoutX(1380);
        scoreBoardAndOpenCardContainer.setPrefHeight(310);
        return scoreBoardAndOpenCardContainer;
    }

    private FlowPane buildPlayerActionsContainer() {
        Label label1 = new Label("Player " + board.playerList.get(turn).name);
        label1.setPrefWidth(1850);
        label1.setAlignment(Pos.CENTER);
        label1.setFont(Font.font(50));
        if (board.playerList.get(turn).playerColor == PlayerColor.black) {
            label1.setTextFill(Color.WHITE);
        } else {
            label1.setTextFill(Color.BLACK);
        }
        Label spacerLabel1 = new Label();
        spacerLabel1.setPrefWidth(1850);
        spacerLabel1.setPrefHeight(50);
        drawCardsButton.setText("Draw Cards");
        drawCardsButton.setFont(Font.font(45));
        drawCardsButton.setOnAction(event -> drawTicketsForPlayer());
        Label spacerLabel2 = new Label();
        spacerLabel2.setPrefWidth(20);
        Label spacerLabel3 = new Label();
        spacerLabel3.setPrefWidth(20);
        drawTicketsButton.setText("Draw Tickets");
        drawTicketsButton.setFont(Font.font(45));
        buildTracksButton.setText("Build Tracks");
        buildTracksButton.setFont(Font.font(45));
        List<ImageView> playerCardsImages = new ArrayList<>();
        for (int i = 0; i < board.playerList.get(turn).cards.size(); i++) {
            if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.red) {
                ImageView imageView1 = new ImageView("resources/RedCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.orange) {
                ImageView imageView1 = new ImageView("resources/OrangeCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.yellow) {
                ImageView imageView1 = new ImageView("resources/YellowCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.green) {
                ImageView imageView1 = new ImageView("resources/GreenCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.blue) {
                ImageView imageView1 = new ImageView("resources/BlueCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.pink) {
                ImageView imageView1 = new ImageView("resources/PinkCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.black) {
                ImageView imageView1 = new ImageView("resources/BlackCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.white) {
                ImageView imageView1 = new ImageView("resources/WhiteCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else {
                ImageView imageView1 = new ImageView("resources/LocoCard.jpg");
                imageView1.setFitHeight(75);
                imageView1.setFitWidth(100);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            }
        }
        List<Label> ticketLabelList = new ArrayList<>();
        for (int i = 0; i < board.playerList.get(turn).tickets.size(); i++) {
            Label ticketLabel = new Label();
            ticketLabel.setText(board.playerList.get(turn).tickets.get(i).source + " -> " + board.playerList.get(turn).tickets.get(i).destination + ", " + board.playerList.get(turn).tickets.get(i).value);
            ticketLabel.setFont(Font.font(35));
            ticketLabel.setStyle("-fx-background-color: white;");
            ticketLabelList.add(ticketLabel);
        }
        FlowPane flowPane2 = new FlowPane(label1, spacerLabel1, drawCardsButton, spacerLabel2, drawTicketsButton, spacerLabel3, buildTracksButton);
        flowPane2.setLayoutY(870);
        flowPane2.setPrefHeight(287.5);
        flowPane2.setPrefWidth(1850);
        for (int i = 0; i < playerCardsImages.size(); i++) {
            flowPane2.getChildren().add(playerCardsImages.get(i));
        }
        for (int i = 0; i < ticketLabelList.size(); i++) {
            flowPane2.getChildren().add(ticketLabelList.get(i));
        }
        return flowPane2;
    }

    private FlowPane buildPlayerAreaContainer() {
        Rectangle rectangle1 = new Rectangle();
        if (board.playerList.get(turn).playerColor == PlayerColor.black) {
            rectangle1.setFill(Color.BLACK);
        } else if (board.playerList.get(turn).playerColor == PlayerColor.blue) {
            rectangle1.setFill(Color.BLUE);
        } else if (board.playerList.get(turn).playerColor == PlayerColor.red) {
            rectangle1.setFill(Color.RED);
        } else if (board.playerList.get(turn).playerColor == PlayerColor.green) {
            rectangle1.setFill(Color.GREEN);
        } else {
            rectangle1.setFill(Color.YELLOW);
        }
        rectangle1.setHeight(287.5);
        rectangle1.setWidth(1850);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setStrokeType(StrokeType.INSIDE);
        FlowPane flowPane1 = new FlowPane(rectangle1);
        flowPane1.setLayoutY(870);
        flowPane1.setPrefHeight(100);
        flowPane1.setPrefWidth(600);

        return flowPane1;
    }
}
