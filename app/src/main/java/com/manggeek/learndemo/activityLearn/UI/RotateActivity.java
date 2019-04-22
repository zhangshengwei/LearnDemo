package com.manggeek.learndemo.activityLearn.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Entity.RotateItemModel;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.activityLearn.manager.RotateItemTouchHelperCallback;
import com.manggeek.learndemo.activityLearn.manager.RotateLayoutManager;
import com.manggeek.learndemo.activityLearn.manager.RotateOnSlideListener;
import com.manggeek.learndemo.control.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 卡片旋转
 * @Author: xianggu
 * @CreateDate: 2019/2/15 7:40 PM
 */
public class RotateActivity extends BaseActivity {

    public static final int SLIDING_NONE = 1;
    public static final int SLIDING_LEFT = 1 << 2;
    public static final int SLIDING_RIGHT = 1 << 3;
    public static final int SLIDED_LEFT = 1;
    public static final int SLIDED_RIGHT = 1 << 2;
    public static final int DEFAULT_SHOW_ITEM = 3;
    public static final float DEFAULT_SCALE = 0.1f;
    public static final int DEFAULT_TRANSLATE_Y = 14;
    public static final float DEFAULT_ROTATE_DEGREE = 15f;

    private @FindViewById(id = R.id.recycler_view) RecyclerView mRecyclerView;

    private RotateLayoutManager mRotateLayoutManager;
    private ItemTouchHelper mItemTouchHelper;
    private RotateItemTouchHelperCallback mItemTouchHelperCallback;
    private MyAdapter mAdapter;

    private List<RotateItemModel> mList = new ArrayList<>();
    private int mLikeCount = 50;
    private int mDislikeCount = 50;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        initView();
        initListener();
    }

    private void initView() {
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

        addData();
        mItemTouchHelperCallback = new RotateItemTouchHelperCallback(mRecyclerView.getAdapter(),mList);
        mItemTouchHelper = new ItemTouchHelper(mItemTouchHelperCallback);
        mRotateLayoutManager = new RotateLayoutManager(mRecyclerView,mItemTouchHelper);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(mRotateLayoutManager);
    }

    private void initListener() {
        mItemTouchHelperCallback.setOnSlideListener(new RotateOnSlideListener() {
            @Override
            public void onSliding(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                if (direction == SLIDING_LEFT) {
                } else if (direction == SLIDING_RIGHT) {
                }
            }

            @Override
            public void onSlided(RecyclerView.ViewHolder viewHolder, Object o, int direction) {
                if (direction == SLIDED_LEFT) {
                    mDislikeCount--;
//                    mSmileView.setDisLike(mDislikeCount);
//                    mSmileView.disLikeAnimation();
                } else if (direction == SLIDED_RIGHT) {
                    mLikeCount++;
//                    mSmileView.setLike(mLikeCount);
//                    mSmileView.likeAnimation();
                }
                int position = viewHolder.getAdapterPosition();
//                Log.e(TAG, "onSlided--position:" + position);
            }

            @Override
            public void onClear() {
                addData();
            }
        });
    }

    private void addData() {

        int[] icons = {R.mipmap.header_icon_1, R.mipmap.header_icon_2, R.mipmap.header_icon_3,
                R.mipmap.header_icon_4, R.mipmap.header_icon_1, R.mipmap.header_icon_2};
        String[] titles = {"Acknowledging", "Belief", "Confidence", "Dreaming", "Happiness", "Confidence"};
        String[] says = {
                "Do one thing at a time, and do well.",
                "Keep on going never give up.",
                "Whatever is worth doing is worth doing well.",
                "I can because i think i can.",
                "Jack of all trades and master of none.",
                "Keep on going never give up.",
                "Whatever is worth doing is worth doing well.",
        };
        int[] bgs = {
                R.mipmap.img_slide_1,
                R.mipmap.img_slide_2,
                R.mipmap.img_slide_3,
                R.mipmap.img_slide_4,
                R.mipmap.img_slide_5,
                R.mipmap.img_slide_6
        };

        for (int i = 0; i < 6; i++) {
            mList.add(new RotateItemModel(bgs[i],titles[i],icons[i],says[i]));
        }

    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_rotate,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            RotateItemModel bean = mList.get(position);
            viewHolder.imgBg.setImageResource(bean.getItemBg());
            viewHolder.tvTitle.setText(bean.getTitle());
            viewHolder.userIcon.setImageResource(bean.getUserIcon());
            viewHolder.userSay.setText(bean.getUserSay());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imgBg;
            ImageView userIcon;
            TextView tvTitle;
            TextView userSay;
            public ViewHolder(View itemView){
                super(itemView);
                imgBg = itemView.findViewById(R.id.img_bg);
                userIcon = itemView.findViewById(R.id.img_user);
                tvTitle = itemView.findViewById(R.id.tv_title);
                userSay = itemView.findViewById(R.id.tv_user_say);
            }
        }
    };
}
