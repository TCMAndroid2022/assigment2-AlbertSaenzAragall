package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Game {

    @PrimaryKey(autoGenerate = true) //preguntar https://developer.android.com/reference/androidx/room/PrimaryKey#autoGenerate()
    @NonNull
    public int id;

    @ColumnInfo(name = "player")
    public String player;

    @ColumnInfo(name = "punctuation")
    public int punctuation;

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
