package com.pan.poji;

public class PanFriend {

    private int id;
    private int left;
    private int right;

    public PanFriend() {
    }

    public PanFriend(int id, int left, int right) {
        this.id = id;
        this.left = left;
        this.right = right;
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

    @Override
    public String toString() {
        return "PanFriend{" +
                "id=" + id +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
