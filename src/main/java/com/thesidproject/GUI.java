package com.thesidproject;

import com.thesidproject.Board;
import com.thesidproject.CardColor;
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
    FlowPane playerAreaContainer = new FlowPane();
    int turn = 0;

    @Override
    public void start(Stage stage) {

        ImageView boardImageView = buildBoardImageView();

        VBox cardPileContainer = buildCardPileContainer();

        VBox scoreBoardAndOpenCardContainer = buildScoreBoardAndOpenCardContainer();

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

    private FlowPane buildPlayerActionsContainer() {

        Label spacerLabel1 = new Label();
        spacerLabel1.setPrefWidth(1850);
        spacerLabel1.setPrefHeight(90);
        Label spacerLabel2 = new Label();
        spacerLabel2.setPrefWidth(20);
        Label spacerLabel3 = new Label();
        spacerLabel3.setPrefWidth(20);
        Label spacerLabel4 = new Label();
        spacerLabel4.setPrefWidth(20);
        drawTicketsButton.setText("Draw Tickets");
        drawTicketsButton.setFont(Font.font(45));
        buildTracksButton.setText("Build Tracks");
        buildTracksButton.setFont(Font.font(45));
        drawCardsButton.setText("Draw Cards");
        drawCardsButton.setFont(Font.font(45));
        FlowPane cardContainer = new FlowPane();
        VBox ticketContainer1 = new VBox();
        VBox ticketContainer2 = new VBox();
        List<ImageView> playerCardsImages = new ArrayList<>();
        for (int i = 0; i < board.playerList.get(turn).cards.size(); i++) {
            if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.red) {
                ImageView imageView1 = new ImageView("RedCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.orange) {
                ImageView imageView1 = new ImageView("OrangeCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.yellow) {
                ImageView imageView1 = new ImageView("YellowCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.green) {
                ImageView imageView1 = new ImageView("GreenCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.blue) {
                ImageView imageView1 = new ImageView("BlueCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.pink) {
                ImageView imageView1 = new ImageView("PinkCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.black) {
                ImageView imageView1 = new ImageView("BlackCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.white) {
                ImageView imageView1 = new ImageView("WhiteCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else {
                ImageView imageView1 = new ImageView("LocoCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
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
            ticketLabel.setStyle("-fx-background-color: white;");
            ticketLabelList.add(ticketLabel);
        }
        Label ticketHeading = new Label();
        ticketHeading.setText("Tickets:");
        ticketHeading.setStyle("-fx-background-color: white;");
        ticketContainer1.getChildren().add(ticketHeading);
        if (ticketLabelList.size() < 6) {
            for (Label label : ticketLabelList) {
                label.setFont(Font.font(30));
            }
            for (Label label : ticketLabelList) {
                ticketContainer1.getChildren().add(label);
            }
            ticketHeading.setFont(Font.font(30));
        }

        FlowPane playerActionsContainer = new FlowPane(spacerLabel1, drawCardsButton, spacerLabel2, drawTicketsButton, spacerLabel3, buildTracksButton);
        playerActionsContainer.setLayoutY(870);
        playerActionsContainer.setPrefHeight(287.5);
        playerActionsContainer.setPrefWidth(1850);
        for (ImageView playerCardsImage : playerCardsImages) {
            cardContainer.getChildren().add(playerCardsImage);
        }

        playerActionsContainer.getChildren().add(cardContainer);
        playerActionsContainer.getChildren().add(ticketContainer1);
        playerActionsContainer.getChildren().add(spacerLabel4);
        playerActionsContainer.getChildren().add(ticketContainer2);
        drawCardsButton.setOnAction(event -> drawCards(playerActionsContainer));
        drawTicketsButton.setOnAction(event -> drawTickets(playerActionsContainer));
        return playerActionsContainer;
    }

    private FlowPane buildPlayerAreaContainer() {
        Label playerName = new Label(board.playerList.get(turn).name);
        playerName.setPrefWidth(1850);
        playerName.setAlignment(Pos.CENTER);
        playerName.setFont(Font.font(50));
        if (board.playerList.get(turn).playerColor == PlayerColor.black) {
            playerName.setTextFill(Color.WHITE);
        } else {
            playerName.setTextFill(Color.BLACK);
        }

        Rectangle playerArea = new Rectangle();
        if (board.playerList.get(turn).playerColor == PlayerColor.black) {
            playerArea.setFill(Color.BLACK);
            playerName.setStyle("-fx-background-color: black;");
        } else if (board.playerList.get(turn).playerColor == PlayerColor.blue) {
            playerArea.setFill(Color.BLUE);
            playerName.setStyle("-fx-background-color: blue;");
        } else if (board.playerList.get(turn).playerColor == PlayerColor.red) {
            playerArea.setFill(Color.RED);
            playerName.setStyle("-fx-background-color: red;");
        } else if (board.playerList.get(turn).playerColor == PlayerColor.green) {
            playerArea.setFill(Color.GREEN);
            playerName.setStyle("-fx-background-color: green;");
        } else {
            playerArea.setFill(Color.YELLOW);
            playerName.setStyle("-fx-background-color: yellow;");
        }
        playerArea.setHeight(287.5);
        playerArea.setWidth(1850);
        playerArea.setStroke(Color.BLACK);
        playerArea.setStrokeType(StrokeType.INSIDE);
        playerAreaContainer.getChildren().add(playerName);
        playerAreaContainer.getChildren().add(playerArea);
        playerAreaContainer.setLayoutY(870);
        playerAreaContainer.setPrefHeight(100);
        playerAreaContainer.setPrefWidth(600);

        return playerAreaContainer;
    }

    private ImageView buildBoardImageView() {
        ImageView boardImageView = new ImageView("Board.png");
        boardImageView.setFitHeight(1011);
        boardImageView.setFitWidth(1348);
        boardImageView.setPickOnBounds(true);
        boardImageView.setPreserveRatio(true);
        return boardImageView;
    }

    private VBox buildCardPileContainer() {

        ImageView imageView6 = new ImageView("CardBack.jpg");
        imageView6.setFitHeight(400);
        imageView6.setFitHeight(300);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        Label spaceLabel = new Label();
        spaceLabel.setFont(Font.font(10));
        ImageView imageView7 = new ImageView("TicketBack.jpg");
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

    boolean drawCardsClicked = false;
    int normalCardsDrawn = 0;
    int locosDrawn = 0;

    public void setOpenCardAction(Button openCard, int position, VBox openCardContainer) {
        openCard.setOnAction(event -> addCard(position, openCardContainer));
    }
    public void addCard(int position, VBox openCardContainer) {
        if (drawCardsClicked && normalCardsDrawn < 2 && locosDrawn < 1 && (normalCardsDrawn != 1 || board.fiveOpenCards.get(position).cardColor != CardColor.locomotive)) {
            board.playerList.get(turn).cards.add(board.fiveOpenCards.get(position));
            if (board.fiveOpenCards.get(position).cardColor == CardColor.locomotive) {
                locosDrawn += 1;
            }
            else {
                normalCardsDrawn +=1;
            }
            board.fiveOpenCards.remove(position);
            board.fiveOpenCards.add(board.cardList.get(0));
            board.cardList.remove(0);
        }
    }

    private VBox buildScoreBoardAndOpenCardContainer() {
        VBox scoreBoardAndOpenCardContainer = new VBox();
        int position = 0;
        ArrayList<Label> scoreboardList = new ArrayList<>();
        for (int i = 0; i < board.playerList.size(); i++) {
            Label label = new Label(board.playerList.get(i).name + ": " + board.playerList.get(i).score);
            label.setFont(Font.font(50));
            scoreboardList.add(label);
        }
        ArrayList<Button> openCardList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (board.fiveOpenCards.get(i).cardColor == CardColor.red) {
                Button openCard = new Button("RedCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
                setOpenCardAction(openCard, i, scoreBoardAndOpenCardContainer);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.orange) {
                Button openCard = new Button("OrangeCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.yellow) {
                Button openCard = new Button("YellowCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.green) {
                Button openCard = new Button("GreenCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.blue) {
                Button openCard = new Button("BlueCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.pink) {
                Button openCard = new Button("PinkCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.black) {
                Button openCard = new Button("BlackCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            } else if (board.fiveOpenCards.get(i).cardColor == CardColor.white) {
                Button openCard = new Button("WhiteCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            } else {
                Button openCard = new Button("LocoCard.jpg");
                openCard.setPrefHeight(147);
                openCard.setPrefWidth(196);
                openCard.setPickOnBounds(true);
                openCardList.add(openCard);
            }
        }
        if (scoreboardList.size() == 2) {
            scoreBoardAndOpenCardContainer = new VBox(scoreboardList.get(0), scoreboardList.get(1), openCardList.get(0), openCardList.get(1), openCardList.get(2), openCardList.get(3), openCardList.get(4));
        } else if (scoreboardList.size() == 3) {
            scoreBoardAndOpenCardContainer = new VBox(scoreboardList.get(0), scoreboardList.get(1), scoreboardList.get(2), openCardList.get(0), openCardList.get(1), openCardList.get(2), openCardList.get(3), openCardList.get(4));
        } else if (scoreboardList.size() == 4) {
            scoreBoardAndOpenCardContainer = new VBox(scoreboardList.get(0), scoreboardList.get(1), scoreboardList.get(2), scoreboardList.get(3), openCardList.get(0), openCardList.get(1), openCardList.get(2), openCardList.get(3), openCardList.get(4));
        } else {
            scoreBoardAndOpenCardContainer = new VBox(scoreboardList.get(0), scoreboardList.get(1), scoreboardList.get(2), scoreboardList.get(3), scoreboardList.get(4), openCardList.get(0), openCardList.get(1), openCardList.get(2), openCardList.get(3), openCardList.get(4));
        }
        scoreBoardAndOpenCardContainer.setLayoutX(1380);
        scoreBoardAndOpenCardContainer.setPrefHeight(310);
        return scoreBoardAndOpenCardContainer;
    }

    public void moveToNextPlayer(FlowPane actionFlowPane) {
        turn += 1;
        if (turn > board.playerList.size() - 1) {
            turn = 0;
        }
        int actionFlowPaneSize = actionFlowPane.getChildren().size();
        if (actionFlowPaneSize > 0) {
            actionFlowPane.getChildren().subList(0, actionFlowPaneSize).clear();
        }
        discardedTickets = 0;

        Label spacerLabel1 = new Label();
        spacerLabel1.setPrefWidth(1850);
        spacerLabel1.setPrefHeight(90);
        Label spacerLabel2 = new Label();
        spacerLabel2.setPrefWidth(20);
        Label spacerLabel3 = new Label();
        spacerLabel3.setPrefWidth(20);
        Label spacerLabel4 = new Label();
        spacerLabel4.setPrefWidth(20);
        drawTicketsButton.setText("Draw Tickets");
        drawTicketsButton.setFont(Font.font(45));
        buildTracksButton.setText("Build Tracks");
        buildTracksButton.setFont(Font.font(45));
        drawCardsButton.setText("Draw Cards");
        drawCardsButton.setFont(Font.font(45));
        FlowPane cardContainer = new FlowPane();
        VBox ticketContainer1 = new VBox();
        VBox ticketContainer2 = new VBox();
        List<ImageView> playerCardsImages = new ArrayList<>();
        for (int i = 0; i < board.playerList.get(turn).cards.size(); i++) {
            if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.red) {
                ImageView imageView1 = new ImageView("resources/RedCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.orange) {
                ImageView imageView1 = new ImageView("resources/OrangeCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.yellow) {
                ImageView imageView1 = new ImageView("resources/YellowCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.green) {
                ImageView imageView1 = new ImageView("resources/GreenCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.blue) {
                ImageView imageView1 = new ImageView("resources/BlueCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.pink) {
                ImageView imageView1 = new ImageView("resources/PinkCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.black) {
                ImageView imageView1 = new ImageView("resources/BlackCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.white) {
                ImageView imageView1 = new ImageView("resources/WhiteCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else {
                ImageView imageView1 = new ImageView("resources/LocoCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
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
            ticketLabel.setStyle("-fx-background-color: white;");
            ticketLabelList.add(ticketLabel);
        }
        Label ticketHeading = new Label();
        ticketHeading.setText("Tickets:");
        ticketHeading.setStyle("-fx-background-color: white;");
        ticketContainer1.getChildren().add(ticketHeading);
        Label spacerHeading = new Label();
        spacerHeading.setFont(Font.font(17));
        ticketContainer2.getChildren().add(spacerHeading);
        if (ticketLabelList.size() < 6) {
            for (Label label : ticketLabelList) {
                label.setFont(Font.font(30));
            }
            for (Label label : ticketLabelList) {
                ticketContainer1.getChildren().add(label);
            }
            ticketHeading.setFont(Font.font(30));
        } else {
            for (Label label : ticketLabelList) {
                label.setFont(Font.font(17));
            }
            for (int j = 0; j < ticketLabelList.size() / 2; j++) {
                ticketContainer1.getChildren().add(ticketLabelList.get(j));
            }
            for (int k = 0; k < ticketLabelList.size() / 2; k++) {
                ticketContainer2.getChildren().add(ticketLabelList.get(k + ticketLabelList.size() / 2));
            }
            ticketHeading.setFont(Font.font(17));

        }

        actionFlowPane.getChildren().add(spacerLabel1);
        actionFlowPane.getChildren().add(drawCardsButton);
        actionFlowPane.getChildren().add(spacerLabel2);
        actionFlowPane.getChildren().add(drawTicketsButton);
        actionFlowPane.getChildren().add(spacerLabel3);
        actionFlowPane.getChildren().add(buildTracksButton);
        for (ImageView playerCardsImage : playerCardsImages) {
            cardContainer.getChildren().add(playerCardsImage);
        }

        actionFlowPane.getChildren().add(cardContainer);
        actionFlowPane.getChildren().add(ticketContainer1);
        actionFlowPane.getChildren().add(spacerLabel4);
        actionFlowPane.getChildren().add(ticketContainer2);
        drawTicketsButton.setOnAction(event -> drawTickets(actionFlowPane));
        int areaFlowPaneSize = playerAreaContainer.getChildren().size();
        if (areaFlowPaneSize > 0) {
            playerAreaContainer.getChildren().subList(0, areaFlowPaneSize).clear();
        }
        Label playerName = new Label(board.playerList.get(turn).name);
        playerName.setPrefWidth(1850);
        playerName.setAlignment(Pos.CENTER);
        playerName.setFont(Font.font(50));
        if (board.playerList.get(turn).playerColor == PlayerColor.black) {
            playerName.setTextFill(Color.WHITE);
        } else {
            playerName.setTextFill(Color.BLACK);
        }

        Rectangle playerArea = new Rectangle();
        if (board.playerList.get(turn).playerColor == PlayerColor.black) {
            playerArea.setFill(Color.BLACK);
            playerName.setStyle("-fx-background-color: black;");
        } else if (board.playerList.get(turn).playerColor == PlayerColor.blue) {
            playerArea.setFill(Color.BLUE);
            playerName.setStyle("-fx-background-color: blue;");
        } else if (board.playerList.get(turn).playerColor == PlayerColor.red) {
            playerArea.setFill(Color.RED);
            playerName.setStyle("-fx-background-color: red;");
        } else if (board.playerList.get(turn).playerColor == PlayerColor.green) {
            playerArea.setFill(Color.GREEN);
            playerName.setStyle("-fx-background-color: green;");
        } else {
            playerArea.setFill(Color.YELLOW);
            playerName.setStyle("-fx-background-color: yellow;");
        }
        playerArea.setHeight(287.5);
        playerArea.setWidth(1850);
        playerArea.setStroke(Color.BLACK);
        playerArea.setStrokeType(StrokeType.INSIDE);
        playerAreaContainer.getChildren().add(playerName);
        playerAreaContainer.getChildren().add(playerArea);
        playerAreaContainer.setLayoutY(870);
        playerAreaContainer.setPrefHeight(100);
        playerAreaContainer.setPrefWidth(600);

    }

    int discardedTickets = 0;

    public void discardTicket(VBox vbox, Button drawnTicket, int ticketPosition) {
        if (discardedTickets < 2) {
            vbox.getChildren().remove(drawnTicket);
            board.ticketList.add(board.playerList.get(turn).tickets.get(ticketPosition));
            board.playerList.get(turn).tickets.remove(ticketPosition);
            discardedTickets += 1;
        }
    }

    public void Continue(FlowPane actionFlowPane) {
        int actionFlowPaneSize = actionFlowPane.getChildren().size();
        if (actionFlowPaneSize > 0) {
            actionFlowPane.getChildren().subList(0, actionFlowPaneSize).clear();
        }
        Label spacerLabel1 = new Label();
        spacerLabel1.setPrefWidth(1850);
        spacerLabel1.setPrefHeight(90);
        FlowPane cardContainer = new FlowPane();
        List<ImageView> playerCardsImages = new ArrayList<>();
        for (int i = 0; i < board.playerList.get(turn).cards.size(); i++) {
            if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.red) {
                ImageView imageView1 = new ImageView("resources/RedCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.orange) {
                ImageView imageView1 = new ImageView("resources/OrangeCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.yellow) {
                ImageView imageView1 = new ImageView("resources/YellowCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.green) {
                ImageView imageView1 = new ImageView("resources/GreenCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.blue) {
                ImageView imageView1 = new ImageView("resources/BlueCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.pink) {
                ImageView imageView1 = new ImageView("resources/PinkCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.black) {
                ImageView imageView1 = new ImageView("resources/BlackCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else if (board.playerList.get(turn).cards.get(i).cardColor == CardColor.white) {
                ImageView imageView1 = new ImageView("resources/WhiteCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            } else {
                ImageView imageView1 = new ImageView("resources/LocoCard.jpg");
                imageView1.setFitHeight(100);
                imageView1.setFitWidth(75);
                imageView1.setPickOnBounds(true);
                imageView1.setPreserveRatio(true);
                imageView1.setRotate(-90);
                playerCardsImages.add(imageView1);
            }
        }
        for (ImageView playerCardsImage : playerCardsImages) {
            cardContainer.getChildren().add(playerCardsImage);
        }
        actionFlowPane.getChildren().add(spacerLabel1);
        actionFlowPane.getChildren().add(cardContainer);
        List<Label> ticketLabelList = new ArrayList<>();
        for (int i = 0; i < board.playerList.get(turn).tickets.size(); i++) {
            Label ticketLabel = new Label();
            ticketLabel.setText(board.playerList.get(turn).tickets.get(i).source + " -> " + board.playerList.get(turn).tickets.get(i).destination + ", " + board.playerList.get(turn).tickets.get(i).value);
            ticketLabel.setStyle("-fx-background-color: white;");
            ticketLabelList.add(ticketLabel);
        }
        VBox ticketContainer1 = new VBox();
        Label ticketHeading = new Label();
        ticketHeading.setText("Tickets:");
        ticketHeading.setStyle("-fx-background-color: white;");
        ticketContainer1.getChildren().add(ticketHeading);
        VBox ticketContainer2 = new VBox();
        Label spacerLabel = new Label();
        spacerLabel.setFont(Font.font(25));
        Label containerSpacer = new Label();
        containerSpacer.setPrefWidth(20);
        Label containerSpacer2 = new Label();
        containerSpacer2.setPrefWidth(20);
        ticketContainer2.getChildren().add(spacerLabel);
        Button endTurnButton = new Button();
        endTurnButton.setText("End Turn");
        endTurnButton.setFont(Font.font(50));
        if (ticketLabelList.size() < 6) {
            for (Label label : ticketLabelList) {
                label.setFont(Font.font(27));
            }
            for (Label label : ticketLabelList) {
                ticketContainer1.getChildren().add(label);
            }
            ticketHeading.setFont(Font.font(25));
            actionFlowPane.getChildren().add(ticketContainer1);
        } else {
            for (Label label : ticketLabelList) {
                label.setFont(Font.font(27));
            }
            for (int j = 0; j < ticketLabelList.size() / 2; j++) {
                ticketContainer1.getChildren().add(ticketLabelList.get(j));
            }
            for (int k = 0; k < ticketLabelList.size() / 2; k++) {
                ticketContainer2.getChildren().add(ticketLabelList.get(k + ticketLabelList.size() / 2));
            }
            ticketHeading.setFont(Font.font(25));
            actionFlowPane.getChildren().add(ticketContainer1);
            actionFlowPane.getChildren().add(containerSpacer);
            actionFlowPane.getChildren().add(ticketContainer2);
            actionFlowPane.getChildren().add(containerSpacer2);
        }
        actionFlowPane.getChildren().add(endTurnButton);
        endTurnButton.setOnAction(event -> moveToNextPlayer(actionFlowPane));
    }

    public void drawCards(FlowPane actionFlowPane) {
        drawCardsClicked = true;
        actionFlowPane.getChildren().remove(drawCardsButton);
        actionFlowPane.getChildren().remove(drawTicketsButton);
        actionFlowPane.getChildren().remove(buildTracksButton);
        Label drawCardsInstructionLabel = new Label();
        drawCardsInstructionLabel.setText("Click either 1 locomotive card from the open cards or a total of 2 non-locomotive cards from the open cards or the draw pile.");
        drawCardsInstructionLabel.setFont(Font.font(15));
        drawCardsInstructionLabel.setStyle("-fx-background-color: white;");
        actionFlowPane.getChildren().add(drawCardsInstructionLabel);
    }

    //    Used for drawing tickets action
    public void drawTickets(FlowPane actionFlowPane) {
        actionFlowPane.getChildren().remove(drawCardsButton);
        actionFlowPane.getChildren().remove(drawTicketsButton);
        actionFlowPane.getChildren().remove(buildTracksButton);
        board.playerList.get(turn).drawTickets(board.ticketList);
        VBox drawnTicketsContainer = new VBox();
        Label heading = new Label();
        heading.setText("New Tickets:");
        heading.setStyle("-fx-background-color: white;");
        heading.setFont(Font.font(17));
        drawnTicketsContainer.getChildren().add(heading);
        for (int i = 1; i < 4; i++) {
            Button drawnTicket = new Button();
            drawnTicket.setText(board.playerList.get(turn).tickets.get(board.playerList.get(turn).tickets.size() - i).source + " -> " + board.playerList.get(turn).tickets.get(board.playerList.get(turn).tickets.size() - i).destination + ", " + board.playerList.get(turn).tickets.get(board.playerList.get(turn).tickets.size() - i).value);
            int ticketPosition = board.playerList.get(turn).tickets.size() - i;
            drawnTicket.setFont(Font.font(20));
            drawnTicketsContainer.getChildren().add(drawnTicket);
            drawnTicket.setOnAction(event -> discardTicket(drawnTicketsContainer, drawnTicket, ticketPosition));
        }
        Label discardInstructions = new Label();
        discardInstructions.setText("Click to discard");
        discardInstructions.setStyle("-fx-background-color: white;");
        discardInstructions.setFont(Font.font(17));
        drawnTicketsContainer.getChildren().add(discardInstructions);
        Button continueButton = new Button();
        continueButton.setText("Continue");
        continueButton.setFont(Font.font(17));
        continueButton.setOnAction(event -> Continue(actionFlowPane));
        drawnTicketsContainer.getChildren().add(continueButton);
        actionFlowPane.getChildren().add(drawnTicketsContainer);
    }
}
