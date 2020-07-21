package com.pan.poji;

public class PanCol {

    private int id;
    private int uid;
    private String colname;

    public PanCol(int id, int uid, String colname) {
        this.id = id;
        this.uid = uid;
        this.colname = colname;
    }

    public PanCol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getColname() {
        return colname;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }

    @Override
    public String toString() {
        return "PanCol{" +
                "id=" + id +
                ", uid=" + uid +
                ", colname='" + colname + '\'' +
                '}';
    }
}
