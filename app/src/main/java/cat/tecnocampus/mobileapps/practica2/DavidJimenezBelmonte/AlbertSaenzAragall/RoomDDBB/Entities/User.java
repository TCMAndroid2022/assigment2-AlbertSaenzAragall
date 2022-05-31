package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    @ColumnInfo(name = "nickname")
    public String nickname;

    @ColumnInfo(name = "points")
    public int points;

    @ColumnInfo(name = "games")
    public int games;
}
