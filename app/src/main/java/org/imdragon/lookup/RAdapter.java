package org.imdragon.lookup;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.PlaceViewHolder> {
    public Context mContext;
    List<Place> places;

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView placeTitle;
        ImageView placePhoto;
        TextView placeTags;


        PlaceViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            placeTitle = (TextView) v.findViewById(R.id.place_title);
            placePhoto = (ImageView) v.findViewById(R.id.firstPic);
            placeTags = (TextView) v.findViewById(R.id.place_tags);

        }
    }

    RAdapter(Context context, List<Place> places) {
        this.places = places;
        this.mContext = context;
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return places.size();
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.place_card_layout, viewGroup, false);
        PlaceViewHolder pvh = new PlaceViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        holder.placeTitle.setText(places.get(position).title);
        holder.placeTags.setText(places.get(position).tags);
//        holder.placePhoto.setImageResource(places.get(position).photos);
        Picasso.with(mContext).load("https://c1.staticflickr.com/3/2725/4337185495_582fcb963d.jpg").into(holder.placePhoto);
    }


    /**
     * Called by RecyclerView when it starts observing this Adapter.
     * <p/>
     * Keep in mind that same adapter may be observed by multiple RecyclerViews.
     *
     * @param recyclerView The RecyclerView instance which started observing this adapter.
     * @see #onDetachedFromRecyclerView(RecyclerView)
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
