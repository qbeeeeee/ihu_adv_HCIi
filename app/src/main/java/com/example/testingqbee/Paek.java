package com.example.testingqbee;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Paek")
public class Paek {
    @PrimaryKey @ColumnInfo (name = "idpak")
    private int idpaketou;

    @ColumnInfo (name = "idgraf")
    private int idgrafeiou;

    @ColumnInfo (name = "idekd")
    private int idekdromis;

    @ColumnInfo (name = "Paekdate")
    private String date;

    @ColumnInfo (name = "Paekprice")
    private int price;

    public int getIdpaketou() {
        return idpaketou;
    }

    public void setIdpaketou(int idpaketou) {
        this.idpaketou = idpaketou;
    }

    public int getIdgrafeiou() {
        return idgrafeiou;
    }

    public void setIdgrafeiou(int idgrafeiou) {
        this.idgrafeiou = idgrafeiou;
    }

    public int getIdekdromis() {
        return idekdromis;
    }

    public void setIdekdromis(int idekdromis) {
        this.idekdromis = idekdromis;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
