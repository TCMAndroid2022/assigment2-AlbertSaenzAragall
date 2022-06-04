package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Game {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "player")
    private String player;

    @ColumnInfo(name = "punctuation")
    private int punctuation;

    public Game(String player, int punctuation) {
        this.player = player;
        this.punctuation = punctuation;
    }

    public int getId() {
        return id;
    }

    public String getPlayer() {
        return player;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }
}
