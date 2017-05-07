package com.myworks.jithin.malappuram.itemList;

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
import com.myworks.jithin.malappuram.main_category.HomeRecyclerAdapter;
import com.myworks.jithin.malappuram.model.ListItems;
import com.myworks.jithin.malappuram.model.MainCategoryItems;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jithin on 29/4/17.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<ListItems> mListItems;

    public ListViewAdapter(Context context, List<ListItems> mListItems) {
        this.mContext = context;
        this.mListItems = mListItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);

        return new ListViewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String base = "http://spotmyservice.com//media/listings/";

        final ListItems items = mListItems.get(position);
        Picasso.with(mContext).load(base.trim() + items.getImageUrl().trim()).into(holder.iv_list);
        //   Glide.with(mContext).load(base.trim() + items.getImageUrl().trim()).into(holder.iv_list);
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
