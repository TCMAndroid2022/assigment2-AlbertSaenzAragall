package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.Game;

public class AllGamesAdapter extends RecyclerView.Adapter<AllGamesAdapter.GamesHolder>{

    public class GamesHolder extends RecyclerView.ViewHolder{

        private TextView game_nickname;
        private TextView game_points;
        private TextView game_id;

        public GamesHolder(@NonNull View itemView) {
            super(itemView);
            game_nickname = itemView.findViewById(R.id.game_nickname);
            game_points = itemView.findViewById(R.id.game_points);
            game_id = itemView.findViewById(R.id.game_id);
        }
    }

    private List<Game> games = new ArrayList<>();

    @NonNull
    @Override
    public GamesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_row, parent, false);
        return new GamesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesHolder holder, int position) {
        Game currentGame = games.get(position);
        holder.game_nickname.setText(currentGame.getPlayer());
        holder.game_points.setText(String.valueOf(currentGame.getPunctuation()));
        holder.game_id.setText(String.valueOf(currentGame.getId()));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public void setGames(List<Game> games){
        this.games = games;
        notifyDataSetChanged();
    }
}
