package com.myworks.jithin.malappuram.tourist_spot_lisitng;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.model.ListItems;

import java.util.List;

/**
 * Created by jithin on 3/5/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private List<ListItems> mListItems;

    public RecyclerAdapter(Context context, List<ListItems> mListItems) {
        this.mContext = context;
        this.mListItems = mListItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);

        return new RecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        String base = "http://spotmyservice.com//media/listings/";

        final ListItems items = mListItems.get(position);
//        Picasso.with(context).load(base.trim()+items.getImage_url().trim()).resize(100,100).centerCrop().into(holder.category_image);
        Glide.with(mContext).load(base.trim() + items.getImageUrl().trim()).into(holder.iv_list);
        holder.category_tittle.setText(items.getItemName());
        Log.d("ImagePAth", base.trim() + items.getImageUrl().trim());
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category_tittle;
        public ImageView favourite, iv_list;
        public RelativeLayout rl_main;

        public MyViewHolder(View view) {
            super(view);
            category_tittle = (TextView) view.findViewById(R.id.tvListItemName);
            favourite = (ImageView) view.findViewById(R.id.favourite);
            iv_list = (ImageView) view.findViewById(R.id.iv_listView);
        }
    }

}