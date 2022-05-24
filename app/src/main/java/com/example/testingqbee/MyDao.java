package com.example.testingqbee;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void insertTaxi(Taxi taxi);

    @Insert
    public void insertPaek(Paek paek);

    @Insert
    public void insertProek(Proek proek);

    @Delete
    public void deleteTaxi(Taxi taxi);

    @Delete
    public void deletePaek(Paek paek);

    @Delete
    public void deleteProek(Proek proek);

    @Update
    public void updateTaxi(Taxi taxi);

    @Update
    public void updatePaek(Paek paek);

    @Update
    public void updateProek(Proek proek);

    @Query("select * from taxi")
    public List<Taxi> getTaxi();

    @Query("select * from Proek")
    public List<Proek> getProek();

    @Query("select * from Paek")
    public List<Paek> getPaek();

    @Query("SELECT Tname as field1, Tid as field2 " +
            "FROM Taxi")
    public List<ResultStringInt> getQuery4();

    @Query("SELECT Proekpoli as field1, Proekid as field2 " +
            "FROM Proek where Proekid = 1")
    public List<ResultStringInt> getQuery5();

    @Query("SELECT Paekdate as field1, idpak as field2 " +
            "FROM Paek where idpak > 5")
    public List<ResultStringInt> getQuery6();

}
