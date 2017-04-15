package com.myworks.jithin.malappuram.main_category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.model.MainCategoryItems;
import com.myworks.jithin.malappuram.sub_category.SubCategoryActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jithin on 24/3/17.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder> {

    private List<MainCategoryItems> mainCategoryItemses;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category_tittle;
        public ImageView category_image;
        public RelativeLayout rl_main;

        public MyViewHolder(View view) {
            super(view);
            category_tittle = (TextView) view.findViewById(R.id.tv_main_item);
            category_image = (ImageView) view.findViewById(R.id.iv_main_item);
            rl_main = (RelativeLayout) view.findViewById(R.id.rl_iv_main_category);
        }
    }


    public HomeRecyclerAdapter(Context context,List<MainCategoryItems> mainCategoryItemses) {
        this.mainCategoryItemses = mainCategoryItemses;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String base = "http://spotmyservice.com/media/pics/";

        final MainCategoryItems items = mainCategoryItemses.get(position);
        holder.category_tittle.setText(items.getItem_name().toString());
//        Picasso.with(context).load(base.trim()+items.getImage_url().trim()).resize(100,100).centerCrop().into(holder.category_image);
        Glide.with(context).load(base.trim()+items.getImage_url().trim()).into(holder.category_image);
        holder.rl_main.setBackgroundColor(items.getmColor());
        holder.category_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainCategorySelectedListener!=null){
                    mainCategorySelectedListener.itemSelectedListener(items.getId());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mainCategoryItemses.size();
    }
    public interface MainCategorySelectedListener{
        public void itemSelectedListener(String id);
    }


   public  MainCategorySelectedListener mainCategorySelectedListener;
}
