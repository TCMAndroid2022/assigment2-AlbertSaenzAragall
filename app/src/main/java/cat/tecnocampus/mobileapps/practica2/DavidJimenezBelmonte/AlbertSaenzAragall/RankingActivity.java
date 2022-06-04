package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppViewModel;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class RankingActivity extends AppCompatActivity {

    private LiveData<List<User>> usersList;
    private RecyclerView recyclerView;
    private AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.Ranking);

        recyclerView = findViewById(R.id.ranking);
        appViewModel = new AppViewModel(getApplication());

        usersList = appViewModel.getAllUsers();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(usersList);
        recyclerView.setAdapter(recyclerAdapter);
    }

}