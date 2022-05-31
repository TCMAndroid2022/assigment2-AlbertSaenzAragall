package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.Games;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

@Dao
public interface AppDao {

    //Games
    @Query("SELECT * FROM Games WHERE player = :player")
    List<Games> findByPlayer(String player);

    //User
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE nickname = :nickname")
    User findByNickname(String nickname);

    @Update
    void update(User user);

    @Insert
    void addNewUser(User user);
}
