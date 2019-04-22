package com.manggeek.learndemo.Dialog;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.manggeek.android.geek.GeekActivity;
import com.manggeek.android.geek.GeekDialog;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshengwei
 * Time: 2018/12/3 11:14
 * describe: 底部选择Dialog
 */
public class SelectorDialog extends GeekDialog {

    private @FindViewById(id = R.id.listview) ListView listView;
    private @FindViewById(id = R.id.cancel) TextView cancel;
    private List<String> contentList = new ArrayList<>();

    private SelectorListener selectorListener;

    public interface SelectorListener{
        void choose(String name,int number);
    }
    /**
     * 弹框默认浮层
     *
     * @param activity
     */
    public SelectorDialog(GeekActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_selector,WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.BOTTOM);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public void ShowContentListener(List<String> contentList,SelectorListener selectorListener){
        this.contentList = contentList;
        this.selectorListener = selectorListener;
        listView.setAdapter(adapter);
    }


    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return contentList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_choose, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.nameTv.setText(contentList.get(position)+"");
            viewHolder.nameTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (selectorListener!=null) {
                        selectorListener.choose(contentList.get(position),position);
                        dismiss();
                    }
                }
            });
            return convertView;
        }


        class ViewHolder {
            private TextView nameTv;
            public ViewHolder(View view) {
                nameTv = (TextView) view.findViewById(R.id.name);
            }
        }
    };


}
