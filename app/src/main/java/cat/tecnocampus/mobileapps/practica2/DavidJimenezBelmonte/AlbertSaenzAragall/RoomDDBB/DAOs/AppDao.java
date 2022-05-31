package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.Game;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

@Dao
public interface AppDao {

    //Games
    @Query("SELECT * FROM Game WHERE player = :player")
    LiveData<List<Game>> findGameByPlayer(String player);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addGame(Game game);

    //User
    @Query("SELECT * FROM User")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM User WHERE nickname = :nickname")
    LiveData<User> findByNickname(String nickname);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

}
