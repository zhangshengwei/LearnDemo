package com.manggeek.android.geek.view.listener;

import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.manggeek.android.geek.R;


/**
 * 加载更多
 */
public class LoadMoreListener implements OnScrollListener {

    private boolean isLastRow = false;
    private boolean isMore = true;
    private View footerView;
    private LoadMoreCallBack callBack;
    private int mCurrentfirstVisibleItem = 0;
    private SparseArray recordSp = new SparseArray(0);


    public LoadMoreListener(ListView listView, LayoutInflater inflater, LoadMoreCallBack callBack) {
        View footer = inflater.inflate(R.layout.view_footer_view, null);
        footerView = footer.findViewById(R.id.footer_view);
        listView.addFooterView(footer);
        this.callBack = callBack;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (isLastRow && scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
            isMore = false;
            footerView.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isMore = true;
                    callBack.loadMore(footerView);
                }
            }, 2000);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        isLastRow = isMore && (firstVisibleItem + visibleItemCount) == totalItemCount;
        mCurrentfirstVisibleItem = firstVisibleItem;
        View firstView = view.getChildAt(0);
        if (null != firstView) {
            ItemRecod itemRecord = (ItemRecod) recordSp.get(firstVisibleItem);
            if (null == itemRecord) {
                itemRecord = new ItemRecod();
            }
            itemRecord.height = firstView.getHeight();
            itemRecord.top = firstView.getTop();
            recordSp.append(firstVisibleItem, itemRecord);
            int h = getScrollY();//滚动距离
            callBack.onScroll(h);
        }
    }

    public interface LoadMoreCallBack {
        void loadMore(View footerView);
        void onScroll(int y);
    }

    public View getFooterView() {
        return footerView;
    }

    private int getScrollY() {
        int height = 0;
        for (int i = 0; i < mCurrentfirstVisibleItem; i++) {
            ItemRecod itemRecod = (ItemRecod) recordSp.get(i);
            if (itemRecod != null) {
                height += itemRecod.height;
            }
        }
        ItemRecod itemRecod = (ItemRecod) recordSp.get(mCurrentfirstVisibleItem);
        if (null == itemRecod) {
            itemRecod = new ItemRecod();
        }
        return height - itemRecod.top;
    }

    class ItemRecod {
        int height = 0;
        int top = 0;
    }

}
