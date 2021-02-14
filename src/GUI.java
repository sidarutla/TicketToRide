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

public class GUI extends Application {

    Board board = MainClass.getBoard();
    Button drawCards;

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
        drawCards.setText("player 1 button clicked");
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
        Label label1 = new Label("Player 1");
        label1.setFont(Font.font(30));
        label1.setPrefWidth(1850);
        label1.setAlignment(Pos.CENTER);
        Button drawCards = new Button();
        drawCards.setText("Draw Cards for player 1");
        drawCards.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                drawTicketsForPlayer();
            }
        });
        FlowPane flowPane2 = new FlowPane(label1, drawCards);
        flowPane2.setLayoutY(870);
        flowPane2.setPrefHeight(100);
        flowPane2.setPrefWidth(600);

        return flowPane2;
    }

    private FlowPane buildPlayerAreaContainer() {
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setFill(Color.RED);
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
