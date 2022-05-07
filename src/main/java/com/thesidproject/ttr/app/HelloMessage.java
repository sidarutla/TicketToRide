package com.thesidproject.ttr.app;

public class HelloMessage {
    private String boardId;
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name, String boardId) {
        this.boardId = boardId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
}
