package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.DAOs.AppDao;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.Game;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class DatabaseController {
    private AppDao appDao;
    private LiveData<List<User>> allUsers;

    public DatabaseController(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);

        appDao = db.appDao();
        allUsers = appDao.getAllUsers();
    }

    public LiveData<List<Game>> findGameByPlayer(String player){
        return appDao.findGameByPlayer(player);
    }

    public void addGame(String player, double punctuation) {
        Game current = new Game(player, punctuation);
        current.setPlayer(player);
        current.setPunctuation(punctuation);
        new insertAsyncTask(appDao).execute(current);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<User> findByNickname(String nickname){
        return appDao.findByNickname(nickname);
    }

    public void addUser(String nickname, double points, int games) {
        User current = new User(nickname, points, games);
        current.setNickname(nickname);
        current.setPoints(points);
        current.setGames(games);
        new insertAsyncTask(appDao).execute(current);
    }

    private static class insertAsyncTask {
        private AppDao asyncDao;
        private Executor executor = Executors.newSingleThreadExecutor();

        insertAsyncTask(AppDao dao) {
            asyncDao = dao;
        }

        public void execute(Game game) {
            this.doInBackgroundGame(game);
        }
        public void execute(User user) {
            this.doInBackgroundUser(user);
        }

        private void doInBackgroundGame(final Game game) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    asyncDao.addGame(game);
                }
            });
        }
        private void doInBackgroundUser(final User user) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    asyncDao.addUser(user);
                }
            });
        }

    }
}
