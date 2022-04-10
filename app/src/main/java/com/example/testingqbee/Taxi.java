package com.example.testingqbee;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "Taxi" )
public class Taxi {
    @PrimaryKey @ColumnInfo(name = "Tid")
    private int id;

    @ColumnInfo(name = "Tname")
    private String name;

    @ColumnInfo(name = "Tadress")
    private String adress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
