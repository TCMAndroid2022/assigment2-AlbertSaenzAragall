package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.Game;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class AppViewModel extends AndroidViewModel {
    private DatabaseController repository;
    private LiveData<List<User>> allUsers;

    public AppViewModel(@NonNull Application application) {
        super(application);
        repository = new DatabaseController(application);
        allUsers = repository.getAllUsers();
    }

    public LiveData<List<Game>> finGameByPlayer(String player){
        return repository.findGameByPlayer(player);
    }

    public void addGame(String player, double punctuation){
        repository.addGame(player, punctuation);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<User> findByNickName(String nickname){
        return repository.findByNickname(nickname);
    }

    public void addUser(String nickname, double points, int games){
        repository.addUser(nickname, points, games);
    }
}
