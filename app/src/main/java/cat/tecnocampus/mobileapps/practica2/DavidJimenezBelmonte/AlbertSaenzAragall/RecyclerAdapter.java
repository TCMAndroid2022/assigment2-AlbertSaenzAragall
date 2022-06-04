package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private LiveData<List<User>> usersList;

    public RecyclerAdapter(LiveData<List<User>> usersList) {
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user =usersList.getValue().get(position);
        holder.user.setText(user.getNickname());
        holder.points.setText(user.getPoints());
        holder.games.setText(user.getGames());
    }

    @Override
    public int getItemCount() {
        return usersList.getValue().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user, points, games;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user);
            points = itemView.findViewById(R.id.points);
            games = itemView.findViewById(R.id.games);
        }
    }
}
