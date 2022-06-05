package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppViewModel;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.Game;

public class AllGamesActivity extends AppCompatActivity {

    private AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Player games");

        RecyclerView recyclerView = findViewById(R.id.games);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        AllGamesAdapter adapter = new AllGamesAdapter();
        recyclerView.setAdapter(adapter);

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        appViewModel.findGameByPlayer(getIntent().getStringExtra("nickname")).observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {
                adapter.setGames(games);
            }
        });
    }
}