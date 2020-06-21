package com.cason.selflevelup;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    String mTag = "HSH";
    Button mBtnTest;

    private RecyclerView mMainCategoryGridRecyclerView;
    private RecyclerView.LayoutManager mMainCategoryLayoutManager;
    private MainCategoryAdapter mMainCategoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(mTag, "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(mTag, "onViewCreated");
        mBtnTest = view.findViewById(R.id.button_first);
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("test1", 1);
                bundle.putString("test2", "success");
                bundle.putBoolean("test3", true);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });

        mMainCategoryGridRecyclerView = (RecyclerView) view.findViewById(R.id.main_category);
        mMainCategoryLayoutManager = new GridLayoutManager(getContext(), 2);
//        ViewGroup.LayoutParams layoutParams = mMainCategoryGridRecyclerView.getLayoutParams();
//        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
//        mMainCategoryGridRecyclerView.setLayoutParams(layoutParams);
        mMainCategoryGridRecyclerView.addItemDecoration(new MainCatDecoration(getContext()));
        mMainCategoryGridRecyclerView.setLayoutManager(mMainCategoryLayoutManager);

//        mAlbumAdapter = new AlbumAdapter(mContext, getAlbumList());
//        mAlbumAdapter.setOnItemClickListener(this);
        mMainCategoryAdapter = new MainCategoryAdapter(getContext(), getCategoryImageList(), getCategoryTitleList());
        mMainCategoryGridRecyclerView.setAdapter(mMainCategoryAdapter);
    }

    private ArrayList<Integer> getCategoryImageList(){
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(R.drawable.exercise);
        arrList.add(R.drawable.medicine);
        arrList.add(R.drawable.study);
        arrList.add(R.drawable.timetable);
        arrList.add(R.drawable.etc);
        arrList.add(R.drawable.another);
        return arrList;
    }

    private ArrayList<String> getCategoryTitleList(){
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("운동");
        arrList.add("건강식품");
        arrList.add("스터디");
        arrList.add("생활습관");
        arrList.add("기타");
        arrList.add("ETC");
        return arrList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(mTag, "onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(mTag, "onActivityCreated");
    }

    @Nullable
    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Log.e(mTag, "onCreateAnimator");
//        ObjectAnimator animation = ObjectAnimator.ofFloat(mBtnTest, "translationY", 100f);
//        animation.setDuration(1000);
//        animation.start();
        return super.onCreateAnimator(transit, enter, nextAnim);
    }
}
