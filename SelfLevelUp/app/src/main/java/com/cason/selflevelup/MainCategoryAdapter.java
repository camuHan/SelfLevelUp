package com.cason.selflevelup;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder> {
    private Context mContext;

//    private ArrayList<AlbumVO> list_album;
    private ArrayList<Integer> mCatImageResId;
    private ArrayList<String> mCatStringResId;

    public AdapterView.OnItemClickListener mOnItemClickListener = null;

    public class MainCategoryViewHolder extends RecyclerView.ViewHolder {
        private Button mBtnCategory;
        private TextView mTbCategory;

        public MainCategoryViewHolder(View convertView) {
            super(convertView);
            mBtnCategory = convertView.findViewById(R.id.main_category_button);
            mTbCategory = convertView.findViewById(R.id.main_category_text);
        }
    }

    public MainCategoryAdapter(Context ctx, ArrayList<Integer> imageList, ArrayList<String> titleList){
        mContext = ctx;
        mCatImageResId = imageList;
        mCatStringResId = titleList;
    }

    @NonNull
    @Override
    public MainCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.main_category_item, parent, false);
        return new MainCategoryViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCategoryViewHolder holder, int position) {
        holder.mBtnCategory.setBackgroundResource(mCatImageResId.get(position));
        holder.mTbCategory.setText(mCatStringResId.get(position));
        holder.mTbCategory.setTextSize(15);

        ObjectAnimator animation = ObjectAnimator.ofFloat(holder.mBtnCategory, "alpha", 0f, 1f);
        animation.setDuration(1000);
        animation.start();

        ObjectAnimator animation2 = ObjectAnimator.ofFloat(holder.mTbCategory, "translationY", 50f);
        animation2.setDuration(700);
        animation2.start();


//        AnimatorSet bouncer = new AnimatorSet();
//        bouncer.play(bounceAnim).before(squashAnim1);
//        bouncer.play(squashAnim1).with(squashAnim2);
//        ValueAnimator fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f, 0f);
//        fadeAnim.setDuration(250);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(bouncer).before(fadeAnim);
//        animatorSet.start();
    }

    @Override
    public int getItemCount() {
        return mCatImageResId.size();
    }
}
