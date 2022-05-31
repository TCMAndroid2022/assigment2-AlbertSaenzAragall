package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Games {

    @PrimaryKey//(autoGenerate = true) Revisar xk podria servir
    public int id;

    @ColumnInfo(name = "player")
    public String player;

    @ColumnInfo(name = "punctuation")
    public String punctuation;
}
