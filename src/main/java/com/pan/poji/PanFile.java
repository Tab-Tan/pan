package com.pan.poji;

import java.util.Date;

public class PanFile {

    private int id;
    private Byte open;
    private String url;
    private String fname;
    private int uid;//上传者
    private Date uptime;
    private int colid;

    public PanFile(int id, Byte open, String url, String fname, int uid, Date uptime, int colid, int count) {
        this.id = id;
        this.open = open;
        this.url = url;
        this.fname = fname;
        this.uid = uid;
        this.uptime = uptime;
        this.colid = colid;
        this.count = count;
    }

    public int getColid() {
        return colid;
    }

    public void setColid(int colid) {
        this.colid = colid;
    }

    @Override
    public String toString() {
        return "PanFile{" +
                "id=" + id +
                ", open=" + open +
                ", url='" + url + '\'' +
                ", fname='" + fname + '\'' +
                ", uid=" + uid +
                ", uptime=" + uptime +
                ", colid=" + colid +
                ", count=" + count +
                '}';
    }

    private int count;

    public PanFile() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getOpen() {
        return open;
    }

    public void setOpen(Byte open) {
        this.open = open;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
