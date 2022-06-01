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
    public int id;

    @ColumnInfo(name = "player")
    public String player;

    @ColumnInfo(name = "punctuation")
    public int punctuation;

    public Game(String player, int punctuation) {
        this.player = player;
        this.punctuation = punctuation;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }
}
