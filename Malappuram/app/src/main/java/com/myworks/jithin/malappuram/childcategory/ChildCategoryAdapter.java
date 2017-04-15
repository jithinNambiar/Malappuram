package com.myworks.jithin.malappuram.childcategory;

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
import com.myworks.jithin.malappuram.model.ChildCateogryItems;
import com.myworks.jithin.malappuram.webservice.webmodels.main_category.childcategory.ChildCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jithin on 26/3/17.
 */

public class ChildCategoryAdapter extends RecyclerView.Adapter<ChildCategoryAdapter.MyViewHolder> {

    private List<ChildCateogryItems> subCategoryItems;
    private Context context;
    public interface ChildcategoryAdapterListener{
        public void childCategortyAdapterListener();
    }
        ChildcategoryAdapterListener childcategoryAdapterListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category_tittle;
        public ImageView category_image;
        public RelativeLayout relativeLayout;

        public MyViewHolder(View view) {
            super(view);
            category_tittle = (TextView) view.findViewById(R.id.tv_child_item);
            category_image = (ImageView) view.findViewById(R.id.iv_child_item);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.rlChildCategory);
        }
    }


    public ChildCategoryAdapter(Context context,List<ChildCateogryItems> subCategoryItems) {
        this.subCategoryItems = subCategoryItems;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String base = "http://spotmyservice.com/media/pics/";

        final ChildCateogryItems subCategory = subCategoryItems.get(position);
        holder.category_tittle.setText(subCategory.getItem_name().toString());
//        Picasso.with(context).load(base.trim()+subCategory.getImage_url().trim()).resize(100,100).centerCrop().into(holder.category_image);
        Glide.with(context).load(base.trim()+subCategory.getImage_url().trim()).into(holder.category_image);

        holder.relativeLayout.setBackgroundColor(subCategory.getmColor());
        holder.category_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(childcategoryAdapterListener != null){
                    childcategoryAdapterListener.childCategortyAdapterListener();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return subCategoryItems.size();
    }
}
