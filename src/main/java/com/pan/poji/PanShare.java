package com.pan.poji;

import java.util.Date;

public class PanShare {

    private int id;
    private int left;
    private int right;
    private String chat;
    private Date time;

    public PanShare() {
    }

    public PanShare(int id, int left, int right, String chat, Date time) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.chat = chat;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PanShare{" +
                "id=" + id +
                ", left=" + left +
                ", right=" + right +
                ", chat='" + chat + '\'' +
                ", time=" + time +
                '}';
    }
}
