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
    private String nickname;

    @ColumnInfo(name = "points")
    private double points;

    @ColumnInfo(name = "games")
    private int games;


    public User(@NonNull String nickname, double points, int games) {
        this.nickname = nickname;
        this.points = points;
        this.games = games;
    }

    @NonNull
    public String getNickname() {
        return nickname;
    }

    public double getPoints() {
        return points;
    }

    public int getGames() {
        return games;
    }

    public void setNickname(@NonNull String nickname) {
        this.nickname = nickname;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
