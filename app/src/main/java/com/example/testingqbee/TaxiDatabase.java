package com.example.testingqbee;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Taxi.class, Proek.class, Paek.class}, version = 1)
public abstract class TaxiDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}


