package com.myworks.jithin.malappuram.sub_category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myworks.jithin.malappuram.R;
import com.myworks.jithin.malappuram.model.SubCateogryItems;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jithin on 26/3/17.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {

    private List<SubCateogryItems> subCategoryItems;
    private Context context;
    public interface  SubCategoryAdapterListener{
        public void subCatAdapterListener(String id);
    }
    SubCategoryAdapterListener subCategoryAdapterListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category_tittle;
        public ImageView category_image;
        public RelativeLayout relativeLayout;

        public MyViewHolder(View view) {
            super(view);
            category_tittle = (TextView) view.findViewById(R.id.tv_sub_item);
            category_image = (ImageView) view.findViewById(R.id.iv_sub_item);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.rlSubCategory);
        }
    }


    public SubCategoryAdapter(Context context,List<SubCateogryItems> subCategoryItems) {
        this.subCategoryItems = subCategoryItems;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String base = "http://spotmyservice.com/media/pics/";

        final SubCateogryItems subCategory = subCategoryItems.get(position);
        holder.category_tittle.setText(subCategory.getItem_name().toString());
//        Picasso.with(context).load(base.trim()+subCategory.getImage_url().trim()).resize(100,100).centerCrop().into(holder.category_image);
        Glide.with(context).load(base.trim()+subCategory.getImage_url().trim()).into(holder.category_image);
        holder.relativeLayout.setBackgroundColor(subCategory.getmColor());
        holder.category_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(subCategoryAdapterListener != null){
                    subCategoryAdapterListener.subCatAdapterListener(subCategory.getId());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return subCategoryItems.size();
    }
}
