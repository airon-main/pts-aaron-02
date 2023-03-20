package com.example.aironnews;

import android.media.Image;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.aironnews.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> localDataSet;

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNewsName;
        private final TextView tvNewsTime;
        private final ImageView imgNews;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvNewsName = (TextView) view.findViewById(R.id.newsName);
            tvNewsTime = (TextView) view.findViewById(R.id.newsTime);
            imgNews = (ImageView) view.findViewById(R.id.newsImg);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public NewsAdapter(ArrayList<News> dataSet) {
        localDataSet = dataSet;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String name = localDataSet.get(position).getName();
        String description = localDataSet.get(position).getDescription();
        String time = localDataSet.get(position).getTime();
        int image = localDataSet.get(position).getImages();

        viewHolder.tvNewsName.setText(name);
        viewHolder.tvNewsTime.setText(time);
        viewHolder.imgNews.setImageResource(image);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);

                intent.putExtra("name",name);
                intent.putExtra("description",description);
                intent.putExtra("image", image);

                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

