package org.imdragon.lookup;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PlaceViewHolder> {

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView placeTitle;
        ImageView placePhoto;
        TextView placeTags;

        PlaceViewHolder (View v){
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            placeTitle = (TextView) v.findViewById(R.id.place_title);
            placePhoto = (ImageView) v.findViewById(R.id.firstPic);
            placeTags = (TextView) v.findViewById(R.id.place_tags);

        }
    }

}
