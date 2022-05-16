package com.example.testingqbee;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "Proek")
public class Proek {
    @PrimaryKey @ColumnInfo (name = "Proekid")
    private int id;

    @ColumnInfo (name = "Proekpoli")
    private String poli;

    @ColumnInfo (name = "Proekxwra")
    private String xwra;

    @ColumnInfo (name = "Proekdiarkeia")
    private int diarkeia;

    @ColumnInfo (name = "Proekeidos")
    private String eidos;

    @ColumnInfo (name = "Proeklatitude")
    private double lat;

    @ColumnInfo (name = "Proeklongitude")
    private double lon;

    public double getLat() { return lat; }

    public void setLat(double lat) { this.lat = lat; }

    public double getLon() { return lon; }

    public void setLon(double lon) { this.lon = lon; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getXwra() {
        return xwra;
    }

    public void setXwra(String xwra) {
        this.xwra = xwra;
    }

    public int getDiarkeia() {
        return diarkeia;
    }

    public void setDiarkeia(int diarkeia) {
        this.diarkeia = diarkeia;
    }

    public String getEidos() {
        return eidos;
    }

    public void setEidos(String eidos) {
        this.eidos = eidos;
    }
}
