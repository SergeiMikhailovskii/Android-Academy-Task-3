package asus.example.com.exercise3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Actor> actors;
    private final LayoutInflater inflater;
    private final Context context;
    private OnItemClickListener<Actor> onItemClickListener;

    RecyclerViewAdapter(List<Actor> actors, Context context){
        this.context = context;
        this.actors = actors;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.preview_image_layout, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    fireItemClicked(position, actors.get(position));
                }
            }
        });
        return viewHolder;
    }

    private void fireItemClicked(int position, Actor actor){
        if (onItemClickListener!=null){
            onItemClickListener.onItemClicked(position, actor);
        }
    }

    void setOnItemClickListener(OnItemClickListener<Actor> listener){
        onItemClickListener = listener;
    }

    public interface OnItemClickListener<T>{
        void onItemClicked(int position, T item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Actor actor = actors.get(i);
        Glide.with(context).load(actor.getSmallImage()).into(viewHolder.avatar);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public final ImageView avatar;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);

        }



    }

}