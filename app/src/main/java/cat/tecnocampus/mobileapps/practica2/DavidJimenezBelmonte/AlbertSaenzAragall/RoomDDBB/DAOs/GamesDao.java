package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.DAOs;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.Games;

@Dao
public interface GamesDao {

    @Query("SELECT * FROM Games WHERE player = :player")
    List<Games> findByPlayer(String player);


}
