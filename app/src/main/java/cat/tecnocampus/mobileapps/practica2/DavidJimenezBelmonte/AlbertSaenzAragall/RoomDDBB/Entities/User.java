package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nickname")
    public String nickname;

    @ColumnInfo(name = "points")
    public int points;

    @ColumnInfo(name = "games")
    public int games;

    public void setNickname(@NonNull String nickname) {
        this.nickname = nickname;
    }

    public User(@NonNull String nickname, int points, int games) {
        this.nickname = nickname;
        this.points = points;
        this.games = games;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
