package com.whogroup.Ship;

public class Ship {

    private String type;
    private boolean isdead;
    private int hits;
    private int position;

    public Ship(String type, int hits) {
        this.type = type;
        this.hits = hits;
    }

    @Override
    public String toString(){
        return (type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getHits() {
        return hits;
    }

    public boolean isIsdead() {
        return isdead;
    }

}