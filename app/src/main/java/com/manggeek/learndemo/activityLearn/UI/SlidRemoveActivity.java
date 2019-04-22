package com.manggeek.learndemo.activityLearn.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.activityLearn.manager.SlidRemoveLayoutManager;
import com.manggeek.learndemo.control.BaseActivity;

/**
 * @Description: 卡片组侧边滑动
 * @Author: xianggu
 * @CreateDate: 2019/2/15 7:44 PM
 */
public class SlidRemoveActivity extends BaseActivity {

    private @FindViewById(id = R.id.recycler_view) RecyclerView mRecyclerView;
    private SlidRemoveLayoutManager mSlidRemoveLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slid_remove);
        initView();
    }

    private void initView() {
        mSlidRemoveLayoutManager = new SlidRemoveLayoutManager(2.0f, 0.85f);
        mRecyclerView.setLayoutManager(mSlidRemoveLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter());
    }

    /**
     * 适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private int[] imgs = {
                R.mipmap.skid_right_1,
                R.mipmap.skid_right_2,
                R.mipmap.skid_right_3,
                R.mipmap.skid_right_4,
                R.mipmap.skid_right_5,
                R.mipmap.skid_right_6,
                R.mipmap.skid_right_7,

        };
        String[] titles = {"Acknowl", "Belief", "Confidence", "Dreaming", "Happiness", "Confidence"};

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_slid, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
//            Glide.with(mActivity).load(imgs[position % 7]).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.imgBg);
            holder.tvTitle.setText(titles[position % 6]);
            holder.imgBg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(SkidRightActivity_1.this, SkidRightActivity_2.class);
//                    intent.putExtra("img", imgs[position % 7]);
//                    intent.putExtra("title", titles[position % 6]);
//                    Pair<View, String> p1 = Pair.create((View)holder.imgBg, "img_view_1");
//                    Pair<View, String> p2 = Pair.create((View)holder.tvTitle, "title_1");
//                    Pair<View, String> p3 = Pair.create((View)holder.tvBottom, "tv_bottom");
//                    ActivityOptionsCompat options = ActivityOptionsCompat.
//                            makeSceneTransitionAnimation(SkidRightActivity_1.this, p1,p2,p3);
//                    startActivity(intent,options.toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgBg;
            TextView tvTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                imgBg = itemView.findViewById(R.id.img_bg);
                tvTitle = itemView.findViewById(R.id.tv_title);
            }
        }
    }
}
